package com.production.action;

import com.production.entity.ApiResponseCode;
import com.production.entity.User;
import com.production.enums.ApiResponseEnum;
import com.production.service.impl.UserServiceBean;
import com.production.util.ApiResponseUtil;
import com.production.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserServiceBean userService;
	
	@RequestMapping("")
	public ModelAndView displayHomePage(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			User user = userService.getAdRepDetails(13);
			System.out.println(user.getAdrepId());
			
			model = new ModelAndView("/designer/login");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/login");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	@RequestMapping(value = "/workstation", method = RequestMethod.GET)
	public ModelAndView displayWorkstation(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/workstation");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	@RequestMapping(value = "/acceptorder", method = RequestMethod.GET)
	public ModelAndView displayAcceptOrder(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/acceptOrder");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	@RequestMapping(value = "/checkdesign", method = RequestMethod.GET)
	public ModelAndView displayCheckDesign(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/checkDesign");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
	@RequestMapping(value = "/startdesign", method = RequestMethod.GET)
	public ModelAndView displayStartDesign(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/designAd");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	@RequestMapping(value = "/newrevisionad", method = RequestMethod.GET)
	public ModelAndView displayNewRevisionAd(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView model = null;
		try {

			model = new ModelAndView("/designer/newRevisionAd");

		} catch (Exception e) {
			System.out.println(e);
		}

		return model;
	}
	
	
}
