<%@page import="com.production.entity.CsrToAdrepOptions"%>
<%@page import="org.springframework.core.annotation.Order"%>
<%@page import="com.production.util.SpringProperty"%>
<%@page import="com.production.entity.NoteTeamLeadDesigner"%>
<%@page import="com.production.entity.OrderFile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.production.util.EncryptionUtil"%>
<%@page import="com.production.entity.PixelSize"%>
<%@page import="com.production.entity.FlexitiveSize"%>
<%@page import="com.production.entity.CatResult"%>
<%@page import="com.production.entity.Orders"%>
<%@page import="com.production.util.Constants"%>
<%@page import="com.production.entity.Designer"%>
<%
String contextPath = request.getContextPath();
String assetsPath = contextPath+"/assets";
assetsPath = Constants.S3_ASSET_URL;

Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
: null;

Orders order = request.getAttribute(Constants.ORDER_DETAIL)!=null?(Orders)request.getAttribute(Constants.ORDER_DETAIL):null;
CatResult catResult = request.getAttribute(Constants.CAT_RESULT_DETAIL)!=null?(CatResult)request.getAttribute(Constants.CAT_RESULT_DETAIL):null;

HashMap<String, ArrayList<OrderFile>> adFileList = request.getAttribute(Constants.ORDER_FILE_LIST)!=null?(HashMap<String, ArrayList<OrderFile>>)request.getAttribute(Constants.ORDER_FILE_LIST):null;

ArrayList<OrderFile> designFileList = adFileList.get(Constants.ORDER_FILE_FORMAT_INDD);
ArrayList<OrderFile> pdfFileList = adFileList.get(Constants.ORDER_FILE_FORMAT_PDF);
ArrayList<OrderFile> assetsFileList = adFileList.get(Constants.ORDER_FILE_FORMAT_DOC);
ArrayList<OrderFile> fontsFileList = adFileList.get(Constants.ORDER_FILE_FORMAT_FONT);

ArrayList<OrderFile> tlFileList = adFileList.get(Constants.ORDER_FOLDER_TL_CHANGES);
ArrayList<OrderFile> csrFileList = adFileList.get(Constants.ORDER_FOLDER_CSR_CHANGES);

ArrayList<NoteTeamLeadDesigner> designerNotesList = request.getAttribute(Constants.NOTES_CSR_DESIGNER_LIST)!=null?(ArrayList<NoteTeamLeadDesigner>)request.getAttribute(Constants.NOTES_CSR_DESIGNER_LIST):null;
ArrayList<CsrToAdrepOptions> csrAdrepNotesList = request.getAttribute(Constants.NOTES_CSR_ADREP_LIST)!=null?(ArrayList<CsrToAdrepOptions>)request.getAttribute(Constants.NOTES_CSR_ADREP_LIST):null;


SpringProperty sProperty = new SpringProperty();
String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");

%>


