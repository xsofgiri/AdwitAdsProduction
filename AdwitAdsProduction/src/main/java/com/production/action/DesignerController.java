package com.production.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.production.entity.CatArtInstruction;
import com.production.entity.CatNewAdType;
import com.production.entity.CatResult;
import com.production.entity.CsrToAdrepOptions;
import com.production.entity.Designer;
import com.production.entity.NoteSent;
import com.production.entity.NoteTeamLeadDesigner;
import com.production.entity.OrderFile;
import com.production.entity.Orders;
import com.production.entity.ProductionConversation;
import com.production.entity.QuestionTemplate;
import com.production.service.impl.CSRServiceBean;
import com.production.service.impl.OrderServiceBean;
import com.production.service.impl.UserServiceBean;
import com.production.util.Constants;
import com.production.util.EncryptionUtil;
import com.production.util.FTPUtil;
import com.production.util.FileUtil;
import com.production.util.SpringProperty;

@Controller
@RequestMapping("/designer")
public class DesignerController {

	@Autowired
	UserServiceBean userService;

	@Autowired
	CSRServiceBean csrService;

	@Autowired
	OrderServiceBean orderService;

	@RequestMapping(value = "/startdesign", method = RequestMethod.POST)
	public ResponseEntity<ByteArrayResource> displayHomePage(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {

				try {
					String slug = request.getParameter("slug");
					String orderId = request.getParameter("orderId");

					Orders orders = orderService.getOrderDetails(Integer.parseInt(orderId));

					// create a folder in ftp
					// createSlugFolder("/1128212/1128212_Sep27TestAd02_dm_T_999_V1");
					String slugFolder = "/" + orderId + "/" + slug;
					System.out.println("slugFolder : " + slugFolder);

					FTPUtil.createSlugFolder(slugFolder);

					// update status in the db
					CatResult catResult = new CatResult();
					catResult.setDesignerId(designer.getDesignerId());
					catResult.setSlug(slug);
					catResult.setSourcePath("sourcefile" + slugFolder);

					orderService.startDesign(orders, catResult);

					// download indd file

					String FILE_NAME = slug + ".indd";

					SpringProperty sProperty = new SpringProperty();
					String tmpLocation = sProperty.getPropertyValue("uploadTmp");

					System.out.println("tmpLocation : " + tmpLocation);

					File file2Download = new File(tmpLocation + "/indesign_template.indd");
					if (file2Download.exists()) {
						// get the mimetype
						String mimeType = URLConnection.guessContentTypeFromName(file2Download.getName());
						if (mimeType == null) {
							// unknown mimetype so set the mimetype to application/octet-stream
							mimeType = "application/octet-stream";
						}

						response.setContentType(mimeType);

						/**
						 * In a regular HTTP response, the Content-Disposition response header is a
						 * header indicating if the content is expected to be displayed inline in the
						 * browser, that is, as a Web page or as part of a Web page, or as an
						 * attachment, that is downloaded and saved locally.
						 * 
						 */

						/**
						 * Here we have mentioned it to show inline
						 */
						response.setHeader("Content-Disposition",
								String.format("inline; filename=\"" + FILE_NAME + "\""));

						// Here we have mentioned it to show as attachment
						// response.setHeader("Content-Disposition", String.format("attachment;
						// filename=\"" + file.getName() + "\""));

						response.setContentLength((int) file2Download.length());

						InputStream inputStream = new BufferedInputStream(new FileInputStream(file2Download));

						FileCopyUtils.copy(inputStream, response.getOutputStream());

					}

				} catch (Exception e) {

				}

//				model = new ModelAndView("redirect:/workstation");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@RequestMapping(value = "/orders/designad/{order_id}/", method = RequestMethod.GET)
	public ModelAndView displayEndDesign(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String sourceDirectory = catResult.getSourcePath();
				System.out.println("sourceDirectory : " + sourceDirectory);

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);

				model = new ModelAndView("/designer/designAd");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/designad/{order_id}/", method = RequestMethod.POST)
	public ModelAndView executeEndDesign(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String adNotes = request.getParameter("adNotes");
				if (Constants.isStringNotNull(adNotes)) {
					ProductionConversation pc = new ProductionConversation();
					pc.setDesignerId(designer.getDesignerId());
					pc.setMessage(adNotes);
					pc.setOrderId(order.getOrderId());

					orderService.addProductionConversation(pc);
				}

				orderService.endDesign(order, catResult);

				String sourceDirectory = catResult.getSourcePath();

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);

				model = new ModelAndView("/designer/designAd");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/{order_id}/uploadfile", method = RequestMethod.POST)
	public @ResponseBody String executeAddFile(MultipartHttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2,
			@RequestParam(value = "links", required = false) MultipartFile[] linksFiles,
			@RequestParam(value = "fonts", required = false) MultipartFile[] fontsFiles,
			@RequestParam(value = "tl_changes", required = false) MultipartFile[] tlChangesFiles,
			@RequestParam(value = "csr_changes", required = false) MultipartFile[] csrChangesFiles) {
		HttpSession session = request.getSession();
		String uploadResponse = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);
				System.out.println("orderId : " + orderId);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String sourceFilePath = "/" + orderId + "/" + catResult.getSlug();
				System.out.println("sourceFilePath : " + sourceFilePath);

				if (file1 != null) {
					System.out.println("Indesign file " + file1.getOriginalFilename());
					FTPUtil.uploadFile(sourceFilePath, file1);
				}
				if (file2 != null) {
					System.out.println("PDF file " + file2.getOriginalFilename());
					FTPUtil.uploadFile(sourceFilePath, file2);
				}

				if (linksFiles != null && linksFiles.length > 0) {
					FTPUtil.createFolder(sourceFilePath, Constants.ORDER_FOLDER_LINKS);
					for (MultipartFile file : linksFiles) {
						System.out.println(file != null ? file.getOriginalFilename() : "-");
						FTPUtil.uploadFile(sourceFilePath + "/" + Constants.ORDER_FOLDER_LINKS, file);
					}
				}

				if (fontsFiles != null && fontsFiles.length > 0) {
					FTPUtil.createFolder(sourceFilePath, Constants.ORDER_FOLDER_DOCUMENT_FONTS);
					for (MultipartFile file : fontsFiles) {
						System.out.println(file != null ? file.getOriginalFilename() : "-");
						FTPUtil.uploadFile(sourceFilePath + "/" + Constants.ORDER_FOLDER_DOCUMENT_FONTS, file);
					}
				}
				
				if (tlChangesFiles != null && tlChangesFiles.length > 0) {
					FTPUtil.createFolder(sourceFilePath, Constants.ORDER_FOLDER_TL_CHANGES);
					for (MultipartFile file : tlChangesFiles) {
						System.out.println(file != null ? file.getOriginalFilename() : "-");
						FTPUtil.uploadFile(sourceFilePath + "/" + Constants.ORDER_FOLDER_TL_CHANGES, file);
					}
				}
				
				if (csrChangesFiles != null && csrChangesFiles.length > 0) {
					FTPUtil.createFolder(sourceFilePath, Constants.ORDER_FOLDER_CSR_CHANGES);
					for (MultipartFile file : csrChangesFiles) {
						System.out.println(file != null ? file.getOriginalFilename() : "-");
						FTPUtil.uploadFile(sourceFilePath + "/" + Constants.ORDER_FOLDER_CSR_CHANGES, file);
					}
				}

			} else {
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return uploadResponse;
	}

	@RequestMapping(value = "/orders/{order_id}/deletefile", method = RequestMethod.POST)
	public @ResponseBody String executeDeleteFile(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {
		HttpSession session = request.getSession();
		String uploadResponse = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);
				System.out.println("orderId : " + orderId);

				String fileName = request.getParameter("dFile");
				System.out.println("fileName : " + fileName);

				String sourcePath = request.getParameter("sPath");
				System.out.println("sourcePath : " + sourcePath);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String sourceFilePath = catResult.getSourcePath();
				System.out.println("sourceFilePath : " + sourceFilePath);

				if ("INDD".equals(sourcePath) || "PDF".equals(sourcePath)) {
					FTPUtil.deleteFile(sourceFilePath, fileName);
				}
				if ("DOC".equals(sourcePath)) {
					sourceFilePath = sourceFilePath + "/" + Constants.ORDER_FOLDER_LINKS;
					FTPUtil.deleteFile(sourceFilePath, fileName);
				}
				if ("FONT".equals(sourcePath)) {
					sourceFilePath = sourceFilePath + "/" + Constants.ORDER_FOLDER_DOCUMENT_FONTS;
					FTPUtil.deleteFile(sourceFilePath, fileName);
				}
				
				if ("TL_CHANGES".equals(sourcePath)) {
					sourceFilePath = sourceFilePath + "/" + Constants.ORDER_FOLDER_TL_CHANGES;
					FTPUtil.deleteFile(sourceFilePath, fileName);
				}
				
				if ("CSR_CHANGES".equals(sourcePath)) {
					sourceFilePath = sourceFilePath + "/" + Constants.ORDER_FOLDER_CSR_CHANGES;
					FTPUtil.deleteFile(sourceFilePath, fileName);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return uploadResponse;
	}

	@RequestMapping(value = "/orders/designcheck/{order_id}/", method = RequestMethod.GET)
	public ModelAndView displayDesignCheck(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String sourceDirectory = catResult.getSourcePath();
				System.out.println("sourceDirectory : " + sourceDirectory);

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);

				ArrayList<NoteTeamLeadDesigner> qaNotesList = orderService.getDesignNotes(Constants.ORDER_NOTES_TL_QA);
				request.setAttribute(Constants.NOTES_TL_QA_LIST, qaNotesList);

				ArrayList<NoteTeamLeadDesigner> designerNotesList = orderService
						.getDesignNotes(Constants.ORDER_NOTES_TL_DESIGNER);
				request.setAttribute(Constants.NOTES_TL_DESIGNER_LIST, designerNotesList);

				model = new ModelAndView("/designer/designCheckAd");
			} else {
				model = new ModelAndView("/designer/login"); 
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/designcheck/{order_id}/", method = RequestMethod.POST)
	public ModelAndView executeDesignCheck(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String adStatus = request.getParameter("adStatus");
				String adNotes = request.getParameter("adNotes");
				if(adNotes!=null && "Other".equals(adNotes)) {
					adNotes = request.getParameter("adOtherNotes");
				}
				
				System.out.println("adStatus : "+adStatus);
				System.out.println("adNotes : "+adNotes);
				
 
				String operation = "";
				
				if(adStatus!=null && Constants.SEND_TO_QA.equals(adStatus)) {
					orderService.sendOrderToQA(order, catResult, designer);
					operation = "tl_QA"; 
				}else if(adStatus!=null && Constants.BACK_TO_DESIGNER.equals(adStatus)) {
					
					orderService.sendOrderBackToDesigner(order, catResult, designer);
					
					operation = "tl_designer";
				}else if(adStatus!=null && Constants.MAKE_CHANGES.equals(adStatus)) {
					orderService.orderMakeChangesByTL(order, catResult, designer);
					//operation = "tl_designer";
				}

				if (Constants.isStringNotNull(adNotes)) {
					ProductionConversation pc = new ProductionConversation();
					pc.setTlDesignerId(designer.getDesignerId());
					pc.setMessage(adNotes);
					pc.setOrderId(order.getOrderId());
					pc.setOperation(operation);

					orderService.addProductionConversation(pc);
				}
				
				
				String sourceDirectory = catResult.getSourcePath();

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);

				model = new ModelAndView("/designer/designCheckAd");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/qacheck/{order_id}/", method = RequestMethod.GET)
	public ModelAndView displayQADesign(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String sourceDirectory = catResult.getSourcePath();
				System.out.println("sourceDirectory : " + sourceDirectory);

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);


				ArrayList<NoteTeamLeadDesigner> designerNotesList = orderService
						.getDesignNotes(Constants.ORDER_NOTES_CSR_DESIGNER);
				request.setAttribute(Constants.NOTES_CSR_DESIGNER_LIST, designerNotesList);
				
				ArrayList<CsrToAdrepOptions> csrAdrepNotesList = orderService.getCSRToAdRepNotes();
				request.setAttribute(Constants.NOTES_CSR_ADREP_LIST, csrAdrepNotesList);
				
				model = new ModelAndView("/designer/qualityCheckAd");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	
	@RequestMapping(value = "/orders/qacheck/{order_id}/", method = RequestMethod.POST)
	public ModelAndView executeQualityCheck(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.CAT_RESULT_DETAIL, catResult);

				String adStatus = request.getParameter("adStatus");
				String adNotes = request.getParameter("adNotes");
				if(adNotes!=null && "Other".equals(adNotes)) {
					adNotes = request.getParameter("adOtherNotes");
				}
				
				System.out.println("adStatus : "+adStatus);
				System.out.println("adNotes : "+adNotes);
				
 
				String operation = "";
				
				if(adStatus!=null && Constants.SEND_TO_ADREP.equals(adStatus)) {
					orderService.sendOrderToAdRep(order, catResult, designer);
					
					if (Constants.isStringNotNull(adNotes)) {
						NoteSent noteSent = new NoteSent();
						noteSent.setNote(adNotes);
						noteSent.setOrderId(order.getOrderId());

						orderService.addNoteSent(noteSent);
					}
					
				}else if(adStatus!=null && Constants.BACK_TO_DESIGNER.equals(adStatus)) {
					
					orderService.sendOrderBackToDesignerFromCSR(order, catResult, designer);
					
					operation = "csr_designer";
					
					if (Constants.isStringNotNull(adNotes)) {
						ProductionConversation pc = new ProductionConversation();
						pc.setCsrId(designer.getDesignerId());
						pc.setMessage(adNotes);
						pc.setOrderId(order.getOrderId());
						pc.setOperation(operation);

						orderService.addProductionConversation(pc);
					}
					
				}else if(adStatus!=null && Constants.TAKE_OVER.equals(adStatus)) {
					orderService.orderMakeChangesByTL(order, catResult, designer);
					operation = "tl_designer";
					
					String sourceDirectory = catResult.getSourcePath();
					
					FTPUtil.zipDirectory(order, catResult);
					
					ArrayList<OrderFile> designFileList = FTPUtil.getOrderFile(sourceDirectory, ".indd");
					if(designFileList!=null) {
						FTPUtil.renameFile(sourceDirectory, designFileList.get(0).getFileName(), "temp.indd");
					}
					if (designFileList == null || designFileList.size() == 0) {
						designFileList = FTPUtil.getOrderFile(sourceDirectory, ".idml");
						if(designFileList!=null) {
							FTPUtil.renameFile(sourceDirectory, designFileList.get(0).getFileName(), "temp.idml");
						}
					}
						


					ArrayList<OrderFile> pdfFileList = FTPUtil.getOrderFile(sourceDirectory, ".pdf");
					if(pdfFileList!=null) {
						FTPUtil.renameFile(sourceDirectory, pdfFileList.get(0).getFileName(), "temp.pdf");
					}
					
					
				}
				
				String sourceDirectory = catResult.getSourcePath();

				HashMap<String, ArrayList<OrderFile>> adFileList = FTPUtil.getOrderFiles(sourceDirectory);
				request.setAttribute(Constants.ORDER_FILE_LIST, adFileList);

				model = new ModelAndView("/designer/designCheckAd");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
}
