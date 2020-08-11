package com.aia.op.member.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.op.member.model.MemberRegRequest;
import com.aia.op.member.service.MemberRegService;
import com.aia.op.util.AES256Util;
import com.aia.op.util.Sha256;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	MemberRegService regService;
	
//	@Autowired
//	private Sha256 sha256;
	
//	@Autowired
//	private AES256Util aes256Util;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;


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
			) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		System.out.println("controller : "+regRequest);
		
		
//		System.out.println("SHA 암호화");
//		System.out.println(sha256.encrypt(regRequest.getUpw()));
//		System.out.println(sha256.encrypt(regRequest.getUpw()).length() );
//		
//		System.out.println("----------------------------------------------");
//		System.out.println("AES 암호화");
//		System.out.println(aes256Util.encrypt(regRequest.getUpw()));
//		System.out.println(aes256Util.encrypt(regRequest.getUpw()).length());
//		
//		System.out.println("----------------------------------------------");
//		System.out.println("Spring Security 암호화");
//		System.out.println(passwordEncoder.encode(regRequest.getUpw()));
//		System.out.println(passwordEncoder.encode(regRequest.getUpw()).length());
		
		
		
		/* System.out.println("member : "+member); */
		
		model.addAttribute("result", regService.memberReg(regRequest, request));
		
		return "member/memberReg";
	}
}






