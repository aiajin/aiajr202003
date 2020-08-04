package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberRegRequest;
import com.aia.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	MemberRegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/memberRegForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getMemberReg(
			MemberRegRequest regRequest,
			/* Member member, */
			HttpServletRequest request,
			Model model
			) {
		
		System.out.println("controller : "+regRequest);
		/* System.out.println("member : "+member); */
		
		model.addAttribute("result", regService.memberReg(regRequest, request));
		
		return "member/memberReg";
	}
}
