package com.aia.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.guestbook.service.GuestBookConfirmPWService;

@Controller
public class GuestConfirmPWController {
	
	@Autowired
	GuestBookConfirmPWService confirmPWService;

	@RequestMapping("/guestbook/confirmpw")
	public String confirm(
			@RequestParam("mid") String mid,
			@RequestParam("action") String action,
			Model model
			) {
		
		String actionURI = null;
		boolean chk = true;
		
		
		try {

			actionURI = confirmPWService.getUrl(mid, action);
		
		} catch (Exception e) {
			chk = false;	
			e.printStackTrace();
		}
		
		model.addAttribute("actionURI", actionURI);
		model.addAttribute("chk", chk);
		model.addAttribute("mid", mid);
		
		return "guest/confirmPW";
	}
	
}
