package com.aia.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class MemberDao {

	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int selectById(Connection conn, String id) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs;	
		
		try {
			String sql = "select count(*) from project.member where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return resultCnt;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select count(*) from project.member");
			
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
		} finally {
			if(stmt!=null) {
				stmt.close();
			}
		} 
		
		return resultCnt;
	}

	public List<Member> selectList(Connection conn, int startRow, int count) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList = new ArrayList<Member>();
		
		String sql = "select * from project.member order by uname limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
				
				memberList.add(member);
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return memberList;
	}

	public int memberDelete(Connection conn, int idx) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from project.member where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			result = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}

	public Member selectByIdx(Connection conn, int idx) throws SQLException {

		Member member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs;	
		
		try {
			String sql = "select * from project.member where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return member;
	}

	public int editMember(Connection conn, Member member) throws SQLException {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "update project.member set "
				   + " upw=?, uname=?, uphoto=? "
				   + " where idx=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUpw());
			pstmt.setString(2, member.getUname());
			pstmt.setString(3, member.getUphoto());
			pstmt.setInt(4, member.getIdx());
			
			result = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}

	public Member selectByIdpw(Connection conn, String uid, String pw) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs;	
		Member member = null;
		
		try {
			String sql = "select * from project.member where uid=? and upw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return member;
	}

	public List<Member> selectTotalList(Connection conn) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList = new ArrayList<Member>();
		
		String sql = "select * from project.member order by uname";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
				
				memberList.add(member);
			}
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return memberList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
