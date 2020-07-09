package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.jdbc.ConnectionProvider;
import guestbook.model.Message;
import guestbook.model.MessageListView;

public class GetMessageListService {
	
	private GetMessageListService() {}
	private static GetMessageListService service = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return service;
	}
	
	private MessageDao dao;
	
	// 한 페이지에 표현할 메시지의 개수
	private final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageList(int pageNumber) {
		
		// 페이지 번호 -> 시작 행, 끝 행
		// dao -> List
		
		Connection conn=null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			dao = MessageDao.getInstance();
			
			// 페이지의 전체 메시지 구하기
			List<Message> messageList = null;
			
			// 전체 메시지의 게수
			int messageTotalCount = dao.selectTotalCount(conn);
			
			int startRow = 0;
			int endRow = 0;
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
