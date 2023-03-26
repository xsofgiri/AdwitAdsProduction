package com.production.action;

import java.util.ArrayList;

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
import com.production.util.EncryptionUtil;

@Controller
@RequestMapping("/adrep-survey")
public class SurveyAction {

	@Autowired
	UserServiceBean userService;


	@RequestMapping(value = "/{survey_name}/{adrep_id}/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getAjaxOrderDetails(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("survey_name") String surveyName, @PathVariable("adrep_id") String adrepId) {
		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			System.out.println("surveyName : " + surveyName);
			System.out.println("adrepId : " + adrepId);

			request.setAttribute("ADREP_ID", adrepId);
			adrepId = EncryptionUtil.decode(adrepId);

			boolean hasTaken = userService.hasAdrepTakenSurvey(1, Integer.parseInt(adrepId));
			if (hasTaken) {
				String responseMessage = "Our records show that you've already completed this survey. Unfortunately at this time, submitting multiple responses for the same survey is not possible. You can reach out to the design team or <a href='mailto:contactus@adwitglobal.com'>email us here</a>. Thank you for your valuable feedback. ";

				request.setAttribute(Constants.USER_SUCCESS_MESSAGE, responseMessage);
				model = new ModelAndView("/designer/adrepSurveyResponse");
			} else {
				model = new ModelAndView("/designer/adrepSurvey");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

	@RequestMapping(value = "/{survey_name}/", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getAjaxOrderDetails(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("survey_name") String surveyName) {
		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {
			System.out.println("surveyName : " + surveyName);

			String surveyQ1 = request.getParameter("survey_1");
			String surveyQ2 = request.getParameter("survey_2");
			String surveyQ3 = request.getParameter("survey_3");
			String surveyQ4 = request.getParameter("survey_4");
			String surveyQ5 = request.getParameter("survey_5");
			String adrepId = request.getParameter("adrepId");

			adrepId = EncryptionUtil.decode(adrepId);

			System.out.println("adrepId : " + adrepId);

			ArrayList<String> quizResponse = new ArrayList();
			quizResponse.add(surveyQ1);
			quizResponse.add(surveyQ2);
			quizResponse.add(surveyQ3);
			quizResponse.add(surveyQ4);
			quizResponse.add(surveyQ5);
			quizResponse.add(adrepId);

			String ipAddress = request.getHeader("X-FORWARDED-FOR");

			if (ipAddress == null || "".equals(ipAddress)) {
				ipAddress = request.getRemoteAddr();
			}

			userService.addSurveyResponse(quizResponse, 1, Integer.parseInt(adrepId), ipAddress);

			model = new ModelAndView("/designer/adrepSurveyResponse");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}

}
