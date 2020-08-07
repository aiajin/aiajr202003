package com.aia.mm.dao;

import java.util.List;

import com.aia.mm.model.Member;

public interface MemberDao {

	List<Member> selectList();

	int insertMember(Member member);

	Member selectByIdx(int idx);

	int editMember(Member member);

	int deleteMember(int idx);

}
