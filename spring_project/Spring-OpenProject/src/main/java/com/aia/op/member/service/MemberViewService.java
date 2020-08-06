package com.aia.op.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;

@Service
public class MemberViewService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMemberInfo(int idx) {
		
		dao = template.getMapper(MemberDaoInterface.class);
		
		return dao.selectByIdx(idx);
		
	}

}








