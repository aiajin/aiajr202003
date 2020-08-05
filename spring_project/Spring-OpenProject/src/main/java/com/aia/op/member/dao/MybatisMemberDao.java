package com.aia.op.member.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	

	private String mapperPath = "com.aia.op.mybatis.mapper.MemberMapper";
	
	public int insertMember(Member member) throws SQLException {
		return sessionTemplate.update(mapperPath+".insertMember", member);
	}

	

//	public int selectTotalCount(Connection conn) throws SQLException {
//		int resultCnt = 0;
//		
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			stmt = conn.createStatement();
//			
//			rs = stmt.executeQuery("select count(*) from project.member");
//			
//			if(rs.next()) {
//				resultCnt = rs.getInt(1);
//			}
//			
//		} finally {
//			if(stmt!=null) {
//				stmt.close();
//			}
//		} 
//		
//		return resultCnt;
//	}
//
//	public List<Member> selectList(Connection conn, int startRow, int count) throws SQLException {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		List<Member> memberList = new ArrayList<Member>();
//		
//		String sql = "select * from project.member order by uname limit ?, ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, count);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Member member = new Member();
//				member.setIdx(rs.getInt("idx"));
//				member.setUid(rs.getString("uid"));
//				member.setUpw(rs.getString("upw"));
//				member.setUname(rs.getString("uname"));
//				member.setUphoto(rs.getString("uphoto"));
//				
//				memberList.add(member);
//			}
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return memberList;
//	}

	
	
}
