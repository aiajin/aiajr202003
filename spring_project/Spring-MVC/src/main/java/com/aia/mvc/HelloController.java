package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("msg", "안녕하세요");
		
		return "hello/hello";
		// /WEB-INF/views/hello/hello.jsp
	}
	
}






