<%@page import="com.production.util.EncryptionUtil"%>
<%@page import="com.production.entity.Orders"%>
<%@page import="com.production.entity.LiveOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.production.util.Constants"%>
<%@page import="com.production.entity.Designer"%>
<%
String contextPath = request.getContextPath();
String assetsPath = contextPath+"/assets";
assetsPath = Constants.S3_ASSET_URL;

Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
: null;

ArrayList<LiveOrder> liveOrderList = request.getAttribute(Constants.DESIGNER_WORKSTATION_ORDER_LIST)!=null?(ArrayList<LiveOrder>)request.getAttribute(Constants.DESIGNER_WORKSTATION_ORDER_LIST):null;
ArrayList<LiveOrder> inProductionOrderList = request.getAttribute(Constants.DESIGNER_WORKSTATION_INPRODUCTION_ORDER_LIST)!=null?(ArrayList<LiveOrder>)request.getAttribute(Constants.DESIGNER_WORKSTATION_INPRODUCTION_ORDER_LIST):null;
ArrayList<LiveOrder> designCheckOrderList = request.getAttribute(Constants.DESIGNER_WORKSTATION_DESIGN_CHECK_ORDER_LIST)!=null?(ArrayList<LiveOrder>)request.getAttribute(Constants.DESIGNER_WORKSTATION_DESIGN_CHECK_ORDER_LIST):null;
ArrayList<LiveOrder> qaOrderList = request.getAttribute(Constants.DESIGNER_WORKSTATION_QA_ORDER_LIST)!=null?(ArrayList<LiveOrder>)request.getAttribute(Constants.DESIGNER_WORKSTATION_QA_ORDER_LIST):null;




%>

<!DOCTYPE html>
<html lang="en">
<!--begin::Head-->
<head>
<base href="">
<title>Workstation|Designer|AdwitAds</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta property="og:locale" content="en_US" />
<meta property="og:type" content="article" />
<link rel="shortcut icon"
	href="<%=assetsPath %>/media/logos/favicon.ico" />
<!--begin::Fonts-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" />
<!--end::Fonts-->
<!--begin::Page Vendor Stylesheets(used by this page)-->
<link
	href="<%=assetsPath %>/plugins/custom/fullcalendar/fullcalendar.bundle.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=assetsPath %>/plugins/custom/datatables/datatables.bundle.css"
	rel="stylesheet" type="text/css" />
<!--end::Page Vendor Stylesheets-->
<!--begin::Global Stylesheets Bundle(used by all pages)-->
<link href="<%=assetsPath %>/plugins/global/plugins.bundle.css"
	rel="stylesheet" type="text/css" />
<link href="<%=assetsPath %>/css/style.bundle.css" rel="stylesheet"
	type="text/css" />
<link href="<%=assetsPath %>/css/csr-custom.css" rel="stylesheet"
	type="text/css" />
