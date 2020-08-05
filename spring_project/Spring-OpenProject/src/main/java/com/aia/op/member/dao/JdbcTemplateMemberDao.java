package com.aia.op.member.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class JdbcTemplateMemberDao {
	
	@Inject
	JdbcTemplate jdbcTemplate ;

	public int selectTotalCount() throws SQLException {
		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
	}

	public List<Member> selectList(int startRow, int count) throws SQLException {
		
		
//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname limit ?, ?";
//		memberList = jdbcTemplate.query(sql,new Object[] {startRow, count}, new MemberRowMapper());
//		return memberList;
		
		return jdbcTemplate.query(
				"select * from project.member order by uname limit ?, ?",
				new Object[] {startRow, count}, 
				new MemberRowMapper());
		
	}

	

	
	
	
}