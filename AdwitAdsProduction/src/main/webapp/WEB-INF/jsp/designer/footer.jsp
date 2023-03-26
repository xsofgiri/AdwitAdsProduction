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