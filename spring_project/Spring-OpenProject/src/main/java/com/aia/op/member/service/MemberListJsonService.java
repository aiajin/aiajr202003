package com.aia.op.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.Member;

@Service
public class MemberListJsonService {

	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public List<Member> getMemberList(){
		
		dao = template.getMapper(MemberDaoInterface.class);
		
		return dao.selectTotalList();
	}
	
}









