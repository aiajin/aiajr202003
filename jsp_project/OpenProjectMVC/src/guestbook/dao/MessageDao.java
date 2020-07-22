package guestbook.dao;

import java.sql.Connection;

public class MessageDao {
	
	private MessageDao() {
	}

	private static MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {
		return dao;
	}

	public int selectTotalCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
