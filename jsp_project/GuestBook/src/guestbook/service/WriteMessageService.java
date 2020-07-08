package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class WriteMessageService {
	
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getIstance() {
		return service;
	}
		
	MessageDao dao = null;
	
	public int writeMessage(Message mesage) {
		int result = 0;
		dao = MessageDao.getInstance();
		// Dao의 메서드에 전달할 Connection
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.insertMessage(conn, mesage);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
