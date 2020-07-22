package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;

public class MessageDao {

	private MessageDao() {
	}

	private static MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {
		return dao;
	}

	public int insertMessage(Connection conn, Message message) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		try {
			String sql = "insert into project.guestbook_message (guest_name, password, message) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getUname());
			pstmt.setString(2, message.getPw());
			pstmt.setString(3, message.getMessage());

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public List<Message> selectMessageList(Connection conn, int startRow, int endRow) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Message> list = new ArrayList();

		try {

			String sql = "select message_id, guest_name, password, message, regdate from project.guestbook_message  limit ?, ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Message message = new Message(rs.getInt("message_id"), rs.getString("guest_name"),
						rs.getString("password"), rs.getString("message"), rs.getDate("regdate"));
				list.add(message);
			}

		} finally {

			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
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
			String sql = "select count(*) from project.guestbook_message";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return resultCnt;
	}

	public Message selectMessage(Connection conn, int mid) throws SQLException {

		Message message = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from project.guestbook_message where message_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				message = new Message(rs.getInt("message_id"), rs.getString("guest_name"),
						rs.getString("password"), rs.getString("message"), rs.getDate("regdate"));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return message;
	}

	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "delete from project.guestbook_message where message_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

}
