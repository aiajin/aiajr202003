package com.aia.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;

@Service("verifyService")
public class MemberVerifyService {
	
	@Autowired
	private MailSenderService mailService;

	@Autowired
	private SqlSessionTemplate template;
	
	private MemberDaoInterface dao;
	
	public String verify(String id, String code) {
		
		dao = template.getMapper(MemberDaoInterface.class);
		
		int rCnt = dao.verify(id, code);
		
		return rCnt>0?"Success":"Fail";
	}

	public int reMailSend(String email) {
				
		dao = template.getMapper(MemberDaoInterface.class);
		
		System.out.println("email : " + email);
		
		Member member = dao.selectMemberById(email);
		System.out.println("check : " + member);
		
		mailService.reSend(member.getUid(), member.getCode());
		
		
		return 1;
	}
	
	

}
