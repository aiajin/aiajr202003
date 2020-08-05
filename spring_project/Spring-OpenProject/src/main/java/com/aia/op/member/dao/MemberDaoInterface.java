package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.model.Member;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw);
	public int insertMember(Member member);
	
	// 전체 게시물의 개수 : 검색 포함
	public int totalCount(Map search);
	
	// 전체 게시물의  List<Member> 로 반환
	public List<Member> selectList(Map search);

}