<!DOCTYPE html>
<html lang="en">
	<!--begin::Head-->
	<head><base href="">
		<title>QA/Proofread|<%=order!=null?Constants.getOrderType(order.getOrderTypeId()):"" %>|Designer|AdwitAds</title>
		
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta property="og:locale" content="en_US" />
		<meta property="og:type" content="article" />
		<link rel="shortcut icon" href="<%=assetsPath %>/media/logos/favicon.ico" />
		<!--begin::Fonts-->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
		<!--end::Fonts-->
		<!--begin::Page Vendor Stylesheets(used by this page)-->
		<link href="<%=assetsPath %>/plugins/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
		<link href="<%=assetsPath %>/plugins/custom/datatables/datatables.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Page Vendor Stylesheets-->
		<!--begin::Global Stylesheets Bundle(used by all pages)-->
		<link href="<%=assetsPath %>/plugins/global/plugins.bundle.css" rel="stylesheet" type="text/css" />
		<link href="<%=assetsPath %>/css/style.bundle.css" rel="stylesheet" type="text/css" />
        <link href="<%=assetsPath %>/css/csr-custom.css" rel="stylesheet" type="text/css" />
		<!--begin::Page Vendor Stylesheets(used by this page)-->
		<link href="<%=assetsPath %>/plugins/custom/prismjs/prismjs.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Page Vendor Stylesheets-->

	</head>
	<!--end::Head-->
	<!--begin::Body-->
	<body id="kt_body" class="header-fixed header-tablet-and-mobile-fixed">

	
		<!--begin::Main-->
		<!--begin::Root-->
		<div class="d-flex flex-column flex-root">
			<!--begin::Page-->
			<div class="page d-flex flex-row flex-column-fluid">
				<!--begin::Wrapper-->
				<div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">

				
					<jsp:include page="header.jsp"></jsp:include>
					
					<!--begin::Content-->
					<div class="content d-flex flex-column flex-column-fluid" id="kt_content">
						<!--begin::Post-->
						<div class="post d-flex flex-column-fluid" id="kt_post">


							
							<!--begin::Container-->
							<div id="kt_content_container" class="container-xxl">
                                <div class="card mb-10">
									<div class="card-body  p-5 p-lg-8">
                                        
                                        <div class="row ">
                                            
                                          <div class="col-md-12  pb-6 pt-2 ps-4 pe-4">
                                                <div class="border border-radius-4 ">
                                                <div class="order-head border-radius-5">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <h5 class="pt-2 fw-bolder text-color-white collapsible cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block">  Order Details  
                                                                <span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder text-color-white right">
                                                                    <i class="fa fa-angle-up text-color-white fs-2 " aria-hidden="true"></i>
                                                                </span></h5> 
                                                          
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                                <div id="kt_toggle_block" class="" >
                                               <div class="row " >
                                                <div class="col-md-6 ps-6 pt-6 ">
                                                    <p class="fw-bolder"> <u> Order Information</u></p>
                                                      <p>Order Date: <%=order.getCreatedOn() %></p>
                                                      <p>Advertiser Name: <%=order.getAdvertiserName() %></p>
                                                      <p>Publication Name: <%=order.getPublicationName() %></p>
                                                      <p>Ad Rep Name: <%=order.getAdRepName() %></p>
                                                      
                                                      <div class="row">
                                                        <p class="fw-bolder"> <u> Files</u></p>
                                                        <div class="col-md-3">
                                                         <p>Files Submitted:  <span  >File 1</span></p>
                                                        </div>
                                                    </div>
                                                    </div>
                                                      <div class="col-md-6 col-sm-12 ps-6 pe-6 pb-6 pt-6">
                                                        <p class="fw-bolder"> <u> Checklist</u></p>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked">
                                                                   Publication/Ad Rep Guidelines:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked">
                                                                    Advertiser Guidelines/Mandatories:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked">
                                                                    Color of Ad:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked">
                                                                   Size of Ad:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked">
                                                                   Notes/Instructions:
                                                                </label>
                                                            </div>
                                                       
                                                    </div>
                                                </div>
                                                
                                               </div>
                                            </div>
                                              </div>
                                               
                                                </div>
                                                <div class="row ">
                                                    <div class="col-md-12  pb-6 pt-2 ps-4 pe-4">
                                                        <div class="border border-radius-4 ">
                                                        <div class="order-head border-radius-5 ">
                                                         <h5 class="pt-2 fw-bolder text-color-white"> Ad Proof</h5> 
                                                        </div>
                                                       <div class="row">
                                                        
                                                           <div class="col-md-12 ps-6 pe-6 pt-6 pb-6 ">
                                                            	<iframe class="border-radius-5" width="100%" height="300px" src="<%=contextPath %>/<%=catResult.getSourcePath() %>/<%=catResult.getSlug() %>.pdf" ></iframe>
                                                            </div>
                                                            
                                                       </div> 
                                                    </div>
                                                      </div>
                                                       
                                                        </div>
                                                <div  class="row pt-2 ">
                                                    <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                        <button type="button" class=" btn btn-primary btn-sm col-md-6 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_back_to_designer">Send Back to Designer</button>
                                                    </div>
                                                 <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                                <button type="button" class="btn btn-secondary btn-sm col-md-6 col-xs-10  text-color-white" data-bs-toggle="modal" data-bs-target="#kt_modal_take_over">Download Native Files</button>
                                                            </div>
                                                            <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                                <button type="button" class=" btn btn-success btn-sm col-md-6 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_send_to_qa">Send to Adrep</button>
                                                            </div>
                                                        </div>
                                              </div>
                                        </div>

									
								
								
							</div>
							</div>
							
								
							</div>
							<!--end::Container-->
							
						</div>
						<!--end::Post-->
					</div>
					<!--end::Content-->


					
					<jsp:include page="footer.jsp"></jsp:include>
					
				</div>
				<!--end::Wrapper-->
			</div>
			<!--end::Page-->
		</div>
		<!--end::Root-->
		<!--begin::Drawers-->

      
      
        <div class="modal fade" tabindex="-1" id="kt_modal_3">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">View Files</h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                        <div  class="row ">
                        <iframe class="min-h-250px" src="<%=assetsPath %>/media/20.jpeg"  ></iframe>
                    </div>
                          
                       
                    </div>
                    <div class="border-top ">
                        <div  class="row pt-6 pb-6 align-items-center text-center">
                           <div class="col-md-12 pt-2 pb-2 ps-6 pe-6">
                                <button type="button" class="btn btn-primary btn-sm col-md-4 col-xs-12 align-items-center text-center" >Download</button>
                            </div>
                        </div>
                      
                        </div>
                       
                       
                    </div>
                </div>
            </div>

   
		
      <div class="modal fade" tabindex="-1" id="kt_modal_back_to_designer">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Send Back to Designer</h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
          <div class="modal-body">
                    	<form name="qaOrderForm" id="qaOrderForm" action="<%=contextPath %>/designer/orders/qacheck/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post">
                       		<input type="hidden" name="adStatus" id="adStatus" value="<%=Constants.BACK_TO_DESIGNER %>" />
                        <div  class="row pt-2 pb-3 ">
                               
                            <div class="col-md-12 ps-6 pe-6">
                                <div class="d-flex flex-column" id="toastTypeGroup">
                                    <%if(designerNotesList!=null && designerNotesList.size()>0){
                                    	for(NoteTeamLeadDesigner noteTeamLeadDesigner : designerNotesList){
                                    	%>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input required onchange="if($(this).is(':checked')) { $('#otherNotes').hide(); }" class="form-check-input" type="radio" value="<%=noteTeamLeadDesigner.getName() %>" name="adNotes" >
                                        <span class="form-check-label"><%=noteTeamLeadDesigner.getName() %></span>
                                    </label> 
                                   		 <%}
                                    }%>
                                    
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input required onchange="if($(this).is(':checked')) { $('#otherNotes').show(); }" required class="form-check-input" type="radio" value="Other" name="adNotes">
                                        <span class="form-check-label">Other</span>
                                    </label>
                                </div>

                                 
                               
                            </div>
                        </div> 
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6" style="display: none" id="otherNotes">
                            <label class="form-label">Ad Note</label>
                        <textarea name="adOtherNotes" class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                        </div>
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6">
                               <!--begin::Form-->
                                <!--begin::Input group-->
                                <div class="fv-row">
                                    <!--begin::Dropzone-->
                                    <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_csr_changes">
                                        <!--begin::Message-->
                                        <div class="dz-message needsclick row text-center">
                                             <!--begin::Icon-->
                                            <i class="bi bi-cloud-arrow-up-fill text-secondary fs-3x"></i>
                                            <!--end::Icon-->

                                            <!--begin::Info-->
                                            <div class="ms-4">
                                                <h3 class="fs-5 fw-bolder text-gray-900 mb-1">Drop files here or <span class="text-primary">click to upload.</span></h3>
                                                <span class="fs-7 fw-bold text-gray-400">Upload up to 10 files</span>
                                            </div>
                                            <!--end::Info-->
                                        </div>
                                    </div>
                                    <!--end::Dropzone-->
                                </div>
                                <!--end::Input group-->
                            <!--end::Form-->
                        </div>
                        
                        
                        <div class="border-top ">
                        <div class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-sm col-md-5 col-xs-6">Submit</button>
                            </div>
                           
                        </div>
                      
                        </div>
                        
                        </form>
                    </div>
                    
                   


                </div>
            </div>
        </div>
        
        
        <div class="modal fade" tabindex="-1" id="kt_modal_take_over">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Take Over</h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
          <div class="modal-body">
                    	<form name="qaOrderForm" id="qaOrderForm" action="<%=contextPath %>/designer/orders/qacheck/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post">
                       		<input type="hidden" name="adStatus" id="adStatus" value="<%=Constants.TAKE_OVER %>" />
                       
                        <div class="row pt-3 pb-3 ps-6 pe-6" style="display: none" id="otherNotes">
                            <label class="form-label">Ad Note</label>
                        <textarea name="adOtherNotes" class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                        </div>
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6">
                               <!--begin::Form-->
                                <!--begin::Input group-->
                                <div class="fv-row">
                                    <!--begin::Dropzone-->
                                    <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_csr_changes">
                                        <!--begin::Message-->
                                        <div class="dz-message needsclick row text-center">
                                             <!--begin::Icon-->
                                            <i class="bi bi-cloud-arrow-up-fill text-secondary fs-3x"></i>
                                            <!--end::Icon-->

                                            <!--begin::Info-->
                                            <div class="ms-4">
                                                <h3 class="fs-5 fw-bolder text-gray-900 mb-1">Drop files here or <span class="text-primary">click to upload.</span></h3>
                                                <span class="fs-7 fw-bold text-gray-400">Upload up to 10 files</span>
                                            </div>
                                            <!--end::Info-->
                                        </div>
                                    </div>
                                    <!--end::Dropzone-->
                                </div>
                                <!--end::Input group-->
                            <!--end::Form-->
                        </div>
                        
                        
                        <div class="border-top ">
                        <div class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-sm col-md-5 col-xs-6">Submit</button>
                            </div>
                           
                        </div>
                      
                        </div>
                        
                        </form>
                    </div>
                    
                   


                </div>
            </div>
        </div>

   
		
        <div class="modal fade" tabindex="-1" id="kt_modal_send_to_qa">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Send to Ad Rep </h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                    	<form name="qaOrderForm" id="qaOrderForm" action="<%=contextPath %>/designer/orders/qacheck/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post">
                       		<input type="hidden" name="adStatus" id="adStatus" value="<%=Constants.SEND_TO_ADREP %>" />
                        
                        
                        <div  class="row pt-2 pb-3 ">
                               
                            <div class="col-md-12 ps-6 pe-6">
                                <div class="d-flex flex-column" id="toastTypeGroup">
                                    <%if(csrAdrepNotesList!=null && csrAdrepNotesList.size()>0){
                                    	for(CsrToAdrepOptions csrToAdrepOptions : csrAdrepNotesList){
                                    	%>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input required onchange="if($(this).is(':checked')) { $('#otherAdRepNotes').hide(); }" class="form-check-input" type="radio" value="<%=csrToAdrepOptions.getName() %>" name="adNotes" >
                                        <span class="form-check-label"><%=csrToAdrepOptions.getName() %></span>
                                    </label> 
                                   		 <%}
                                    }%> 
                                    
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input required onchange="if($(this).is(':checked')) { $('#otherAdRepNotes').show(); }" required class="form-check-input" type="radio" value="Other" name="adNotes">
                                        <span class="form-check-label">Other</span>
                                    </label>
                                </div>

                                 
                               
                            </div>
                        </div> 
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6" style="display: none" id="otherAdRepNotes">
                            <label class="form-label">Ad Note</label>
                        <textarea name="adOtherNotes" class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                        </div>
                        
                        <div class="border-top ">
                        <div class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary btn-sm col-md-5 col-xs-6">Send to AdRep</button>
                            </div>
                           
                        </div>
                      
                        </div>
                        
                       </form> 
                    </div>


                </div>
            </div>
        </div>
        

	
		<!--begin::Scrolltop-->
		<div id="kt_scrolltop" class="scrolltop" data-kt-scrolltop="true">
			<!--begin::Svg Icon | path: icons/duotune/arrows/arr066.svg-->
			<span class="svg-icon">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
					<rect opacity="0.5" x="13" y="6" width="13" height="2" rx="1" transform="rotate(90 13 6)" fill="black" />
					<path d="M12.5657 8.56569L16.75 12.75C17.1642 13.1642 17.8358 13.1642 18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25L12.7071 5.70711C12.3166 5.31658 11.6834 5.31658 11.2929 5.70711L5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75C6.16421 13.1642 6.83579 13.1642 7.25 12.75L11.4343 8.56569C11.7467 8.25327 12.2533 8.25327 12.5657 8.56569Z" fill="black" />
				</svg>
			</span>
			<!--end::Svg Icon-->
		</div>
		<!--end::Scrolltop-->
		
		<!--begin::Modals-->


		<!--end::Modals-->
		<!--begin::Javascript-->
		<script>var hostUrl = "<%=assetsPath %>/";</script>
		<!--begin::Global Javascript Bundle(used by all pages)-->
		<script src="<%=assetsPath %>/plugins/global/plugins.bundle.js"></script>
		<script src="<%=assetsPath %>/js/scripts.bundle.js"></script>
		<!--end::Global Javascript Bundle-->
		<!--begin::Page Vendors Javascript(used by this page)-->
		<script src="<%=assetsPath %>/plugins/custom/fullcalendar/fullcalendar.bundle.js"></script>
		<script src="<%=assetsPath %>/plugins/custom/datatables/datatables.bundle.js"></script>
		<!--end::Page Vendors Javascript-->
		<!--begin::Page Custom Javascript(used by this page)-->
		<script src="<%=assetsPath %>/js/widgets.bundle.js"></script>
		<script src="<%=assetsPath %>/js/custom/widgets.js"></script>
		<script src="<%=assetsPath %>/js/custom/intro.js"></script>

		<!--begin::Page Vendors Javascript(used by this page)-->
		<script src="<%=assetsPath %>/plugins/custom/prismjs/prismjs.bundle.js"></script>
		<!--end::Page Vendors Javascript-->
		<!--begin::Page Custom Javascript(used by this page)-->
		<script src="<%=assetsPath %>/js/custom/documentation/documentation.js"></script>
		<script src="<%=assetsPath %>/js/custom/documentation/search.js"></script>
		<!--end::Page Custom Javascript-->
       

        <script>
            
        Dropzone.autoDiscover = false;
        
        var myDropzone1 = $("#kt_dropzonejs_example_indd").dropzone({
        	 url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/uploadfile",
            addRemoveLinks: true,
            paramName: "file1",
            maxFilesize: 10, // MB
            accept:function accept(file, done) { 
            	console.log("accept :" + file.name);
            	if(file.name == '<%=catResult.getSlug()+".indd"%>'){
            		console.log("valid file :" + file.name);
            		return done();
            	}else if(file.name == '<%=catResult.getSlug()+".INDD"%>'){
            		console.log("valid file :" + file.name);
            		return done();
            	}else if(file.name == '<%=catResult.getSlug()+".IDML"%>'){
            		console.log("valid file :" + file.name);
            		return done();
            	}else if(file.name == '<%=catResult.getSlug()+".idml"%>'){
            		console.log("valid file :" + file.name);
            		return done();
            	}else{
            		alert('Enter a valid file with the  name : <%=catResult.getSlug()+".indd"%>');
            		this.removeFile(file);
            		return;
            	}
            	 
            },
            success: function (file, response) {
                var imgName = response;
                file.previewElement.classList.add("dz-success");
                console.log("Successfully uploaded :" + imgName);
            },
            error: function (file, response) {
                file.previewElement.classList.add("dz-error");
            },removedfile: function(file) {
            	var name = file.name;   
            	file.previewElement.remove();
            	
            	console.log('remove file : '+name);
                $.ajax({
                    type: 'post',
                    url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/deletefile",
                    data: {dFile:name, sPath:'INDD'},
                });

            },init: function () {
            	<%if(designFileList!=null && designFileList.size()>0){%>
            		var designMockFile = { name: "<%=designFileList.get(0).getFileName()%>", size: <%=designFileList.get(0).getFileSize()%> };
                	//this.addFile.call(this, designMockFile);
                	this.options.addedfile.call(this, designMockFile);

                <%}%>
            }

        });
        
        
        
        var myDropzone2 =  $("#kt_dropzonejs_example_pdf").dropzone({
       	 url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/uploadfile",
           addRemoveLinks: true,
           paramName: "file2", 
           maxFilesize: 10, // MB
           acceptedFiles: "application/pdf",
           accept:function accept(file, done) { 
           	console.log("accept :" + file.name);
           	if(file.name == '<%=catResult.getSlug()+".pdf"%>'){
           		console.log("valid file :" + file.name);
           		return done();
           	}else if(file.name == '<%=catResult.getSlug()+".PDF"%>'){
           		console.log("valid file :" + file.name);
           		return done();
           	}else{
           		this.removeFile(file);
           		alert('Enter a valid pdf file with the  name : <%=catResult.getSlug()+".pdf"%>');
           		return;
           	}
           	 
           },
           success: function (file, response) {
               var imgName = response;
               file.previewElement.classList.add("dz-success");
               console.log("Successfully uploaded :" + imgName);
           },
           error: function (file, response) {
               file.previewElement.classList.add("dz-error");
           },removedfile: function(file) {
	           	var name = file.name;   
	        	file.previewElement.remove();
	        	
	        	console.log('remove file : '+name);
	        	 $.ajax({
	                    type: 'post',
	                    url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/deletefile",
	                    data: {dFile:name, sPath:'PDF'},
	                });
	        	 
	        },init: function () {
	        	<%if(pdfFileList!=null && pdfFileList.size()>0){%>
	        		var pdfMockFile = { name: "<%=pdfFileList.get(0).getFileName()%>", size: <%=pdfFileList.get(0).getFileSize()%> };
             		 //this.addFile.call(this, pdfMockFile);
             		 this.options.addedfile.call(this, pdfMockFile);
             	<%}%>
          }
       });
        
        
        $("#kt_dropzonejs_example_13").dropzone({
          	 url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/uploadfile",
              addRemoveLinks: true,
              paramName: "links",
              maxFiles: 10,
              maxFilesize: 10, // MB
              success: function (file, response) {
                  var imgName = response;
                  file.previewElement.classList.add("dz-success");
                  console.log("Successfully uploaded :" + imgName);
              },
              error: function (file, response) {
                  file.previewElement.classList.add("dz-error");
              },removedfile: function(file) {
	           	var name = file.name;   
	        	file.previewElement.remove();
	        	
	        	console.log('remove file : '+name);
	        	 $.ajax({
	                    type: 'post',
	                    url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/deletefile",
	                    data: {dFile:name, sPath:'DOC'},
	                });
	        	 
	        },init: function () {
  	        	<%if(assetsFileList!=null && assetsFileList.size()>0){%>
  	        	
  	        		<%for(OrderFile orderFile : assetsFileList){
  	        	%>
		        		var sampleFile = { name: "<%=orderFile.getFileName()%>", size: <%=orderFile.getFileSize()%> };
		        		this.options.addedfile.call(this, sampleFile);
		         		 
		         	<%}%>
		         <%}%>
		      }
          });
         
        $("#kt_dropzonejs_example_14").dropzone({
         	 url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/uploadfile",
             addRemoveLinks: true,
             paramName: "fonts",
             maxFiles: 10,
             maxFilesize: 10, // MB
             success: function (file, response) {
                 var imgName = response;
                 file.previewElement.classList.add("dz-success");
                 console.log("Successfully uploaded :" + imgName);
             },
             error: function (file, response) {
                 file.previewElement.classList.add("dz-error");
             },removedfile: function(file) {
	           	var name = file.name;   
	        	file.previewElement.remove();
	        	
	        	console.log('remove file : '+name);
	        	 $.ajax({
	                    type: 'post',
	                    url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/deletefile",
	                    data: {dFile:name, sPath:'FONT'},
	                });
	        	 
	        },init: function () {
  	        	<%if(fontsFileList!=null && fontsFileList.size()>0){%>
  	        		<%for(OrderFile orderFile : fontsFileList){
  	        	%>
		        		var fontFile = { name: "<%=orderFile.getFileName()%>", size: <%=orderFile.getFileSize()%> };
		        		this.options.addedfile.call(this, fontFile);
		         		 
		         	<%}%> 
		         <%}%>
		      }
         });
        
        
        
        $("#kt_dropzonejs_csr_changes").dropzone({
        	url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/uploadfile",
            addRemoveLinks: true,
            paramName: "csr_changes",
            maxFiles: 10,
            maxFilesize: 10, // MB
            success: function (file, response) {
                var imgName = response;
                file.previewElement.classList.add("dz-success");
                console.log("Successfully uploaded :" + imgName);
            },
            error: function (file, response) {
                file.previewElement.classList.add("dz-error");
            },removedfile: function(file) {
	           	var name = file.name;   
	        	file.previewElement.remove();
	        	
	        	console.log('remove file : '+name);
	        	 $.ajax({
	                    type: 'post',
	                    url:"<%=contextPath %>/designer/orders/<%=EncryptionUtil.encode(order.getOrderId()) %>/deletefile",
	                    data: {dFile:name, sPath:'CSR_CHANGES'},
	                });
	        	 
	        },init: function () {
 	        	<%if(csrFileList!=null &&  csrFileList.size()>0){%>
 	        		<%for(OrderFile orderFile : csrFileList){
 	        	%>
		        		var fontFile = { name: "<%=orderFile.getFileName()%>", size: <%=orderFile.getFileSize()%> };
		        		this.options.addedfile.call(this, fontFile);
		         		 
		         	<%}%> 
		         <%}%>
		      }
        });
       
        
        

    </script>

	</body>
	<!--end::Body-->
</html>