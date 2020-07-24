package guestbook.servcie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class GuestMessageEditFormServiceImpl implements Service {

	MessageDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		Message message = null;

		// 수정하고자 하는 메시지의 message_id
		int mid = Integer.parseInt(request.getParameter("mid"));
		System.out.println("mid :     " + mid);
		String pw = request.getParameter("upw");

		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();

			message = dao.selectMessage(conn, mid);
			
			System.out.println(message);
			
			if(!message.getPw().equals(pw)) {
				message = null;
				throw new Exception("비밀번호 불일치");
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
 
		request.setAttribute("message", message);

		return "/WEB-INF/views/guest/editForm.jsp";
	}

}