<!--begin::Page Vendor Stylesheets(used by this page)-->
<link href="<%=assetsPath %>/plugins/custom/prismjs/prismjs.bundle.css"
	rel="stylesheet" type="text/css" />
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
			<div class="wrapper d-flex flex-column flex-row-fluid"
				id="kt_wrapper">

				<jsp:include page="header.jsp"></jsp:include>

				<!--begin::Content-->
				<div class="content d-flex flex-column flex-column-fluid"
					id="kt_content">
					<!--begin::Post-->
					<div class="post d-flex flex-column-fluid" id="kt_post">


 
						<!--begin::Container-->
						<div id="kt_content_container" class="container-xxl">
							<div class="card mb-10">
								<div class="card-body  p-5 p-lg-8">
									<div class="row ">
										<div class="col-md-3">
											<select name="status" data-control="select2"
												data-hide-search="true" class="form-select form-select-sm ">
												<option value="Active" selected="selected">My Queue</option>
												<option value="Approved">In Progress</option>
												<option value="Declined">To Do</option>
												<option value="In Progress">Completed</option>
											</select>

										</div>
										<div class="col-md-3"></div>
										<div class="col-md-6  float-right">
											<div class="mb-10 pt-4 pb-4">
												<a href="#"
													class="btn btn-back-white btn-sm mb-2 mx-6 col-md-3">Create
													New Ad</a> <a href="#"
													class="btn btn-back-white btn-sm mb-2 col-md-3">Submit
													Revision</a>
											</div>

										</div>
										<div class="col-md-10 ">
											<div class="mb-10">
												<!--begin::Radio group-->
												<div class="btn-group w-100 " data-kt-buttons="true"
													data-kt-buttons-target="[data-kt-button]">
													<!--begin::Radio-->
													<label
														class="btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark active all"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method"
														checked="checked" value="1" /> <!--end::Input--> All(<%=liveOrderList!=null?liveOrderList.size():0 %>)
													</label>
													<!--end::Radio-->

													<!--begin::Radio-->
													<label
														class="production btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark "
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="2" />
														<!--end::Input--> Revisions (0)
													</label>
													<!--end::Radio-->

													<!--begin::Radio-->
													<label
														class="proof btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="3" />
														<!--end::Input--> Questions Answered (0)
													</label>
													<!--end::Radio-->

													<!--begin::Radio-->
													<label
														class="questions btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="4" />
														<!--end::Input--> In Production (<%=inProductionOrderList!=null?inProductionOrderList.size():0 %>)
													</label>
													<!--end::Radio-->
													<!--begin::Radio-->
													<label
														class="approved btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="4" />
														<!--end::Input--> QA (<%=qaOrderList!=null?qaOrderList.size():0 %>)
													</label> <label
														class="designcheck btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="4" />
														<!--end::Input--> Design Check (<%=designCheckOrderList!=null?designCheckOrderList.size():0 %>)
													</label> <label
														class="proofsent btn btn-outline-secondary text-muted text-hover-white text-active-white btn-outline btn-active-dark"
														data-kt-button="true"> <!--begin::Input--> <input
														class="btn-check" type="radio" name="method" value="4" />
														<!--end::Input--> Proof Sent (0)
													</label>
													<!--end::Radio-->
												</div>
												<!--end::Radio group-->
											</div>
										</div>

										<div class="col-md-2 ">
											<div class="mb-10">
												<div
													class="d-flex align-items-center position-relative text-right">
													<!--begin::Svg Icon | path: icons/duotune/general/gen021.svg-->
													<span class="svg-icon svg-icon-1 position-absolute ms-6">
														<svg xmlns="http://www.w3.org/2000/svg" width="24"
															height="24" viewBox="0 0 24 24" fill="none">
                                                                <rect
																opacity="0.5" x="17.0365" y="15.1223" width="8.15546"
																height="2" rx="1" transform="rotate(45 17.0365 15.1223)"
																fill="black"></rect>
                                                                <path
																d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z"
																fill="black"></path>
                                                            </svg>
													</span>
													<!--end::Svg Icon-->
													<input type="text" data-kt-user-table-filter="search"
														class="form-control form-control-solid  ps-14"
														placeholder="Search">
												</div>
											</div>
										</div>
										<div class="col-md-12 alltable">
											<div class="mb-10">
												<table
													class="kt_datatable_example_5 table table-striped table-row-bordered gy-5 gs-7 border rounded">
													<thead>
														<tr class="fw-bolder fs-6 text-gray-800 px-7">
															<th>Order Type</th>
															<th>AdwitAds ID</th>
															<th>Unique Job Number</th>
															<th>Publication Name</th>
															<th>Category</th>
															<th>Club</th>
															<th>Status</th>
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<%if(liveOrderList!=null && liveOrderList.size()>0){
                                                            	for(LiveOrder liveOrder : liveOrderList){
                                                            		Orders orders = liveOrder.getOrders(); 
                                                            	%>
														<tr>
															<td><%=orders.getOrderTypeId()==1?"Online":orders.getOrderTypeId()==2?"Print":"-" %></td>
															<td><%=orders.getOrderId() %></td>
															<td><%=liveOrder.getJobNo() %></td>
															<td><%=liveOrder.getPublication()!=null?liveOrder.getPublication().getName():"-" %></td>
															<td><%=liveOrder.getCategory() %></td>
															<td><%=liveOrder.getClub()!=null?liveOrder.getClub().getName():"-" %></td>
															<td><%=liveOrder.getProductionStatusTitle()!=null?liveOrder.getProductionStatusTitle():liveOrder.getOrderStatusTitle() %></td>
															<td> 
																<%if(liveOrder.getOrderStatusId()==2){ %>
																	<button  class="btn btn-primary btn-sm col-md-10 col-xs-10 start_design" data-order-id="<%=orders.getOrderId() %>"  data-bs-toggle="modal" data-bs-target="#kt_modal_2">Start Design</button>
																<%}else{ %> 
																	<button  class="btn btn-primary btn-sm col-md-10 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_1">View Order</button> 
																 <%} %>
															</td>
														</tr>
														<%}
                                                            	}%>


													</tbody>
												</table>
											</div>
										</div>
										<div class="col-md-12 productiontable">
											<div class="mb-10">
												<table
													class="kt_datatable_example_5 table table-striped table-row-bordered gy-5 gs-7 border rounded">
													<thead>
														<tr class="fw-bolder fs-6 text-gray-800 px-7">

															<th>AdwitAds ID</th>
															<th>Unique Job Number</th>
															<th>Advertiser Name</th>
															<th>Ad Rep Name</th>
															<th>Status</th>
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<tr>

															<td>2222 2222</td>
															<td>Koch and Sons</td>
															<td>Janie Monahan</td>
															<td>Janice Monahan</td>
															<td>In Production</td>
															<td><span> <i class="bi bi-eye-fill fs-2 p-2"
																	data-bs-toggle="tooltip" data-bs-placement="top"
																	title="View Order"></i>
															</span> <span> <i
																	class="bi bi-file-earmark-pdf-fill fs-2 p-2"
																	data-bs-toggle="tooltip" data-bs-placement="top"
																	title="View PDF in new window - Or ask open with"></i>
															</span></td>
														</tr>

													</tbody>
												</table>
											</div>
										</div>
										<div class="col-md-12 prooftable">
											<div class="mb-10">
												<p>Questions Answered</p>
											</div>
										</div>
										<div class="col-md-12 questionstable">
											<div class="mb-10">
												<table
													class="kt_datatable_example_5 table table-striped table-row-bordered gy-5 gs-7 border rounded">
													<thead>
														<tr class="fw-bolder fs-6 text-gray-800 px-7">
															<th>Order Type</th>
															<th>AdwitAds ID</th>
															<th>Unique Job Number</th>
															<th>Publication Name</th>
															<th>Category</th>
															<th>Club</th>
															<th>Status</th>
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<%if(inProductionOrderList!=null && inProductionOrderList.size()>0){
                                                            	for(LiveOrder liveOrder : inProductionOrderList){
                                                            		Orders orders = liveOrder.getOrders(); 
                                                            	%>
														<tr>
															<td><%=orders.getOrderTypeId()==1?"Online":orders.getOrderTypeId()==2?"Print":"-" %></td>
															<td><%=orders.getOrderId() %></td>
															<td><%=liveOrder.getJobNo() %></td>
															<td><%=liveOrder.getPublication()!=null?liveOrder.getPublication().getName():"-" %></td>
															<td><%=liveOrder.getCategory() %></td>
															<td><%=liveOrder.getClub()!=null?liveOrder.getClub().getName():"-" %></td>
															<td><%=liveOrder.getProductionStatusTitle()!=null?liveOrder.getProductionStatusTitle():liveOrder.getOrderStatusTitle() %></td>
															<td>
																<%if(liveOrder.getOrderStatusId()==3 && (liveOrder.getProductionStatusId()==1 || liveOrder.getProductionStatusId()==6 || liveOrder.getProductionStatusId()==7 || liveOrder.getProductionStatusId()==8)){ %>
																	<a class="btn btn-primary btn-sm col-md-10 col-xs-10" href="<%=contextPath %>/designer/orders/designad/<%=EncryptionUtil.encode(orders.getOrderId()) %>/">Design Ad</button>
																<%}else{ %> 
																	<button  class="btn btn-primary btn-sm col-md-10 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_1">View Order</button>
																 <%} %> 
															</td>
														</tr>
														<%}
                                                            	}%>


													</tbody>
												</table>
											</div>
										</div>
										<div class="col-md-12 approvedtable">
											<div class="mb-10">
												<table
													class="kt_datatable_example_5 table table-striped table-row-bordered gy-5 gs-7 border rounded">
													<thead>
														<tr class="fw-bolder fs-6 text-gray-800 px-7">
															<th>Order Type</th>
															<th>AdwitAds ID</th>
															<th>Unique Job Number</th>
															<th>Publication Name</th>
															<th>Category</th>
															<th>Club</th>
															<th>Status</th>
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<%if(qaOrderList!=null && qaOrderList.size()>0){
                                                            	for(LiveOrder liveOrder : qaOrderList){
                                                            		Orders orders = liveOrder.getOrders(); 
                                                            	%>
														<tr> 
															<td><%=orders.getOrderTypeId()==1?"Online":orders.getOrderTypeId()==2?"Print":"-" %></td>
															<td><%=orders.getOrderId() %></td>
															<td><%=liveOrder.getJobNo() %></td>
															<td><%=liveOrder.getPublication()!=null?liveOrder.getPublication().getName():"-" %></td>
															<td><%=liveOrder.getCategory() %></td>
															<td><%=liveOrder.getClub()!=null?liveOrder.getClub().getName():"-" %></td>
															<td><%=liveOrder.getProductionStatusTitle()!=null?liveOrder.getProductionStatusTitle():liveOrder.getOrderStatusTitle() %></td>
															<td>
																<%if(liveOrder.getOrderStatusId()==4){ %>
																	<a class="btn btn-primary btn-sm col-md-10 col-xs-10" href="<%=contextPath %>/designer/orders/qacheck/<%=EncryptionUtil.encode(orders.getOrderId()) %>/">QA Check</button>
																<%}else{ %> 
																	<button  class="btn btn-primary btn-sm col-md-10 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_1">View Order</button>
																 <%} %> 
															</td>
														</tr>
														<%}
                                                            	}%>


													</tbody>
												</table>
											</div>
										</div>
										<div class="col-md-12 designchecktable">
											<div class="mb-10">
												<table
													class="kt_datatable_example_5 table table-striped table-row-bordered gy-5 gs-7 border rounded">
													<thead>
														<tr class="fw-bolder fs-6 text-gray-800 px-7">
															<th>Order Type</th>
															<th>AdwitAds ID</th>
															<th>Unique Job Number</th>
															<th>Publication Name</th>
															<th>Category</th>
															<th>Club</th>
															<th>Status</th> 
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<%if(designCheckOrderList!=null && designCheckOrderList.size()>0){
                                                            	for(LiveOrder liveOrder : designCheckOrderList){
                                                            		Orders orders = liveOrder.getOrders(); 
                                                            	%>
														<tr> 
															<td><%=orders.getOrderTypeId()==1?"Online":orders.getOrderTypeId()==2?"Print":"-" %></td>
															<td><%=orders.getOrderId() %></td>
															<td><%=liveOrder.getJobNo() %></td>
															<td><%=liveOrder.getPublication()!=null?liveOrder.getPublication().getName():"-" %></td>
															<td><%=liveOrder.getCategory() %></td>
															<td><%=liveOrder.getClub()!=null?liveOrder.getClub().getName():"-" %></td>
															<td><%=liveOrder.getProductionStatusTitle()!=null?liveOrder.getProductionStatusTitle():liveOrder.getOrderStatusTitle() %></td>
															<td>
																<%if(liveOrder.getOrderStatusId()==3 && liveOrder.getProductionStatusId()==2){ %>
																	<a class="btn btn-primary btn-sm col-md-10 col-xs-10" href="<%=contextPath %>/designer/orders/designcheck/<%=EncryptionUtil.encode(orders.getOrderId()) %>/">Design Check</button>
																<%}else{ %> 
																	<button  class="btn btn-primary btn-sm col-md-10 col-xs-10" data-bs-toggle="modal" data-bs-target="#kt_modal_1">View Order</button>
																 <%} %> 
															</td>
														</tr>
														<%}
                                                            	}%>


													</tbody>
												</table>
											</div>
										</div>
										<div class="col-md-12 proofsenttable">
											<div class="mb-10">
												<p>proof sent</p>
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


	<div class="modal fade" tabindex="-1" id="kt_modal_1">
		<div class="modal-dialog modal-dialog-centered mw-900px">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">View Order - (AdwitAds ID) - (Unique
						Job ID)</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div class="row ">
						<div class="col-md-6  pb-6 pt-2 ps-4 pe-4">
							<div class="border border-radius-4 height280">
								<div class="order-head fw-bold">Order Details</div>
								<div class="row">
									<div class="col-md-12 ps-6 pt-6 pb-6">
										<p>Order Date:</p>
										<p>Publish Date:</p>
										<p>
											Type of Ad: <span>Print/Web</span>
										</p>
										<p>Color of Ad:</p>
										<p>Size of Ad:</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 pb-6 pt-2 ps-4 pe-4">
							<div class="border border-radius-4 height280">
								<div class="order-head fw-bold">Advertiser Details</div>
								<div class="row">
									<div class="col-md-12 ps-6 pt-6 pb-6">
										<p>Advertiser Name:</p>
										<p>Contact Person:</p>
										<p>Email:</p>
										<p>Phone:</p>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row pt-2">
						<div class="col-md-6 pb-6 pt-2 ps-4 pe-4">
							<div class="border border-radius-4 height280">
								<div class="order-head fw-bold">Time Log</div>
								<div class="row">
									<div class="col-md-12 ps-6 pt-6 pb-6">
										<p>Order Submitted:</p>
										<p>Files Submitted:</p>
										<p>Proof(v1) Sent:</p>
										<p>Proof(v1a) Sent:</p>
										<p>Proof(v1b) Sent:</p>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 pb-6 pt-2 ps-4 pe-4">
							<div class="border border-radius-4 height280">
								<div class="order-head fw-bold">Files</div>
								<div class="row">
									<div class="col-md-12 ps-6 pt-6 ">
										<p class="fw-bold">
											Proof 1: <span>v1</span>
										</p>
										<p>Files Submitted:</p>
										<p>Ad Proof:</p>
									</div>
									<div class="col-md-12 ps-6 pt-4 border-top">
										<p class="fw-bold">
											Proof 2: <span>v1a</span>
										</p>
										<p>Files Submitted:</p>
										<p>Ad Proof:</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" tabindex="-1" id="kt_modal_2">
		<div class="modal-dialog modal-dialog-centered mw-900px">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Start Design</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div id="start_design_order_details_id"></div>

				</div>
				
			</div>
		</div>
	</div>

	<div class="modal fade" tabindex="-1" id="kt_modal_3">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">View Proof - (AdwitAds ID) - (Unique
						Job ID)</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div class="bgi-no-repeat bgi-size-cover rounded min-h-250px"
						style="background-image: url('assets/media/20.jpeg');"></div>

				</div>
				<div class="border-top ">
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-back-white btn-sm col-md-10 col-xs-6">Resend
								Proof</button>
						</div>
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-back-white btn-sm col-md-10 col-xs-6">Download
								PDF</button>
						</div>
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-back-white btn-sm col-md-10 col-xs-6">Print</button>
						</div>
					</div>

				</div>


			</div>
		</div>
	</div>
	</div>

	<div class="modal fade" tabindex="-1" id="kt_modal_4">
		<div class="modal-dialog modal-dialog-centered ">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">View Answer</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12  ">
							<p class="fw-bolder">
								<u>Question Sent: </u>
							</p>
							<p>We did not receive attachment for this order.</p>
						</div>

						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<p class="fw-bolder">
								<u> Answer:</u>
							</p>
							<p>We did not receive attachment for this order.</p>
							<div class="row">
								<div class="col-md-3">
									<p>File Received:</p>
								</div>
								<div class="col-md-9">
									<span class="fw-bolder">Link 1</span></br>
									<span class="fw-bolder">Link 2</span>
								</div>
							</div>

						</div>
					</div>

				</div>
				<div class="border-top ">
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-12">
							<button type="button"
								class="btn btn-success btn-sm col-md-6 col-xs-6">Download
								InDesign and Start</button>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" tabindex="-1" id="kt_modal_5">
		<div class="modal-dialog modal-dialog-centered mw-650px">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Accept Revision</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 pb-6 ">
							<label class="form-label">Note & Instruction</label>

							<textarea class="form-control border-dashed"
								placeholder="Type here" id="floatingTextarea2"
								style="height: 100px"></textarea>

						</div>

						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Download / View Files</label>
							<div class="row pt-2 ">
								<div class="col-md-4 col-sm-4 col-xs-6 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Marked
										Up PDF</button>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-6 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
								</div>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Download / View Previous Files</label>
							<div class="row pt-2 ">
								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<p class="fw-bold">version 2</p>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
								</div>

								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Native
										Files</button>
								</div>
								<div class="row pt-2 ">
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<p class="fw-bold">version 1</p>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
									</div>

									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Native
											Files</button>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Proof</button>
									</div>
								</div>

							</div>
						</div>
						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Select Type of Revision<sup>*</sup>
								<i class="bi bi-exclamation-circle-fill"></i></label>

							<div class="row pt-2 ">

								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a25" name="check-substitution-2"
											checked="checked" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a25">5 Mins</label>
									</div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a50" name="check-substitution-2" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a50">Text/Copy</label>
									</div>
								</div>

								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a75" name="check-substitution-2" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a75">Design Changes</label>
									</div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a175" name="check-substitution-2" />
										<label class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a175">Extensive</label>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="border-top ">
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-secondary btn-sm col-md-10 col-xs-4 sendqa text-color-white">Send
								Question</button>
						</div>
						<div class="col-md-4 pt-2 pb-2 align-items-center">
							<div class="form-check form-check-custom form-check-solid">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked"> Rush
									if possible </label>
							</div>
						</div>
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-success btn-sm col-md-10 col-xs-4">Accept
								Revision</button>
						</div>
					</div>

				</div>

				<div class="border-top openqa">
					<div class="row  border-bottom">
						<span class="ps-6 pe-6 pt-6 pb-6 fw-bolder">Send Question
							to Ad Rep </span>
					</div>
					<div class="row pt-6 pb-6 ">

						<div class="col-md-12 ps-6 pe-6">
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked"> Files
									Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" /> <label class="form-check-label"
									for="flexCheckChecked"> Art Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" /> <label class="form-check-label"
									for="flexCheckChecked"> Copy Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked">
									Instruction unclear </label>
							</div>

						</div>
					</div>
					<div class="row pt-3 pb-3 ps-6 pe-6">
						<label class="form-label">Ad Note</label>
						<textarea class="form-control border-dashed"
							placeholder="Type here" id="floatingTextarea2"
							style="height: 100px"></textarea>
					</div>
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-2"></div>
						<div class="col-md-4 col-xs-6 pt-2 pb-2">
							<button type="button"
								class="btn btn-back-white btn-sm col-md-8 col-xs-10 closeqa">close</button>
						</div>
						<div class="col-md-4 col-xs-6 pt-2 pb-2">
							<button type="button"
								class="btn btn-secondary btn-sm col-md-8 col-xs-10 text-color-white">Send
								Question</button>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<div class="modal fade" tabindex="-1" id="kt_modal_6">
		<div class="modal-dialog modal-dialog-centered mw-650px">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Accept New Ad</h5>

					<!--begin::Close-->
					<div class="btn btn-icon btn-sm ms-2" data-bs-dismiss="modal"
						aria-label="Close">
						<i class="bi bi-x-circle fs-2x"></i>
					</div>
					<!--end::Close-->
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 pb-6 ">
							<label class="form-label">Note & Instruction</label>

							<textarea class="form-control border-dashed"
								placeholder="Type here" id="floatingTextarea2"
								style="height: 100px"></textarea>

						</div>

						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Download / View Files</label>
							<div class="row pt-2 ">
								<div class="col-md-4 col-sm-4 col-xs-6 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Marked
										Up PDF</button>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-6 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
								</div>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Download / View Previous Files</label>
							<div class="row pt-2 ">
								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<p class="fw-bold">version 2</p>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
								</div>

								<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
									<button type="button"
										class="btn btn-back-white btn-sm col-md-10 col-xs-10">Native
										Files</button>
								</div>
								<div class="row pt-2 ">
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<p class="fw-bold">version 1</p>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Assets</button>
									</div>

									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Native
											Files</button>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-4 pt-2 pb-2">
										<button type="button"
											class="btn btn-back-white btn-sm col-md-10 col-xs-10">Proof</button>
									</div>
								</div>

							</div>
						</div>
						<div class="col-md-12 col-sm-12 border-top pt-6 pb-6">
							<label class="form-label">Select Type of Revision<sup>*</sup>
								<i class="bi bi-exclamation-circle-fill"></i></label>

							<div class="row pt-2 ">

								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a25" name="check-substitution-2"
											checked="checked" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a25">5 Mins</label>
									</div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a50" name="check-substitution-2" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a50">Text/Copy</label>
									</div>
								</div>

								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a75" name="check-substitution-2" /> <label
											class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a75">Design Changes</label>
									</div>
								</div>
								<div class="col-md-3 col-sm-3 col-xs-6 pt-2 pb-2">
									<div class="button-radio">
										<input type="radio" id="a175" name="check-substitution-2" />
										<label class="btn btn-back-white btn-sm col-md-10 col-xs-10"
											for="a175">Extensive</label>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="border-top ">
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-secondary btn-sm col-md-10 col-xs-4 sendqa text-color-white">Send
								Question</button>
						</div>
						<div class="col-md-4 pt-2 pb-2 align-items-center">
							<div class="form-check form-check-custom form-check-solid">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked"> Rush
									if possible </label>
							</div>
						</div>
						<div class="col-md-4 pt-2 pb-2">
							<button type="button"
								class="btn btn-success btn-sm col-md-10 col-xs-4">Accept
								Revision</button>
						</div>
					</div>

				</div>

				<div class="border-top openqa">
					<div class="row  border-bottom">
						<span class="ps-6 pe-6 pt-6 pb-6 fw-bolder">Send Question
							to Ad Rep </span>
					</div>
					<div class="row pt-6 pb-6 ">

						<div class="col-md-12 ps-6 pe-6">
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked"> Files
									Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" /> <label class="form-check-label"
									for="flexCheckChecked"> Art Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" /> <label class="form-check-label"
									for="flexCheckChecked"> Copy Missing </label>
							</div>
							<div
								class="form-check form-check-custom form-check-solid pt-3 pb-3">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckChecked" checked="checked" /> <label
									class="form-check-label" for="flexCheckChecked">
									Instruction unclear </label>
							</div>

						</div>
					</div>
					<div class="row pt-3 pb-3 ps-6 pe-6">
						<label class="form-label">Ad Note</label>
						<textarea class="form-control border-dashed"
							placeholder="Type here" id="floatingTextarea2"
							style="height: 100px"></textarea>
					</div>
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-2"></div>
						<div class="col-md-4 col-xs-6 pt-2 pb-2">
							<button type="button"
								class="btn btn-back-white btn-sm col-md-8 col-xs-10 closeqa">close</button>
						</div>
						<div class="col-md-4 col-xs-6 pt-2 pb-2">
							<button type="button"
								class="btn btn-secondary btn-sm col-md-8 col-xs-10 text-color-white">Send
								Question</button>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div>

			</div>
		</div>
	</div>



	<!--begin::Scrolltop-->
	<div id="kt_scrolltop" class="scrolltop" data-kt-scrolltop="true">
		<!--begin::Svg Icon | path: icons/duotune/arrows/arr066.svg-->
		<span class="svg-icon"> <svg xmlns="http://www.w3.org/2000/svg"
				width="24" height="24" viewBox="0 0 24 24" fill="none">
					<rect opacity="0.5" x="13" y="6" width="13" height="2" rx="1"
					transform="rotate(90 13 6)" fill="black" />
					<path
					d="M12.5657 8.56569L16.75 12.75C17.1642 13.1642 17.8358 13.1642 18.25 12.75C18.6642 12.3358 18.6642 11.6642 18.25 11.25L12.7071 5.70711C12.3166 5.31658 11.6834 5.31658 11.2929 5.70711L5.75 11.25C5.33579 11.6642 5.33579 12.3358 5.75 12.75C6.16421 13.1642 6.83579 13.1642 7.25 12.75L11.4343 8.56569C11.7467 8.25327 12.2533 8.25327 12.5657 8.56569Z"
					fill="black" />
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
	<script
		src="<%=assetsPath %>/plugins/custom/fullcalendar/fullcalendar.bundle.js"></script>
	<script
		src="<%=assetsPath %>/plugins/custom/datatables/datatables.bundle.js"></script>
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

