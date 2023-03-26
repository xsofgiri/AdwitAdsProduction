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

%>


<!DOCTYPE html>
<html lang="en">
	<!--begin::Head-->
	<head><base href="">
		<title>Start Design|<%=order!=null?Constants.getOrderType(order.getOrderTypeId()):"" %>|Designer|AdwitAds</title>
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
                                                    
                                                      <div class="col-md-12 col-sm-12 ps-6 pe-6 pb-6 ">
                                                   		<p>Copy/Content:</p>
                                                    
                                                        <textarea class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"><%=order.getCopyContentDescription() %></textarea>
                                                    </div>
                                               
                                                 <div class="col-md-12 col-sm-12 ps-6 pe-6 pb-6 ">
                                                    <p>Note &amp; Instructions:</p>
                                                    
                                                        <textarea class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"><%=order.getNotes() %></textarea>
                                                      
                                                </div>
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
                                                 <form class="form" action="<%=contextPath %>/designer/orders/designad/<%=EncryptionUtil.encode(order.getOrderId()) %>/" method="post" enctype="multipart/form-data" accept-charset="utf-8">
                                                <div  class="row pt-2 ">
                                                    <p class="align-items-center text-center fw-bold">Complete Checklist to End Design<sup>*</sup></p>
                                                    <div  class="row pb-6">
                                                        <div class="col-md-12 ps-6 pe-6">
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input required class="form-check-input" type="checkbox" value="1" id="flexCheckChecked1" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked1">
                                                                   Publication/Ad Rep Guidelines:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input required class="form-check-input" type="checkbox" value="2" id="flexCheckChecked2"  />
                                                                <label class="form-check-label" for="flexCheckChecked2">
                                                                    Advertiser Guidelines/Mandatories:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input required class="form-check-input" type="checkbox" value="3" id="flexCheckChecked3" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked3">
                                                                    Color of Ad:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input required class="form-check-input" type="checkbox" value="4" id="flexCheckChecked4"  />
                                                                <label class="form-check-label" for="flexCheckChecked4">
                                                                   Size of Ad:
                                                                </label>
                                                            </div>
                                                            <div class="form-check form-check-custom form-check-solid pt-3 pb-3">
                                                                <input required class="form-check-input" type="checkbox" value="5" id="flexCheckChecked5" checked="checked" />
                                                                <label class="form-check-label" for="flexCheckChecked5">
                                                                   Note/Instructions:
                                                                </label>
                                                            </div>
                                                        </div>
                                                </div>
                                                    <div class="border-top ">
                                                      
                                                       
                                                        <div  class="row pt-6 pb-6">
                                                     
                                                            <p class="align-items-center text-center fw-bold">Upload Completed Design Files Below</p>
                                                     
                                                    <div class="col-md-6 col-sm-3 col-xs-6 pt-2 pb-2 pe-6">
                                                          <!--begin::Form-->
                                                    <!--begin::Input group-->
                                                    <div class="fv-row">
                                                        <!--begin::Dropzone-->
                                                        <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_example_indd">
                                                            <!--begin::Message-->
                                                            <div class="dz-message needsclick row text-center">

                                                                <!--begin::Info-->
                                                                <div class="ms-4">
                                                                    <img src="<%=assetsPath %>/media/indesign.png" alt="idml"  class="img-50 pb-6"/>
                                                                    <h3 class="fs-5 fw-bolder text-gray-900 mb-1">INDD or IDML</h3>
                                                                    <span class="fs-7 fw-bold text-gray-400">Upload up to 1 files</span>
                                                                </div>
                                                                <!--end::Info-->
                                                            </div>
                                                        </div>
                                                        <!--end::Dropzone-->
                                                    </div>
                                                    <!--end::Input group-->
                                                <!--end::Form-->
                                                    </div>
                                                    <div class="col-md-6 col-sm-3 col-xs-6 pt-2 pb-2 ps-6 ">
                                                             <!--begin::Form-->
                                               
                                                    <!--begin::Input group-->
                                                    <div class="fv-row">
                                                        <!--begin::Dropzone-->
                                                        <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_example_pdf">
                                                            <!--begin::Message-->
                                                            <div class="dz-message needsclick row text-center">
                                                                <!--begin::Icon-->
                                                               
                                                                <!--end::Icon-->

                                                                <!--begin::Info-->
                                                                <div class="ms-4">
                                                                    <img src="<%=assetsPath %>/media/pdf1.png" alt="pdf"  class="img-50 pb-6"/>
                                                                    <h3 class="fs-5 fw-bolder text-gray-900 mb-1">Proof PDF</h3>
                                                                    <span class="fs-7 fw-bold text-gray-400">Upload up to 1 files</span>
                                                                </div>
                                                                <!--end::Info-->
                                                            </div>
                                                        </div>
                                                        <!--end::Dropzone-->
                                                    </div>
                                                    <!--end::Input group-->
                                                <!--end::Form-->
                                                    </div>
                                                    <div class="col-md-6 col-sm-3 col-xs-6 pt-6 pb-6  pe-6">
                                                        <!--begin::Form-->
                                                  <!--begin::Input group-->
                                                  <div class="fv-row">
                                                      <!--begin::Dropzone-->
                                                      <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_example_13">
                                                          <!--begin::Message-->
                                                          <div class="dz-message needsclick row text-center">
                                                              <!--begin::Icon-->
                                                             
                                                              <!--end::Icon-->
 
                                                              <!--begin::Info-->
                                                              <div class="ms-4">
                                                                <img src="<%=assetsPath %>/media/link.png" alt="images"  class="img-50 pb-6"/>
                                                                  <h3 class="fs-5 fw-bolder text-gray-900 mb-1">Images, Logos & Links</h3>
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
                                                  <div class="col-md-6 col-sm-3 col-xs-6 pt-6 pb-6 ps-6 ">
                                                           <!--begin::Form-->
                                                  <!--begin::Input group-->
                                                  <div class="fv-row">
                                                      <!--begin::Dropzone-->
                                                      <div class="dropzone bg-white border-gray-400" id="kt_dropzonejs_example_14">
                                                          <!--begin::Message-->
                                                          <div class="dz-message needsclick row text-center align-items-center">
                                                              <!--begin::Icon-->
                                                             
                                                              <!--end::Icon-->

                                                              <!--begin::Info-->
                                                              <div class="ms-4"> 
                                                                  <img src="<%=assetsPath %>/media/fonts1.png" alt="fonts"  class="img-50 pb-6"/>
                                                                  <h3 class="fs-5 fw-bolder text-gray-900 mb-1">Fonts</h3>
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
                                                    <div class="col-md-12 col-xs-12 pt-2 pb-2 right">
                                                        <button type="button" class="btn btn-secondary btn-sm col-md-3 col-xs-12  text-color-white right" >Confirm Upload</button>
                                                    </div>
                                                   
                                                        </div>
                                                     
                                                        </div>
                                                        <div class="border-top ">
                                                            <div  class="row pt-6 pb-6">
                                                                <label class="form-label">Ad Note</label>
                                                                <textarea name="adNotes" id="adNotes" class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                                                                
                                                            </div>
                                                          
                                                            </div>
                                                
                                                
                                                            <div class="col-md-12 col-xs-12 pt-6 pb-2 right">
                                                                <button type="submit" class="right btn btn-primary btn-sm col-md-3 col-xs-12" >End Design</button>
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
        
        

    </script>

	</body>
	<!--end::Body-->
</html>