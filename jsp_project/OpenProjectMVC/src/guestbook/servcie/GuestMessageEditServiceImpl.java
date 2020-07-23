package guestbook.servcie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class GuestMessageEditServiceImpl implements Service {

	MessageDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		
		Connection conn = null;
		int result = 0;
		
		String name = request.getParameter("uname");
		String pw = request.getParameter("pw");
		String message = request.getParameter("message");
		int mid = Integer.parseInt(request.getParameter("mid"));
	
		
		try {

			if(name==null || pw==null || message==null) {
				throw new Exception("데이터 누락");
			}
			
			Message msgObj = new Message(mid, name, pw, message, null);

			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			result = dao.editMessage(conn, msgObj);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("result", result);
		
		
		
		return "/WEB-INF/views/guest/edit.jsp";
	}

}
