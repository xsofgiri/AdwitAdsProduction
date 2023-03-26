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

%>

<form action="<%=contextPath %>/designer/startdesign" method="post" name="startDesign" id="startDesign" >
<input type="hidden" name="orderId" value="<%=order.getOrderId() %>" />
<input type="hidden" name="slug" value="<%=order.getCatResult()!=null?order.getCatResult().getSlug():"-" %>" />

<div class="row">
						<div class="col-md-12 col-sm-12 ps-6 fw-bolder ">
							<u> Order Information</u>
						</div>
						<div class="col-md-6 col-sm-6 ps-6 pt-6 pb-6">
							<p>Publication Name: <%=order!=null && Constants.isStringNotNull(order.getPublicationName())?order.getPublicationName():"-" %></p>
							<p>Advertiser Name: <%=order.getAdvertiserName()!=null?order.getAdvertiserName():"-" %></p>
							<p>
								Type of Ad: <span><%=Constants.getOrderType(order.getOrderTypeId()) %></span>
							</p>
						</div>
						<div class="col-md-6 col-sm-6 ps-6 pt-6 pb-6">
							<p>Category:  <%=order.getCatResult()!=null?order.getCatResult().getCategory():"-" %></p>
							<p>CSR Instructions:</p>
							<p>Delivery: <%=order.isRush()?"Rush":"Standard" %></p>
						</div>
						<div class="col-md-12 col-sm-12 ps-6 fw-bolder ">
							Slug : <%=order.getCatResult()!=null?order.getCatResult().getSlug():"-" %>
						</div>
					</div>
					
					<div class="border-top ">
					<div class="row pt-6 pb-6 align-items-center text-center">
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-success btn-sm col-md-3 col-xs-6">Download
								InDesign and Start</button>
						</div>

					</div>

				</div>
				</form>
					
					