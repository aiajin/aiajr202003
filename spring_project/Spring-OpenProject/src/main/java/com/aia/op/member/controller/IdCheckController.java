package com.aia.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.op.member.service.IdCheckService;

@Controller
public class IdCheckController {
	
	@Autowired
	IdCheckService idCheckService;
	 
	@RequestMapping("/member/idCheck")
	@ResponseBody
	public String idCheck(
			@RequestParam("uid") String uid
			) {
		
		return idCheckService.checkId(uid);
	}

}
