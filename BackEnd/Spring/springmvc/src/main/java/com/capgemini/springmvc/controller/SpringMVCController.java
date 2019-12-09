package com.capgemini.springmvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springmvc.beans.UserBean;

@Controller
public class SpringMVCController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyy-mm-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ModelAndView displayHelloUser() {
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("/WEB-INF/Views/helloUser.jsp");
		modelAndView.setViewName("helloUser");
		return modelAndView;
	}

	@RequestMapping(path = "/loginForm", method = RequestMethod.GET)
	public ModelAndView displayLogin() {
		ModelAndView modelAndView = new ModelAndView();
		/* modelAndView.setViewName("/WEB-INF/Views/loginForm.jsp"); */

		return modelAndView;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, ModelAndView modelAndView) {
		String empIdVal = req.getParameter("empId");
		String passwordVal = req.getParameter("password");

		req.setAttribute("empId", empIdVal);
		req.setAttribute("password", passwordVal);

		modelAndView.setViewName("/WEB-INF/Views/userDetails.jsp");

		return modelAndView;
	}

	@RequestMapping(path = "/login2", method = RequestMethod.POST)
	public String login2(@RequestParam("empId") int empId, @RequestParam("password") String password,
			ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("password", password);

		//return "/WEB-INF/Views/userDetails.jsp";
		return "userDetails";
	}

	@PostMapping("/login3")
	public String login3(int empId, String password, ModelMap modelMap) {
		modelMap.addAttribute("empId", empId);
		modelMap.addAttribute("password", password);

		return "userDetails";
	}

	@PostMapping("/login4")
	public String login4(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute("userBean", userBean);

		return "userDetails";
	}
}
