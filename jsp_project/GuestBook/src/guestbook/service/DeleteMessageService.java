package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;

public class DeleteMessageService {
	
	private DeleteMessageService() {}
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	MessageDao dao;
	
	public int deleteMessage(int mid, String pw) {
		int resultCnt = 0;
		
		Connection conn = null;
		Message message = null;
		
		// 1. mid 의 미시지 존재 하는지 확인
		// 2. 메시지가 존재 하면 객체의 pw 사용자가 입력한 pw 비교
		// 3. 비교의 결과가 같다면 mid의 미시지를 삭제
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			message = dao.selectMessage(conn, mid);
			
			if(message == null) {
				resultCnt = -1;
				throw new Exception("삭제 할 메시지가 존재하지 않음.");
			}
			
			if(!message.getPw().equals(pw)) {
				resultCnt = -2;
				throw new Exception("비밀번호가 일치하지 않음.");
			}
			
			// 삭제
			resultCnt = dao.deleteMessage(conn, mid);
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return resultCnt;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
