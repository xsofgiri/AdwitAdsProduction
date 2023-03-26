package com.production.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.production.entity.Designer;
import com.production.service.impl.DashboardServiceBean;
import com.production.util.Constants;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	DashboardServiceBean dashboardServiceBean;

	@RequestMapping("")
	public ModelAndView displayDashboard(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {
				model = new ModelAndView("/designer/csrDashboard");
			} else if (designer != null && designer.getDesignerId() > 0 && designer.isTeamLead()) {
				model = new ModelAndView("/designer/welcome");
			} else if (designer != null && designer.getDesignerId() > 0) {
				model = new ModelAndView("/designer/designerDashboard");
			} else {
				model = new ModelAndView("/designer/login");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/v1/ajax/newadscount", method = RequestMethod.GET)
	@ResponseBody
	public int getAjaxNewAdsCount(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int result = 0;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {
				String date = "2022-09-22";
				result = dashboardServiceBean.getNewWebAdsCount(designer.getDesignerId(), date);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	@RequestMapping(value = "/v1/ajax/onlineadscount", method = RequestMethod.GET)
	@ResponseBody
	public int getAjaxOnlineAdsCount(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int result = 0;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {
				String date = "2022-09-22";
				result = dashboardServiceBean.getNewWebAdsCount(designer.getDesignerId(), date);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	@RequestMapping(value = "/v1/ajax/revisionadscount", method = RequestMethod.GET)
	@ResponseBody
	public int getAjaxRevisionAdsCount(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int result = 0;
		try {

			Designer designer = session.getAttribute(Constants.DESIGNER_DTO) != null
					? (Designer) session.getAttribute(Constants.DESIGNER_DTO)
					: null;
			if (designer != null && designer.getDesignerId() > 0 && designer.isCSR()) {
				String date = "2022-09-22";
				result = dashboardServiceBean.getNewRevisionAdsCount(designer.getDesignerId(), date);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

}