$(document).ready(function(){
    $(".openqa").hide(); 
    $(".sendqa").click(function(){
       $(".openqa").show(); 
    });
    $(".closeqa").click(function(){
       $(".openqa").hide(); 
    });


    $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".questionstable").hide();
    $(".approvedtable").hide();
    $(".designchecktable").hide();
    $(".proofsenttable").hide();

   $(".all").click(function(){
       $(".alltable").show(); 
       $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".questionstable").hide();
    $(".approvedtable").hide(); 
    $(".proofsenttable").hide(); 
    $(".designchecktable").hide();    
    });
    $(".production").click(function(){
       $(".alltable").hide(); 
       $(".prooftable").hide();
    $(".questionstable").hide();
    $(".approvedtable").hide();
    $(".proofsenttable").hide(); 
    $(".designchecktable").hide();
       $(".productiontable").show();      
    });
    $(".proof").click(function(){
       $(".alltable").hide(); 
       $(".productiontable").hide();  
    $(".questionstable").hide();
    $(".approvedtable").hide();  
    $(".proofsenttable").hide(); 
    $(".designchecktable").hide();
       $(".prooftable").show();      
    });
    $(".questions").click(function(){
       $(".alltable").hide(); 
       $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".approvedtable").hide();  
    $(".proofsenttable").hide(); 
    $(".designchecktable").hide();
       $(".questionstable").show();      
    });
    $(".approved").click(function(){
       $(".alltable").hide(); 
       $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".questionstable").hide();
    $(".proofsenttable").hide(); 
    $(".designchecktable").hide();
       $(".approvedtable").show();      
    });
    $(".designcheck").click(function(){
       $(".alltable").hide(); 
       $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".questionstable").hide();
       $(".approvedtable").hide();
       $(".designchecktable").show();      
    });
    $(".proofsent").click(function(){
       $(".alltable").hide(); 
       $(".productiontable").hide();  
    $(".prooftable").hide();
    $(".questionstable").hide();
    $(".approvedtable").hide();
       $(".designchecktable").hide(); 
       $(".proofsenttable").show();      
    });
});



$(".kt_datatable_example_5").DataTable({
"language": {
"lengthMenu": "Show _MENU_",
},
"dom":
"<'row'" +
"<'col-sm-6 d-flex align-items-center justify-conten-start'l>" +
"<'col-sm-6 d-flex align-items-center justify-content-end'f>" +
">" +

"<'table-responsive'tr>" +

"<'row'" +
"<'col-sm-12 col-md-5 d-flex align-items-center justify-content-center justify-content-md-start'i>" +
"<'col-sm-12 col-md-7 d-flex align-items-center justify-content-center justify-content-md-end'p>" +
">"
});


$(document).on("click", ".start_design", function(event){
    console.log('start_design clicked');
    
    $('#start_design_order_details_id').html('');
    
    var orderId = $(this).data("order-id");
    console.log('orderId : '+orderId);
    
    var ajaxURL = '<%=contextPath %>/v1/ajax/getorderdetails/'+orderId+'/';
    console.log(ajaxURL);
    
    getAjaxDate(ajaxURL, 'start_design_order_details_id');
    
});




// pre defined date range
/*
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
*/

</script>
</body>
<!--end::Body-->
</html>