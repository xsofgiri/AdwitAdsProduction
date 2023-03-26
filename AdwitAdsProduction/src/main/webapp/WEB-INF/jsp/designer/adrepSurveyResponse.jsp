<%@page import="com.production.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String contextPath = request.getContextPath();
String assetsPath = contextPath+"/assets";
assetsPath = Constants.S3_ASSET_URL;

String responseMessage = request.getAttribute(Constants.USER_SUCCESS_MESSAGE)!=null?(String)request.getAttribute(Constants.USER_SUCCESS_MESSAGE):null;
%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Adrep Survey</title>


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

<style>

	.btn-rating{
		border:1px solid #50cd89 !important;
		border-radius: .475rem;
	}
	
	.btn-outline-primary{
		margin: 10px;
		border-radius: .475rem !important;
		border:1px solid #50cd89 !important;
		color: #50cd89;
	}
    
     .btn-check:checked + .btn-outline-primary{
     	color: #000;
		background-color: #50cd89;
		border-radius: .475rem !important;
		border:1px solid #50cd89 !important;
     }
     
      .header {
	  border-bottom: 1px solid #9e9e9e;
	  position: fixed;
	  top: 0;
	  right: 0;
	  left: 0;
	  z-index: 100;
	  background-color: #fff;
	  height: 65px;
	  padding: 0;
	  box-shadow: 0 10px 30px 0 rgba(82,63,105,.05);
	}
     
</style>
</head>
<body data-kt-name="metronic" id="kt_body" class="app-blank app-blank bgi-size-cover bgi-position-center bgi-no-repeat">

<div class="d-flex flex-column flex-root" id="kt_app_root">

<!--begin::Header--> 
					<div id="kt_header" style="" class="header align-items-stretch">
						<!--begin::Container-->
						<div class="container-xxl d-flex align-items-stretch justify-content-between">
							<!--begin::Aside mobile toggle-->
							<!--end::Aside mobile toggle-->
							<!--begin::Logo-->
							<div class="d-flex align-items-center" style="width: 100%;text-align: center;">
								<a href="https://adwitads.com" target="_blank">
									<img alt="Logo" src="<%=assetsPath %>/media/logos/adwit-logo-black.png" class="h-20px h-lg-30px" />
								</a>
							</div>
							<!--end::Logo-->
							<!--begin::Wrapper-->
							
							<!--end::Wrapper-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Header-->
					
<div class="d-flex flex-column flex-column-fluid flex-lg-row">



					
					
<div class="d-flex flex-center w-lg-100 pt-15 pt-lg-0 px-10">



<div class="card shadow-sm w-lg-50 d-flex">
    
    <div class="card-body">
		        
		<%if(responseMessage!=null){ %>
			<h4 style="line-height: 30px"><%=responseMessage %></h4>
		<%}else{ %>
		 	<h4  style="line-height: 30px">Thank you for taking the time to provide us with your valuable feedback. Your responses will help us improve our products and services to better meet your needs. We appreciate your time and look forward to continuing to serve your design requirements.</h4>
		 <%} %>
    </div>
    
</div>




</div>
</div> 
</div>



<!--begin::Footer-->
					<div class="footer py-4 d-flex flex-lg-column mt-10" id="kt_footer">
						<!--begin::Container-->
						<div class="container-xxl d-flex flex-column flex-md-row align-items-center justify-content-between">
							<!--begin::Copyright-->
							<div class="text-dark order-2 order-md-1">
								<ul class="menu menu-gray-600 menu-hover-primary fw-bold order-1">
<!-- 									<li class="menu-item"> -->
<!-- 										<a href="" target="_blank" class="menu-link px-2"> -->
<!-- 											<i class="fab fa-facebook-square fs-2x"></i> -->
<!-- 										</a> -->
<!-- 									</li> -->
<!-- 									<li class="menu-item"> -->
<!-- 										<a href="" target="_blank" class="menu-link px-2"> -->
<!-- 											<i class="fab fa-twitter-square fs-2x"></i> -->
<!-- 										</a> -->
<!-- 									</li> -->
<!-- 									<li class="menu-item"> -->
<!-- 										<a href="" target="_blank" class="menu-link px-2"> -->
<!-- 											<i class="fab fa-instagram fs-2x"></i> -->
<!-- 										</a> -->
<!-- 									</li> -->
<!-- 									<li class="menu-item"> -->
<!-- 										<a href="" target="_blank" class="menu-link px-2"> -->
<!-- 											<i class="fab fa-google-plus-square fs-2x"></i> -->
<!-- 										</a> -->
<!-- 									</li> -->
								</ul>
							</div>
							<!--end::Copyright-->
							<!--begin::Menu-->
							<ul class="menu menu-gray-600 menu-hover-primary fw-bold order-1">
								
								<li class="menu-item">
									<a href="mailto:contactus@adwitglobal.com" target="_blank" class="menu-link px-2">Contact Us</a>
								</li>
							</ul>
							<!--end::Menu-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Footer-->
					
					

<!-- <script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" /> -->
 
<%--  <script src="<%=assetsPath %>/plugins/global/plugins.bundle.js"></script> --%>
<%-- 		<script src="<%=assetsPath %>/js/scripts.bundle.js"></script> --%>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>