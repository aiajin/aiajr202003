package com.aia.op.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.op.member.service.LogoutService;

@Controller
public class LogoutController {
	
	@Autowired
	LogoutService logoutService;

	@RequestMapping("/login/logout")
	public String logout(
			HttpSession session
			) {
		
		
		//session.invalidate();
		logoutService.logout(session);
		
		//String viewName = "member/logout";
		String viewName = "redirect:/index";
		
		return viewName;
	}
	
}
