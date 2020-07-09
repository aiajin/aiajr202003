package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import guestbook.model.Message;

public class MessageDao {
	
	private MessageDao() {}
	static private MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}

	public int insertMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql ="insert into guestbook_message values (message_id_seq.nextVal, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getUname());
			pstmt.setString(2, message.getPw());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		
		return resultCnt;
	}

	
	public List<Message> selectMessageList(Connection conn, int startRow, int endRow ) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		
		List<Message> list = null;
		
		try {
			
			String sql = "select message_id, guest_name, password, message " + 
					"from( " + 
					"    select rownum rnum, message_id, guest_name, password, message " + 
					"    from (" + 
					"            select * from guestbook_message order by guestbook_message.message_id desc " + 
					"        ) where rownum <= ? " + 
					" ) where rnum >= ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Message message  = new Message(
						rs.getInt("message_id"), 
						rs.getString("guest_name"), 
						rs.getString("password"), 
						rs.getString("message"));
				list.add(message);
			}
			
			
		} finally {
			
			if(rs != null){
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return list;
		
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		
		int resultCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.createStatement();
			String sql = "select count(*) from guestbook_message";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		
		
		
		return resultCnt;
	}
	
	
	
	
	
	
	
	
	
}
