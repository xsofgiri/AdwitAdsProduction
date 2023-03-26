package com.production.action;

import com.production.util.FileUtil;
import com.production.entity.Adrep;
import com.production.entity.CatArtInstruction;
import com.production.entity.CatNewAdType;
import com.production.entity.CatResult;
import com.production.entity.Designer;
import com.production.entity.LiveOrder;
import com.production.entity.OrderQA;
import com.production.entity.Orders;
import com.production.entity.QuestionTemplate;
import com.production.service.impl.CSRServiceBean;
import com.production.service.impl.OrderServiceBean;
import com.production.service.impl.UserServiceBean;
import com.production.util.Constants;
import com.production.util.EncryptionUtil;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserServiceBean userService;

	@Autowired
	CSRServiceBean csrService;

	@Autowired
	OrderServiceBean orderService;

	@RequestMapping("")
	public ModelAndView displayHomePage(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("redirect:/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("redirect:/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			System.out.println("email : " + email);
			System.out.println("password : " + password);

			int designerId = userService.validateDesigner(email, password);
			if (designerId > 0) {
				Designer designer = userService.getDesignerDetails(designerId);
				session.setAttribute(Constants.DESIGNER_DTO, designer);

				model = new ModelAndView("redirect:/dashboard");
			} else {
				int csrId = userService.validateCSR(email, password);
				if (csrId > 0) {
					Designer designer = userService.getCSRDetails(csrId);
					session.setAttribute(Constants.DESIGNER_DTO, designer);

					model = new ModelAndView("redirect:/dashboard");

				} else {
					request.setAttribute(Constants.USER_ERROR_MESSAGE, "Invalid Login Details");
					model = new ModelAndView("/designer/login");
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView executeLogout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {

				session.removeAttribute(Constants.DESIGNER_DTO);
				session.invalidate();

				model = new ModelAndView("/designer/login");

			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/workstation", method = RequestMethod.GET)
	public ModelAndView displayWorkstation(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {

				ArrayList<LiveOrder> liveOrderList = csrService.getCSRWorkStationOrderList(designer);
				request.setAttribute(Constants.CSR_WORKSTATION_ORDER_LIST, liveOrderList);
				
				ArrayList<LiveOrder> qaOrderList = csrService.getCSRQAList(designer);
				request.setAttribute(Constants.DESIGNER_WORKSTATION_QA_ORDER_LIST, qaOrderList);

				ArrayList<LiveOrder> proofReadyOrderList = csrService.getCSRProofReadyList(designer);
				request.setAttribute(Constants.CSR_WORKSTATION_PROOF_READY_ORDER_LIST, proofReadyOrderList);
				
				
				model = new ModelAndView("/designer/csrWorkstation");

			} else if (designer != null && designer.getDesignerId() > 0) {
				ArrayList<LiveOrder> liveOrderList = csrService.getDesignerWorkStationOrderList(designer);
				request.setAttribute(Constants.DESIGNER_WORKSTATION_ORDER_LIST, liveOrderList);

				ArrayList<LiveOrder> inProductionOrderList = csrService.getDesignerInProductionList(designer);
				request.setAttribute(Constants.DESIGNER_WORKSTATION_INPRODUCTION_ORDER_LIST, inProductionOrderList);
				
				ArrayList<LiveOrder> designCheckOrderList = csrService.getDesignerDesignCheckList(designer);
				request.setAttribute(Constants.DESIGNER_WORKSTATION_DESIGN_CHECK_ORDER_LIST, designCheckOrderList);
				
				ArrayList<LiveOrder> qaOrderList = csrService.getDesignerQAList(designer);
				request.setAttribute(Constants.DESIGNER_WORKSTATION_QA_ORDER_LIST, qaOrderList);
				
				
				model = new ModelAndView("/designer/designerWorkstation");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/accept/{order_id}/", method = RequestMethod.GET)
	public ModelAndView displayAcceptOrder(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {

				orderId = EncryptionUtil.decode(orderId);

				ArrayList<QuestionTemplate> questionTemplateList = orderService.getListOfQuestionTemplate();
				request.setAttribute(Constants.QUESTION_TEMPLATE_LIST, questionTemplateList);

				ArrayList<CatNewAdType> adTypeList = orderService.getAdTypeList();
				request.setAttribute(Constants.AD_TYPE_LIST, adTypeList);

				ArrayList<CatArtInstruction> artInstructionList = orderService.getArtInstructionList();
				request.setAttribute(Constants.ART_INSTRUCTION_LIST, artInstructionList);

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));
				request.setAttribute(Constants.ORDER_DETAIL, order);

				model = new ModelAndView("/designer/acceptOrder");
			} else if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/accept/{order_id}/", method = RequestMethod.POST, consumes = "multipart/form-data")
	public ModelAndView executeAcceptOrder(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId,
			@RequestParam(value = "adFiles", required = false) MultipartFile[] adFiles) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {

				orderId = EncryptionUtil.decode(orderId);

				String adType = request.getParameter("adType");
				String isRush = request.getParameter("isRush");
				String artAttachment = request.getParameter("art_attachment");

				System.out.println("adType : " + adType);
				System.out.println("isRush : " + isRush);
				System.out.println("artAttachment : " + artAttachment);

				if (adFiles != null) {
					OkHttpClient client = new OkHttpClient().newBuilder().build();

					MultipartBody.Builder buildernew = new MultipartBody.Builder().setType(MultipartBody.FORM);
					buildernew.addFormDataPart("order_id", orderId + "");

					for (MultipartFile file : adFiles) {
						if (!file.isEmpty()) {
							try {
								System.out.println("adFiles file : " + file.getOriginalFilename());

								File newFile = FileUtil.multipartToFile(file, file.getOriginalFilename());

								okhttp3.RequestBody newAdFile = okhttp3.RequestBody
										.create(MediaType.parse("application/octet-stream"), newFile);

								buildernew.addFormDataPart("attachments[]", file.getOriginalFilename(), newAdFile)
										.build();

							} catch (Exception e) {
								System.out.println("Exception : " + e);
							}
						} else {
							System.out.println("file is empty: ");
						}
					}

					okhttp3.RequestBody body = buildernew.build();

					Request okhttp3Request = new Request.Builder()
							.url("https://adwitads.com/weborders/index.php/cron_jobs/home/attachmentFiles_upload")
							.method("POST", body)
							.addHeader("Cookie", "ad-archives=f8abb1da016e38865e173db9a1acd6c9a3443ebe").build();
					System.out.println("*****after OkHttpClient 4 : ");

					Response okhttp3Response = client.newCall(okhttp3Request).execute();
					System.out.println(okhttp3Response.body().string());

				}

				Orders order = orderService.getOrderDetails(Integer.parseInt(orderId));

				CatResult catResult = new CatResult();
				catResult.setCatArtInstructionId(Integer.parseInt(artAttachment));
				catResult.setCatNewAdtypeId(Integer.parseInt(adType));
				catResult.setProductionStatusId(1);//in design
				catResult.setCategory(Constants.getCategory(Integer.parseInt(adType)));
				catResult.setCsrId(designer.getDesignerId());
				catResult.setVersion(Constants.ORDER_VERSION_V1);

				order.setRush(!order.isRush() && "1".equals(isRush) ? true : order.isRush() ? true : false);

				int result = orderService.acceptOrder(order, catResult);
				System.out.println(result);
				if (result > 0) {
					model = new ModelAndView("redirect:/workstation");
				} else {
					model = new ModelAndView("redirect:/orders/accept/" + EncryptionUtil.encode(orderId) + "/");
				}

			} else if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/orders/sendquestion/{order_id}/", method = RequestMethod.POST)
	public ModelAndView sendOrderQuestion(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;

			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {

				orderId = EncryptionUtil.decode(orderId);

				String questionTemplateNote = request.getParameter("questionTemplateNote");

				System.out.println("questionTemplateNote :" + questionTemplateNote);

				OrderQA orderQA = new OrderQA();
				orderQA.setOrderId(Integer.parseInt(orderId));
				orderQA.setCsrId(designer.getDesignerId());
				orderQA.setQuestion(questionTemplateNote);

				int result = orderService.updateSendQuestionStatus(orderQA);
				System.out.println("result :" + result);

				model = new ModelAndView("redirect:/orders/accept/" + EncryptionUtil.encode(orderId) + "/");

			} else if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/checkdesign", method = RequestMethod.GET)
	public ModelAndView displayCheckDesign(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/startdesign", method = RequestMethod.GET)
	public ModelAndView displayStartDesign(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/designAd");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/newrevisionad", method = RequestMethod.GET)
	public ModelAndView displayNewRevisionAd(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/dashboard");
			} else {
				model = new ModelAndView("/designer/newRevisionAd");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

}
