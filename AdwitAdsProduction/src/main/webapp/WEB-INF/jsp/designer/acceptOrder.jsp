<%@page import="com.production.entity.CatArtInstruction"%>
<%@page import="com.production.entity.CatNewAdType"%>
<%@page import="com.production.util.EncryptionUtil"%>
<%@page import="com.production.entity.QuestionTemplate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@page import="com.production.entity.PixelSize"%>
<%@page import="com.production.entity.FlexitiveSize"%>
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

ArrayList<QuestionTemplate> questionTemplateList = request.getAttribute(Constants.QUESTION_TEMPLATE_LIST)!=null?(ArrayList<QuestionTemplate>)request.getAttribute(Constants.QUESTION_TEMPLATE_LIST):null;
ArrayList<CatNewAdType> adTypeList = request.getAttribute(Constants.AD_TYPE_LIST)!=null?(ArrayList<CatNewAdType>)request.getAttribute(Constants.AD_TYPE_LIST):null;
ArrayList<CatArtInstruction> artInstructionList = request.getAttribute(Constants.ART_INSTRUCTION_LIST)!=null?(ArrayList<CatArtInstruction>)request.getAttribute(Constants.ART_INSTRUCTION_LIST):null;


%>


<!DOCTYPE html>
<html lang="en">
	<!--begin::Head-->
	<head><base href="">
		<title>Accept Order|CSR|Adwitads</title>
		<meta charset="utf-8" />
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
                                            <div class="col-md-6  pb-6 pt-2 ps-4 pe-4">
                                                <div class="border border-radius-4 ">
                                                <div class="order-head fw-bolder text-color-white">
                                                    Order Details
                                                </div> 
                                               <div class="row">
                                                   <div class="col-md-12 ps-6 pt-6 ">
                                                      <p>Order Date: <span class="fw-bold"><%=order!=null?order.getCreatedOn():"" %></span></p>
                                                      
                                                      <p>Unique Job Name: <span class="fw-bold"><%=order!=null?order.getJobNo():"" %></span></p>
                                                      
                                                      <p>Size of Ad: 
                                                      	<%if(order.getOrderTypeId()==2){ %>
                                                      		<span class="fw-bold">W: <%=order!=null?order.getWidth():"" %>  H: <%=order!=null?order.getHeight():"" %>
                                                      	<%}else if(order.getOrderTypeId()==1){ %>
                                                      		<span class="fw-bold">
                                                      		<br/>
                                                      		<%if(order.getFlexitiveSize()!=null){ %>
                                                      			<%=order.getFlexitiveSize().getRatio() %>
                                                      		<%} %>
                                                      		
                                                      		<%if(order.getPixelSize()!=null){ %>
                                                      			<%=order.getPixelSize().getWidth() %> x <%=order.getPixelSize().getHeight() %><br/>
                                                      		<%} %>
                                                      		
                                                      		<%if(order.getFlexitiveSizeList()!=null && order.getFlexitiveSizeList().size()>0){
                                                      			for(FlexitiveSize flexitiveSize : order.getFlexitiveSizeList()){%>
                                                      				<%=flexitiveSize.getRatio() %><br/>
                                                      			<% }
                                                      		} %>
                                                      		
                                                      		<%if(order.getPixelSizeList()!=null && order.getPixelSizeList().size()>0){
                                                      			for(PixelSize pixelSize : order.getPixelSizeList()){%>
                                                      				<%=pixelSize.getWidth() %> x <%=pixelSize.getHeight() %><br/>
                                                      			<% }
                                                      		} %>
                                                      		</span>
                                                      	<%} %>
                                                      </p>
                                                      
                                                      <p>Type of Ad: <span class="fw-bold"><%=order!=null?Constants.getOrderType(order.getOrderTypeId()):"" %></span></p>
                                                     
                                                      <%if(order.getOrderTypeId()==2){ %>
                                                      	<p>Color of Ad: <span class="fw-bold"><%=order!=null?Constants.getPrintAdType(order.getPrintAdType()):"" %></span></p>
                                                      <%}else if(order.getOrderTypeId()==1){ %>
                                                      	<p>Static/Animated: <span class="fw-bold"><%=Constants.isStringNotNull(order.getWebOrderType())?order.getWebOrderType():"" %></span></p>
                                                      <%} %>
                                                      
                                                      <%if(Constants.isStringNotNull(order.getColorPreferences())){ %>
	                                                      <p>Color Preference: <span class="fw-bold"><%=order.getColorPreferences() %></span> <span style="height:20px;width:20px;display:inline-flex;background-color:<%=order.getColorPreferences()%>"></span></p>
                                                      <%} %>
                                                      
                                                    </div>
                                                     
                                               
                                               <%if(Constants.isStringNotNull(order.getCopyContentDescription())){ %>
	                                                 <div class="col-md-12 col-sm-12 ps-6 pe-6 pb-6 ">
	                                                    <p>Copy/Content:</p>
	                                                    
	                                                       <p class="fw-bold"><%=order.getCopyContentDescription() %></p>
	                                                      
	                                                </div>
                                                <%} %>
                                                
                                                
                                                 <%if(Constants.isStringNotNull(order.getNotes())){ %>
	                                                 <div class="col-md-12 col-sm-12 ps-6 pe-6 pb-6 ">
	                                                    <p>Note &amp; Instructions:</p>
	                                                    
	                                                       <p class="fw-bold"><%=order.getNotes() %></p>
	                                                      
	                                                </div>
                                                <%} %>
                                                <div class="col-md-12 col-sm-12 ps-6 pt-2 pb-2">
                                                    <div class="row">
                                                        <div class="col-md-3"> 
                                                         <p>File Received:</p>
                                                        </div>
                                                        <div class="col-md-9">
                                                        <%if(order.getFileList()!=null && order.getFileList().size()>0){
                                                        	
                                                        	for(String fileName : order.getFileList()){%>
                                                        		 <a href="javascript:;" class="fileAttachment fw-bolder text-primary cursor-pointer" data-file-url="<%=order.getFilePath()+"/"+fileName %>"  data-bs-toggle="modal" data-bs-target="#kt_modal_3"><%=fileName %></a><br/>
                                                        	
                                                        <%}
                                                        	}%>
                                                        
                                                        </br>
                                                     </div>
                                                    </div> 
                                                     
                                                 </div>
                                                 <div class="col-md-12 ps-6 pt-2 pb-2">
                                                 	<%if(Constants.isStringNotNull(order.getAdvertiserName())){ %>
                                                   	 	<p>Advertiser Name: <span class="fw-bold"><%=order.getAdvertiserName() %></span></p>
                                                   	<%} %>
                                                   	
                                                    <%if(Constants.isStringNotNull(order.getFontPreferences())){ %>
                                                   	 <p>Font Preference: <span class="fw-bold"><%=order.getFontPreferences() %></span></p>
                                                   	<%} %>
                                                   	
                                                   	 <p>Order Status: <span class="fw-bold"><%=order.getOrderStatus() %> <%=order.getQuestion()==1?"(Question Sent)":order.getQuestion()==2?"(Question Answered)":"" %></span></p>
                                                   	
                                                 </div>
                                               </div>
                                            </div>
                                              </div>
                                               
                                            <div class="col-md-6 pb-6 pt-2 ps-4 pe-4">
                                            <form class="form" action="<%=contextPath %>/orders/accept/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post" enctype="multipart/form-data">
                                                <div  class="row pt-2 ">
                                               <%if(adTypeList!=null){ %>
                                                    <p>Type of New Ad<sup>*</sup></p>
                                                    <div  class="row pb-6">
                                                    <%for(CatNewAdType adType  : adTypeList){ %>
	                                                    <div class="col-md-4 col-sm-3 col-xs-6 pt-2 pb-2">
	                                                        <div class="button-radio">
	                                                            <input required type="radio" id="adtype_<%=adType.getCatNewAdTypeId() %>" name="adType" value="<%=adType.getCatNewAdTypeId() %>" />
	                                                            <label class="btn btn-back-white btn-sm col-md-10 col-xs-10" for="adtype_<%=adType.getCatNewAdTypeId() %>"><%=adType.getName() %></label>
	                                                          </div>
	                                                    </div>
                                                    <%} %>
                                                    
                                                </div>
                                                <%} %>
                                                    <div class="border-top ">
                                                        <div  class="row pt-6 pb-6">
                                                            <p>Delivery Timeline<sup>*</sup></p>
                                                    <div class="col-md-6 col-sm-3 col-xs-6 pt-2 pb-2">
                                                        <div class="button-radio">
                                                            <input required type="radio" id="a251" name="isRush" value="1" <%if(order!=null && order.isRush()){ %>checked="checked"<%} %> />
                                                            <label class="btn btn-back-white btn-sm col-md-10 col-xs-10" for="a251">Rush</label>
                                                          </div>
                                                    </div>
                                                    <div class="col-md-6 col-sm-3 col-xs-6 pt-2 pb-2">
                                                        <div class="button-radio">
                                                            <input required type="radio" id="a502" name="isRush" value="0"  <%if(order!=null && !order.isRush()){ %>checked="checked"<%} %> />
                                                            <label class="btn btn-back-white btn-sm col-md-10 col-xs-10" for="a502">Standard</label>
                                                          </div>
                                                    </div>
                    
                                                   
                                                        </div>
                                                      
                                                        </div>
                                                        <div class="border-top ">
                                                            <div  class="row pt-6 pb-6">
                                                                <p>Art Attached</p>
                                                                
                                                                <%if(artInstructionList!=null){
                                                                	for(CatArtInstruction artInstruction : artInstructionList){
                                                                	%>
                                                        <div class="col-md-4 col-sm-3 col-xs-6 pt-2 pb-2">
                                                            <div class="button-radio">
                                                                <input required type="radio" id="art_<%=artInstruction.getCatArtInstructionId() %>" name="art_attachment" value="<%=artInstruction.getCatArtInstructionId() %>" />
                                                                <label class="btn btn-back-white btn-sm col-md-10 col-xs-10" for="art_<%=artInstruction.getCatArtInstructionId() %>"><%=artInstruction.getName() %></label>
                                                              </div>
                                                        </div>
                                                        
                                                        <%}
                                                                	} %>
                                                        
                                                            </div>
                                                          
                                                            </div>
                                                   <!--begin::Form-->
                                                <form class="form" action="#" method="post">
                                                    <!--begin::Input group-->
                                                    <div class="fv-row">
                                                        <!--begin::Dropzone-->
                                                        <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_example_1">
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
                                                 <div class="col-md-6 col-xs-6 pt-6 pb-2">
                                                                <button type="button" class="btn btn-secondary btn-sm col-md-10 col-xs-10  text-color-white" data-bs-toggle="modal" data-bs-target="#kt_modal_5">Question</button>
                                                            </div>
                                                            <div class="col-md-6 col-xs-6 pt-6 pb-2 right">
                                                                <button type="submit" class="right btn btn-success btn-sm col-md-10 col-xs-10" >Accept Order</button>
                                                            </div>
                                                        </div>
                                                      </form>
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
					
				
					<!--begin::Footer-->
					<div class="footer py-4 d-flex flex-lg-column" id="kt_footer">
						<!--begin::Container-->
						<div class="container-xxl d-flex flex-column flex-md-row align-items-center justify-content-between">
							<!--begin::Copyright-->
							<div class="text-dark order-2 order-md-1">
								<ul class="menu menu-gray-600 menu-hover-primary fw-bold order-1">
									<li class="menu-item">
										<a href="" target="_blank" class="menu-link px-2">
											<i class="fab fa-facebook-square fs-2x"></i>
										</a>
									</li>
									<li class="menu-item">
										<a href="" target="_blank" class="menu-link px-2">
											<i class="fab fa-twitter-square fs-2x"></i>
										</a>
									</li>
									<li class="menu-item">
										<a href="" target="_blank" class="menu-link px-2">
											<i class="fab fa-instagram fs-2x"></i>
										</a>
									</li>
									<li class="menu-item">
										<a href="" target="_blank" class="menu-link px-2">
											<i class="fab fa-google-plus-square fs-2x"></i>
										</a>
									</li>
								</ul>
							</div>
							<!--end::Copyright-->
							<!--begin::Menu-->
							<ul class="menu menu-gray-600 menu-hover-primary fw-bold order-1">
								<li class="menu-item">
									<a href="" target="_blank" class="menu-link px-2">FAQ's</a>
								</li>
								<li class="menu-item">
									<a href="" target="_blank" class="menu-link px-2">Contact Us</a>
								</li>
							</ul>
							<!--end::Menu-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Footer-->
					
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
                        <img src="" id="fileReceivedId"  />
                    </div>
                          
                       
                    </div>
                    <div class="border-top ">
                        <div  class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-6 pt-2 pb-2">
                                <button type="button" class="btn btn-back-white btn-sm col-md-10 col-xs-6" data-bs-dismiss="modal" aria-label="Close">Close</button>
                            </div>
                            <div class="col-md-6 pt-2 pb-2">
                                <button type="button" class="btn btn-back-white btn-sm col-md-10 col-xs-6" >Download</button>
                            </div>
                        </div>
                      
                        </div>
                       
                       
                    </div>
                </div>
            </div>

    
		
        <div class="modal fade" tabindex="-1" id="kt_modal_5">
            <div class="modal-dialog modal-dialog-centered ">
                <form name="sendQuestionForm" id="sendQuestionForm" action="<%=contextPath %>/orders/sendquestion/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <%if(order.getQuestion()>0 && order.getOrderQA()!=null){ %>
                        	 <h5 class="modal-title">Question Sent Ad Rep </h5>
                        <%}else{ %>
                       	 <h5 class="modal-title">Send Question to Ad Rep </h5>
                        <%} %>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                    	
	                        <div  class="row pt-6 pb-6 ">
	                        
	                        <%if(order.getQuestion()==1 && order.getOrderQA()!=null){ %>
	                       		 <p><%=order.getOrderQA()!=null?order.getOrderQA().getQuestion():"" %></p>
	                       		<%}else{ %>
	                               
	                            <div class="col-md-12 ps-6 pe-6">
	                                <%if(questionTemplateList!=null){
	                                	for(QuestionTemplate qt : questionTemplateList){
	                                	%>
	                                <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
	                                    <input required data-qt-note="<%=qt.getMessage() %>" name="questionTemplate" class="form-check-input" type="radio" value="<%=qt.getQuestionTemplateId() %>" id="questionTemplate_<%=qt.getQuestionTemplateId() %>" />
	                                    <label class="form-check-label" for="questionTemplate_<%=qt.getQuestionTemplateId() %>">
	                                        <%=qt.getName() %>
	                                    </label>
	                                </div> 
	                                <%} 
	                                }%>
	                                
	                               
	                            </div>
	                        </div>
	                        
	                        <div class="row pt-3 pb-3 ps-6 pe-6">
	                            <label class="form-label">Ad Note</label>
	                        <textarea required name="questionTemplateNote" class="form-control border-dashed" placeholder="Type here" id="questionTemplateNote" style="height: 100px"></textarea>
	                        </div>
	                        <%} %>
                       
                    </div>
                    <div class="border-top ">
                        <div  class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-2"></div>
                        <div class="col-md-4 col-xs-6 pt-2 pb-2">
                            <button type="button" class="btn btn-back-white btn-sm col-md-8 col-xs-10 " data-bs-dismiss="modal" aria-label="Close">close</button>
                        </div>
                        <%if(order.getQuestion()!=1){ %> <div class="col-md-4 col-xs-6 pt-2 pb-2">
                           
                            	 <button type="submit" class="btn btn-secondary btn-sm col-md-8 col-xs-10 text-color-white" >Send Question</button>
                           
                        </div>
                        <%} %>
                        <div class="col-md-2"></div>
                    </div>
                     </form>
                </div> 


                </div>
                 
                
                <div class="modal fade" tabindex="-1" id="kt_modal_q_sent">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Question Sent To Ad Rep </h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                    	
	                        <div  class="row pt-6 pb-6 ">
	                              <p><%=order.getOrderQA()!=null?order.getOrderQA().getQuestion():"" %></p>
	                        </div>
                       
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
		<!--Drop Zone-->
<script>
$(document).ready(function () {
	
	$(".fileAttachment").click(function () {
		 var fileURL = $(this).data("file-url");
		 console.log(fileURL);
		 $('#fileReceivedId').attr("src","http://adwitads.com/weborders/"+fileURL);

	});
});


//dropzone
var myDropzone = new Dropzone("#kt_dropzonejs_example_1", {
  url: "https://keenthemes.com/scripts/void.php", // Set the url for your upload script location
  paramName: "file", // The name that will be used to transfer the file
  maxFiles: 10,
  maxFilesize: 10, // MB
  addRemoveLinks: true,
  accept: function(file, done) {
      if (file.name == "wow.jpg") {
          done("Naha, you don't.");
      } else {
          done();
      }
  }
});


$('input[type=radio][name=questionTemplate]').change(function() {
    //alert(this.value);
    var qtNote = $(this).data("qt-note");
    console.log(qtNote);
    $('#questionTemplateNote').val(qtNote);
  });




</script>
	</body>
	<!--end::Body-->
</html>