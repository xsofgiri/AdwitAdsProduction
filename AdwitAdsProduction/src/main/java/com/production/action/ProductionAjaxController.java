package com.production.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.production.entity.CatResult;
import com.production.entity.Designer;
import com.production.entity.Orders;
import com.production.service.impl.CSRServiceBean;
import com.production.service.impl.DBUtil;
import com.production.service.impl.OrderServiceBean;
import com.production.service.impl.UserServiceBean;
import com.production.util.Constants;

@Controller
@RequestMapping("/v1/ajax")
public class ProductionAjaxController {

	@Autowired
	UserServiceBean userService;

	@Autowired
	CSRServiceBean csrService;

	@Autowired
	OrderServiceBean orderService;
	
	@Autowired
	DBUtil dbUtil;

	@RequestMapping(value = "/getorderdetails/{order_id}/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAjaxOrderDetails(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("order_id") String orderId) {
		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0) {

				Orders orders = orderService.getOrderDetails(Integer.parseInt(orderId));
				CatResult catResult = orderService.getCatResultDetails(Integer.parseInt(orderId));
				
				if(catResult!=null) {
					catResult.setSlug(dbUtil.getSlugDetails(Integer.parseInt(orderId), designer.getDesignerId()));
					orders.setCatResult(catResult);
				}
				
				request.setAttribute(Constants.ORDER_DETAIL, orders);

				model = new ModelAndView("/designer/ajaxOrderDetails");

			}else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

}
