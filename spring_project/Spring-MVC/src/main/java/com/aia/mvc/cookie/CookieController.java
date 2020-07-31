package com.aia.mvc.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	@RequestMapping("/cookie/makeCookie")
	public String makeCookie(HttpServletResponse response) {
		
		Cookie cookie = new Cookie("uid", "cool");
		response.addCookie(cookie);
		
		return "cookie/makeCookie";
	}
	
	@RequestMapping("/cookie/viewCookie")
	public String viewCookie(
			Model model,
			@CookieValue(value = "uid", defaultValue = "no ID") String uid
			) {
		
		model.addAttribute("uid", uid);
		
		return "cookie/viewCookie";
	}

}





