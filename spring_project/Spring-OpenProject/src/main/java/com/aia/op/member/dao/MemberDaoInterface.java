package com.aia.op.member.dao;

import com.aia.op.member.model.Member;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw);
	public int insertMember(Member member);

}
