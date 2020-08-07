package com.aia.mm.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegRequest;

@Service
public class MemberRegService {
	
	private MemberDao dao;
	
	@Autowired
	SqlSessionTemplate template;

	
	public int regMember(MemberRegRequest regRequest) {
		
		Member member = regRequest.toMember();
		
		dao = template.getMapper(MemberDao.class);
		
		int result = dao.insertMember(member);
		
		return result;		
	}
	
}















