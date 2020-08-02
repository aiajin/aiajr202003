package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {

	@Autowired
	MemberDeleteService deleteService;
	
	@RequestMapping("/member/memberDelete")
	public String deleteMember(
			@RequestParam("idx") int idx,
			HttpServletRequest request,
			Model model 
			) {
		
		model.addAttribute("msg", deleteService.memberDelete(idx, request));
		
		return "member/memberDelete";
	}
	
}
