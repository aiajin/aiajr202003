package guestbook.servcie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class GuestMessageRegServiceImpl implements Service {
	
	MessageDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int result = 0;
		// Dao의 메서드에 전달할 Connection
		Connection conn = null;
		
		String uname = request.getParameter("uname");
		String pw = request.getParameter("pw");
		String message = request.getParameter("message");
		
		Message gestmessage = new Message(0, uname, pw, message, null);
		
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			result = dao.insertMessage(conn, gestmessage);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("result", result);
		
		return "/WEB-INF/views/guest/write.jsp";
	}

}
