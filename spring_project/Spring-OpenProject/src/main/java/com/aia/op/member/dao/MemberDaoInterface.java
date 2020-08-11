package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberXML;
import com.aia.op.member.model.MemberXmlList;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw);
	
	// 회원 전체 리스트 반환
	public List<Member> selectTotalList();
	
	// 전체 XML 회원 리스트
	public List<MemberXML> selectTotalListXml();
	
	// idx 기반으로 검색한 회원의 정보 반환
	public Member selectByIdx(int idx);
	
	// 회원 가입
	public int insertMember(Member member);
	
	// 전체 게시물의 개수 : 검색 포함
	public int totalCount(Map search);
	
	// 전체 게시물의  List<Member> 로 반환
	public List<Member> selectList(Map search);

	// 회원 이메일 인증 처리
	public int verify(String id, String code);

	
	public Member selectMemberById(String email);
	
	
	
	
	
	
	
	
	

}







