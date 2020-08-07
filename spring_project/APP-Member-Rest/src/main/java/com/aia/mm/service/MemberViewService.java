package com.aia.mm.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;

@Service
public class MemberViewService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMember(int idx) {
		
		dao = template.getMapper(MemberDao.class);
		
		return dao.selectByIdx(idx);
	}
	
	
	
	
	
	

}
