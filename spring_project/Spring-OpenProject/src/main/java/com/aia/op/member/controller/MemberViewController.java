package com.aia.op.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.op.member.service.MemberViewService;

@Controller
public class MemberViewController {
	
	@Inject
	private MemberViewService viewService;
	
	
	// http://localhlost:8080/op/member/view/12
	@RequestMapping("/member/view/{idx}")
	public String getMemberInfo(
			@PathVariable("idx") int idx,
			Model model
			) {
		
		model.addAttribute("member", viewService.getMemberInfo(idx));
		
		return "member/memberView";
	}

}





