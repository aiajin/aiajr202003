package com.aia.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.guestbook.service.GuestBookListService;

@Controller
public class GuestListController {
	
	@Autowired
	private GuestBookListService listService;

	@RequestMapping("/guestbook/list")
	public String list(
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model
			) {
		
		model.addAttribute("listView", listService.getList(pageNumber));
		
		return "guest/list";
	}
	
}
