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
		<title>Dashboard | Designer | Adwitads</title>
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
									
									<div class="card mb-10">
									<div class="card-body  p-5 p-lg-8">
										
										<div class="row mb-10  ps-6 pe-6">
											

												<h5 class="fs-4 text-gray-400 fw-bolder mb-0 ">TODAY'S ADS</h5>
												<div class="separator "></div>
										</div>
								
								<div class="row ">
									<div class="col-md-4 ps-6 pe-6">
										<h5 class="fs-4 text-gray-800  fw-bolder mb-0 text-center pb-3">New Ads</h5>
										<div class="landing-dark-border p-20 mb-10">
											
											<h1 class="fw-bolder fs-2tx text-primary text-center" id="newAdsId"></h1>
											
										</div>
									</div>
									
									<div class="col-md-4 ps-6 pe-6">
										<h5 class="fs-4 text-gray-800  fw-bolder mb-0 text-center pb-3">Web Ads</h5>
										<div class="landing-dark-border p-20 mb-10">
											
											<h1 class="fw-bolder fs-2tx text-primary text-center" id="onlineAdsId"></h1>
											
										</div>
									</div>
									
									<div class="col-md-4 ps-6 pe-6">
										<h5 class="fs-4 text-gray-800  fw-bolder mb-0 text-center pb-3">Revisions</h5>
										<div class="landing-dark-border p-20 mb-10">
											
											<h1 class="fw-bolder fs-2tx text-primary text-center" id="revisionAdsId"></h1>
											
										</div>
									</div>		
								</div>

								<div class="row ps-6 pe-6">
								<div class="col-md-9">
									<h5 class="fs-4 text-gray-400 fw-bolder mb-0 mt-10 pb-3">REPORTS</h5>
									
								</div>
								<div class="col-md-3">
									<input class="form-control  mb-2" placeholder="Pick date rage" id="kt_daterangepicker_4"/>
                                         
								</div>
								<div class="separator "></div>
								</div>
								<div class="row mt-10">
									<div class="col-md-4 ps-6 pe-6">
								
										<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
																		<div class="panel panel-default">
																				<div class="panel-heading" role="tab" id="headingOne">
																					<h5 class="pt-2 fw-bolder  collapsible collapsed cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block12">
																						CATEGORIZED
																						<span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder right">
																							<i class="fa fa-angle-down text-dark fs-2 " aria-hidden="true"></i>
																						</span></h5>
																						<!--<h4 class="panel-title"> <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne"> CATEGORIZED  </a> </h4>-->
																				</div>
																				<!--<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">-->
																					<div id="kt_toggle_block12">
																						<div class="panel-body p-0"> 
																						<div class="row">
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
																								Pickup
																							</div>
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
																							01
																							</div>
																						</div>
																						<div class="row ">
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
																								Multi-listing
																							</div>
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
																							56
																							</div>
																						</div>
																						<div class="row ">
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
																								New Build
																							</div>
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
																							34
																							</div>
																						</div>
																						<div class="row ">
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
																								Text Ad
																							</div>
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
																							23
																							</div>
																						</div>
																						<div class="row ">
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
																								Web Ad
																							</div>
																							<div class="col-md-6 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
																							19
																							</div>
																						</div>
																						</div>
																				</div>
																		</div>
																		
																</div>
													
																<div class="text-center pb-10">
										<a href="#" class="btn btn-primary btn-xs">View all</a>
										</div>
									</div>
									
									<div class="col-md-4 ps-6 pe-6">
										<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingTwo">
												<h5 class="pt-2 fw-bolder  collapsible collapsed cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block1">
													REVISIONS RETURNED
													<span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder right">
														<i class="fa fa-angle-down text-dark fs-2 " aria-hidden="true"></i>
													</span></h5>
													<!--<h4 class="panel-title"> <a  data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo"> REVISIONS RETURNED </a> </h4>-->
											</div>
											<!--<div id="collapseTwo" class="panel-collapse collapse  in" role="tabpanel" aria-labelledby="headingTwo">-->
												<div id="kt_toggle_block1">
												<div class="panel-body p-0"> 
													<div class="row">
														<div class="col-md-4 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															v1a
														</div>
														<div class="col-md-8 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														38
														</div>
													</div>
													<div class="row ">
														<div class="col-md-4 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															v1b
														</div>
														<div class="col-md-8 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														25
														</div>
													</div>
													<div class="row ">
														<div class="col-md-4 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															v1c
														</div>
														<div class="col-md-8 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														15
														</div>
													</div>
													<div class="row ">
														<div class="col-md-4 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															v1d
														</div>
														<div class="col-md-8 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														08
														</div>
													</div>
													<div class="row ">
														<div class="col-md-4 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															v1e
														</div>
														<div class="col-md-8 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														03
														</div>
													</div>
													</div>
											</div>
									</div></div>
									<div class="text-center pb-10">
									
											<a href="#" class="btn btn-primary btn-xs">View all</a>
											</div>
									</div>
									
									<div class="col-md-4 ps-6 pe-6">
										<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
										<div class="panel panel-default">
											<div class="panel-heading" role="tab" id="headingThree">
												<h5 class="pt-2 fw-bolder  collapsible collapsed cursor-pointer" data-bs-toggle="collapse" href="#kt_toggle_block">
													PUBLICATIONS
													<span class="svg-icon svg-icon-3 rotate-n180 ms-1 fw-bolder right">
														<i class="fa fa-angle-down text-dark fs-2 " aria-hidden="true"></i>
													</span></h5>
													<!--<h4 class="panel-title">
                                                    <a class="collapsed col-md-12" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree"> PUBLICATIONS  </a> </h4>-->
											</div>
											<!--<div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingThree">-->
												<div id="kt_toggle_block">
												<div class="panel-body p-0"> 
													<div class="row">
														<div class="col-md-9 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															Waukesha Freeman
														</div>
														<div class="col-md-3 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														34
														</div>
													</div>
													<div class="row ">
														<div class="col-md-9 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															Shelby County Advertiser
														</div>
														<div class="col-md-3 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														01
														</div>
													</div>
													<div class="row ">
														<div class="col-md-9 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															Desert Shoppers
														</div>
														<div class="col-md-3 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														11
														</div>
													</div>
													<div class="row ">
														<div class="col-md-9 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
														Times New Herald
														</div>
														<div class="col-md-3 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														08
														</div>
													</div>
													<div class="row ">
														<div class="col-md-9 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-right panel-border-top" >
															Corry Journal
														</div>
														<div class="col-md-3 col-sm-6 col-xs-6 ps-6 pe-6 pt-3 pb-3 panel-border-top fs-4 text-primary">
														27
														</div>
													</div>
													</div>
											</div>
									</div></div>
									<div class="text-center pb-10">
										<a href="#" class="btn btn-primary btn-xs align-items-center">View all</a>
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
		
		
		<script src="<%=assetsPath %>/js/custom_ajax.js"></script>
		
		<!--end::Page Custom Javascript-->
		<!--Drop Zone-->
<script>
	// pre defined date range//
var start = moment().subtract(29, "days");
var end = moment();

function cb(start, end) {
    $("#kt_daterangepicker_4").html(start.format("MMMM D, YYYY") + " - " + end.format("MMMM D, YYYY"));
}

$("#kt_daterangepicker_4").daterangepicker({
    startDate: start,
    endDate: end,
    ranges: {
    "Today": [moment(), moment()],
    "Yesterday": [moment().subtract(1, "days"), moment().subtract(1, "days")],
    "Last 7 Days": [moment().subtract(6, "days"), moment()],
    "Last 30 Days": [moment().subtract(29, "days"), moment()],
    "This Month": [moment().startOf("month"), moment().endOf("month")],
    "Last Month": [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
    }
}, cb);

cb(start, end);


getAjaxDate('<%=contextPath %>/dashboard/v1/ajax/newadscount', 'newAdsId');
getAjaxDate('<%=contextPath %>/dashboard/v1/ajax/onlineadscount', 'onlineAdsId');
getAjaxDate('<%=contextPath %>/dashboard/v1/ajax/revisionadscount', 'revisionAdsId');


</script>
	</body>
	<!--end::Body-->
</html>