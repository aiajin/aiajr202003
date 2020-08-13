package com.aia.socket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChattingController {

	@RequestMapping("/chatting")
	public ModelAndView chat(
			ModelAndView mv,
			@RequestParam("uid") String uid,
			HttpSession session
			) {
		
		mv.setViewName("chat/chat");
		mv.addObject("user", uid);
		mv.addObject("articleId", "12345");
		mv.addObject("articleOwner", "jin");
		
		session.setAttribute("user", uid);
		
		return mv;
	}
	
}
