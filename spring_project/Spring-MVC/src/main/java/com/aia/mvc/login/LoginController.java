package com.aia.mvc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login") // http://localhost:8080/mvc/login/login
public class LoginController {
	
	// get 방식의 요청에 대한 처리 -> 로그인 폼 페이지
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "login/loginForm"; 
		// /WEB-INF/views/login/loginForm.jsp
	}
	
	// Post 방식의 요청 처리 메서드
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request ) {	
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println(uid);
		System.out.println(upw);
		
		
		return "login/login";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
