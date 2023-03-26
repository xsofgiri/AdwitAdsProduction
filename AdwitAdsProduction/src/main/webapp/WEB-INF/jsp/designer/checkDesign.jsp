<%@page import="com.production.util.Constants"%>
<%@page import="com.production.entity.Designer"%>
<%
String contextPath = request.getContextPath();
String assetsPath = contextPath+"/assets";
assetsPath = Constants.S3_ASSET_URL;

Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
: null;

%>

<!DOCTYPE html>
<html lang="en">
	<!--begin::Head-->
	<head><base href="">
		<title>QA/Proofread|{Type of Ad}|CSR|AdwitAds</title>
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

				
					<!--begin::Header-->
					<div id="kt_header"  class="header align-items-stretch">
						<!--begin::Container-->
						<div class="container-xxl d-flex align-items-stretch justify-content-between">
							<!--begin::Aside mobile toggle-->
							<!--end::Aside mobile toggle-->
							<!--begin::Logo-->
							<div class="d-flex align-items-center flex-grow-1 flex-lg-grow-0 me-lg-15">
								<a href="?page=index">
									<img alt="Logo" src="https://adwitads.com/weborders/<%=assetsPath %>/new_client/img/logo.png" class="h-20px h-lg-30px" />
								</a>
							</div>
							<!--end::Logo-->
							<!--begin::Wrapper-->
							<div class="d-flex align-items-stretch justify-content-between flex-lg-grow-1">
								<!--begin::Navbar-->
								<div class="d-flex align-items-stretch" id="kt_header_nav">

							
									<!--begin::Menu wrapper-->
									<div class="header-menu align-items-stretch" data-kt-drawer="true" data-kt-drawer-name="header-menu" data-kt-drawer-activate="{default: true, lg: false}" data-kt-drawer-overlay="true" data-kt-drawer-width="{default:'200px', '300px': '250px'}" data-kt-drawer-direction="end" data-kt-drawer-toggle="#kt_header_menu_mobile_toggle" data-kt-swapper="true" data-kt-swapper-mode="prepend" data-kt-swapper-parent="{default: '#kt_body', lg: '#kt_header_nav'}">
										<!--begin::Menu-->
										<div class="menu menu-lg-rounded menu-column menu-lg-row menu-state-bg menu-title-gray-700 menu-state-title-primary menu-state-icon-primary menu-state-bullet-primary menu-arrow-gray-400 fw-bold my-5 my-lg-0 align-items-stretch" id="#kt_header_menu" data-kt-menu="true">
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item here show menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title">Dashboards</span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
											
											</div>
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title">Workstation</span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
												
											</div>
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title">Place Orders</span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
												
											</div>
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title">Reports</span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
												<div class="menu-sub menu-sub-lg-down-accordion menu-sub-lg-dropdown menu-rounded-0 py-lg-4 w-lg-225px">
													<div data-kt-menu-trigger="{default:'click', lg: 'hover'}" data-kt-menu-placement="right-start" class="menu-item menu-lg-down-accordion">
														<span class="menu-link py-3">
															<span class="menu-icon">
																<!--begin::Svg Icon | path: icons/duotune/abstract/abs042.svg-->
																<span class="svg-icon svg-icon-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																		<path d="M18 21.6C16.6 20.4 9.1 20.3 6.3 21.2C5.7 21.4 5.1 21.2 4.7 20.8L2 18C4.2 15.8 10.8 15.1 15.8 15.8C16.2 18.3 17 20.5 18 21.6ZM18.8 2.8C18.4 2.4 17.8 2.20001 17.2 2.40001C14.4 3.30001 6.9 3.2 5.5 2C6.8 3.3 7.4 5.5 7.7 7.7C9 7.9 10.3 8 11.7 8C15.8 8 19.8 7.2 21.5 5.5L18.8 2.8Z" fill="black" />
																		<path opacity="0.3" d="M21.2 17.3C21.4 17.9 21.2 18.5 20.8 18.9L18 21.6C15.8 19.4 15.1 12.8 15.8 7.8C18.3 7.4 20.4 6.70001 21.5 5.60001C20.4 7.00001 20.2 14.5 21.2 17.3ZM8 11.7C8 9 7.7 4.2 5.5 2L2.8 4.8C2.4 5.2 2.2 5.80001 2.4 6.40001C2.7 7.40001 3.00001 9.2 3.10001 11.7C3.10001 15.5 2.40001 17.6 2.10001 18C3.20001 16.9 5.3 16.2 7.8 15.8C8 14.2 8 12.7 8 11.7Z" fill="black" />
																	</svg>
																</span>
																<!--end::Svg Icon-->
															</span>
															<span class="menu-title">Toolbars</span>
															<span class="menu-arrow"></span>
														</span>
														<div class="menu-sub menu-sub-lg-down-accordion menu-sub-lg-dropdown menu-active-bg py-lg-4 w-lg-225px">
															<div class="menu-item">
																<a class="menu-link py-3" href="?page=layouts/toolbars/toolbar-1">
																	<span class="menu-bullet">
																		<span class="bullet bullet-dot"></span>
																	</span>
																	<span class="menu-title">Toolbar 1</span>
																</a>
															</div>
															<div class="menu-item">
																<a class="menu-link py-3" href="?page=layouts/toolbars/toolbar-2">
																	<span class="menu-bullet">
																		<span class="bullet bullet-dot"></span>
																	</span>
																	<span class="menu-title">Toolbar 2</span>
																</a>
															</div>
															<div class="menu-item">
																<a class="menu-link py-3" href="?page=layouts/toolbars/toolbar-3">
																	<span class="menu-bullet">
																		<span class="bullet bullet-dot"></span>
																	</span>
																	<span class="menu-title">Toolbar 3</span>
																</a>
															</div>
														</div>
													</div>
													<div data-kt-menu-trigger="{default:'click', lg: 'hover'}" data-kt-menu-placement="right-start" class="menu-item menu-lg-dropdown">
														<span class="menu-link py-3">
															<span class="menu-icon">
																<!--begin::Svg Icon | path: icons/duotune/general/gen009.svg-->
																<span class="svg-icon svg-icon-2">
																	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
																		<path opacity="0.3" d="M21 22H14C13.4 22 13 21.6 13 21V3C13 2.4 13.4 2 14 2H21C21.6 2 22 2.4 22 3V21C22 21.6 21.6 22 21 22Z" fill="black" />
																		<path d="M10 22H3C2.4 22 2 21.6 2 21V3C2 2.4 2.4 2 3 2H10C10.6 2 11 2.4 11 3V21C11 21.6 10.6 22 10 22Z" fill="black" />
																	</svg>
																</span>
																<!--end::Svg Icon-->
															</span>
															<span class="menu-title">Aside</span>
															<span class="menu-arrow"></span>
														</span>
														<div class="menu-sub menu-sub-lg-down-accordion menu-sub-lg-dropdown menu-active-bg py-lg-4 w-lg-225px">
															<div class="menu-item">
																<a class="menu-link py-3" href="?page=layouts/aside/light">
																	<span class="menu-bullet">
																		<span class="bullet bullet-dot"></span>
																	</span>
																	<span class="menu-title">Light Skin</span>
																</a>
															</div>
															<div class="menu-item">
																<a class="menu-link py-3" href="?page=layouts/aside/font-icons">
																	<span class="menu-bullet">
																		<span class="bullet bullet-dot"></span>
																	</span>
																	<span class="menu-title">Font Icons</span>
																</a>
															</div>
														</div>
													</div>
													
												</div>
											</div>
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title"><span class="menu-icon">
														<i class="bi bi-envelope fs-2"></i>
													</span></span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
												
											</div>
											<div data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" class="menu-item menu-lg-down-accordion me-lg-1">
												<span class="menu-link py-3">
													<span class="menu-title"><span class="menu-icon">
													<i class="bi bi-question-circle fs-2"></i>
													</span></span>
													<span class="menu-arrow d-lg-none"></span>
												</span>
												
											</div>
										</div>
										<!--end::Menu-->
									</div>
									<!--end::Menu wrapper-->
									
								</div>
								<!--end::Navbar-->

							
								<!--begin::Toolbar wrapper-->
								<div class="d-flex align-items-stretch flex-shrink-0">
								
									<!--begin::User menu-->
									<div class="d-flex align-items-center ms-1 ms-lg-3" id="kt_header_user_menu_toggle">
										<!--begin::Menu wrapper-->
										<div class="cursor-pointer symbol symbol-30px symbol-md-40px" data-kt-menu-trigger="click" data-kt-menu-attach="parent" data-kt-menu-placement="bottom-end">
											<img src="<%=assetsPath %>/media/avatars/300-1.jpg" alt="user" />
										</div>

									
										<!--begin::User account menu-->
										<div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg menu-state-primary fw-bold py-4 fs-6 w-275px" data-kt-menu="true">
											<!--begin::Menu item-->
											<div class="menu-item px-3">
												<div class="menu-content d-flex align-items-center px-3">
													<!--begin::Avatar-->
													<div class="symbol symbol-50px me-5">
														<img alt="Logo" src="<%=assetsPath %>/media/avatars/300-1.jpg" />
													</div>
													<!--end::Avatar-->
													<!--begin::Username-->
													<div class="d-flex flex-column">
														<div class="fw-bolder d-flex align-items-center fs-5">Max Smith</div>
														<a href="#" class="fw-bold text-muted text-hover-primary fs-7">max@kt.com</a>
													</div>
													<!--end::Username-->
												</div>
											</div>
											<!--end::Menu item-->
											<!--begin::Menu separator-->
											<div class="separator my-2"></div>
											<!--end::Menu separator-->
											<!--begin::Menu item-->
											<div class="menu-item px-5">
												<a href="?page=account/overview" class="menu-link px-5">My Profile</a>
											</div>
											<!--end::Menu item-->
											
											
											<!--begin::Menu item-->
											<div class="menu-item px-5">
												<a href="?page=authentication/flows/basic/sign-in" class="menu-link px-5">Sign Out</a>
											</div>
											<!--end::Menu item-->
										</div>
										<!--end::User account menu-->
										
										<!--end::Menu wrapper-->
									</div>
									<!--end::User menu-->
									<!--begin::Header menu toggle-->
									<div class="d-flex align-items-center d-lg-none ms-2 me-n3" title="Show header menu">
										<div class="btn btn-icon btn-active-light-primary w-30px h-30px w-md-40px h-md-40px" id="kt_header_menu_mobile_toggle">
											<!--begin::Svg Icon | path: icons/duotune/text/txt001.svg-->
											<span class="svg-icon svg-icon-1">
												<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
													<path d="M13 11H3C2.4 11 2 10.6 2 10V9C2 8.4 2.4 8 3 8H13C13.6 8 14 8.4 14 9V10C14 10.6 13.6 11 13 11ZM22 5V4C22 3.4 21.6 3 21 3H3C2.4 3 2 3.4 2 4V5C2 5.6 2.4 6 3 6H21C21.6 6 22 5.6 22 5Z" fill="black" />
													<path opacity="0.3" d="M21 16H3C2.4 16 2 15.6 2 15V14C2 13.4 2.4 13 3 13H21C21.6 13 22 13.4 22 14V15C22 15.6 21.6 16 21 16ZM14 20V19C14 18.4 13.6 18 13 18H3C2.4 18 2 18.4 2 19V20C2 20.6 2.4 21 3 21H13C13.6 21 14 20.6 14 20Z" fill="black" />
												</svg>
											</span>
											<!--end::Svg Icon-->
										</div>
									</div>
									<!--end::Header menu toggle-->
								</div>
								<!--end::Toolbar wrapper-->
								
							</div>
							<!--end::Wrapper-->
						</div>
						<!--end::Container-->
					</div>
					<!--end::Header-->
					
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
                                                            <h5 class="pt-2 fw-bolder text-color-white collapsible collapsed cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block">  Order Details  
                                                                <span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder text-color-white right">
                                                                    <i class="fa fa-angle-down text-color-white fs-2 " aria-hidden="true"></i>
                                                                </span></h5>
                                                           <!---- <span class="fw-bolder text-color-white collapsible collapsed cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block">
                                                            Order Details
                                                            <span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder text-color-white right">
                                                                <i class="fa fa-angle-down text-color-white fs-2 " aria-hidden="true"></i>
                                                            </span>
                                                            </span>-->
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                                <div id="kt_toggle_block" class="" >
                                               <div class="row " >
                                                <div class="col-md-6 ps-6 pt-6 ">
                                                    <p class="fw-bolder"> <u> Order Information</u></p>
                                                      <p>Order Date:</p>
                                                      <p>Advertiser Name: </p>
                                                      <p>Publication Name:</p>
                                                      <p>Ad Rep Name:</p>
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
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked"  />
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
                                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked"  />
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
                                                            <iframe class="border-radius-5" width="100%" height="300px" src="<%=assetsPath %>/media/nature.jpeg" ></iframe>
                                                            </div>
                                                            
                                                       </div>
                                                    </div>
                                                      </div>
                                                       
                                                        </div>
                                                <div  class="row pt-2 ">
                                                    <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                        <button type="button" class=" btn btn-primary btn-sm col-md-6 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_5">Send Back to Designer</button>
                                                    </div>
                                                 <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                                <button type="button" class="btn btn-secondary btn-sm col-md-6 col-xs-10  text-color-white" >Download Native Files</button>
                                                            </div>
                                                            <div class="col-md-4 col-xs-6 pt-2 pb-2 align-items-center text-center">
                                                                <button type="button" class=" btn btn-success btn-sm col-md-6 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_4">Send to Ad Rep</button>
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

      
      
        <div class="modal fade" tabindex="-1" id="kt_modal_4">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Send Note to Ad Rep </h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                        <div  class="row pt-2 pb-3 ">
                               
                            <div class="col-md-12 ps-6 pe-6">
                                <div class="d-flex flex-column" id="toastTypeGroup">
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note" >
                                        <span class="form-check-label">Instruction Not Followed</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note">
                                        <span class="form-check-label">Color Error</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note">
                                        <span class="form-check-label">Size Error</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note">
                                        <span class="form-check-label">Unsuitable design</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note">
                                        <span class="form-check-label">Client Mandatories Not Followed</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="Note" checked="checked">
                                        <span class="form-check-label">Other</span>
                                    </label>
                                </div>

                                
                               
                            </div>
                        </div>
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6">
                            <label class="form-label">Ad Note</label>
                        <textarea class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                        </div>
                    </div>
                    <div class="border-top ">
                        <div class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-success btn-sm col-md-5 col-xs-6">Send Note to Ad Rep</button>
                            </div>
                           
                        </div>
                      
                        </div>
                   


                </div>
            </div>
        </div>

   
		
        <div class="modal fade" tabindex="-1" id="kt_modal_5">
            <div class="modal-dialog modal-dialog-centered ">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Send Back to Designer </h5>
        
                        <!--begin::Close-->
                        <div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal" aria-label="Close">
                            <i class="bi bi-x-circle fs-2x"></i>
                        </div>
                        <!--end::Close-->
                    </div>
        
                    <div class="modal-body">
                        <div  class="row pt-2 pb-3 ">
                               
                            <div class="col-md-12 ps-6 pe-6">
                                <div class="d-flex flex-column" id="toastTypeGroup">
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts" >
                                        <span class="form-check-label">Instruction Not Followed</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm  pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts">
                                        <span class="form-check-label">Color Error</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts">
                                        <span class="form-check-label">Size Error</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts">
                                        <span class="form-check-label">Unsuitable design</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts">
                                        <span class="form-check-label">Client Mandatories Not Followed</span>
                                    </label>
                                    <label class="form-check form-check-custom form-check-solid form-check-sm pt-3 pb-3">
                                        <input class="form-check-input" type="radio" value="" name="toasts" checked="checked">
                                        <span class="form-check-label">Other</span>
                                    </label>
                                </div>

                                
                               
                            </div>
                        </div>
                        
                        <div class="row pt-3 pb-3 ps-6 pe-6">
                            <label class="form-label">Ad Note</label>
                        <textarea class="form-control border-dashed" placeholder="Type here" id="floatingTextarea2" style="height: 100px"></textarea>
                        </div>
                        <div class="row pt-3 pb-3 ps-6 pe-6">
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
                            </form>
                            <!--end::Form-->
                        </div>
                    </div>
                    <div class="border-top ">
                        <div class="row pt-6 pb-6 align-items-center text-center">
                            <div class="col-md-12">
                                <button type="button" class="btn btn-primary btn-sm col-md-5 col-xs-6">Send to Designer</button>
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
        </script>

	</body>
	<!--end::Body-->
</html>