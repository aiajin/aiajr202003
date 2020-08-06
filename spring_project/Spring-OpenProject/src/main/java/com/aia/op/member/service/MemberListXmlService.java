package com.aia.op.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.MemberXML;
import com.aia.op.member.model.MemberXmlList;

@Service
public class MemberListXmlService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public MemberXmlList getXmlList() {
	
		dao = template.getMapper(MemberDaoInterface.class);
		
		List<MemberXML> memberList = dao.selectTotalListXml();
		
		MemberXmlList list = new MemberXmlList(memberList);
		
		return list;
		//return new MemberXmlList(dao.selectTotalListXml());
	}

}





