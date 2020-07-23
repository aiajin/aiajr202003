package guestbook.servcie;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class GuestMessageConfirmPWServiceImpl implements Service {
	
	MessageDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		String mid = request.getParameter("mid");
		String action = request.getParameter("action");
		String actionUri = "";
		boolean chk = true;
		
		Connection conn;

		try {
			if (mid == null || action == null) {
				throw new Exception("데이터가 정상적으로 들어오지 않음.");
			}
			
			// /op/reg.do?&
			
			if(action.equals("edit")) {
				action = "editForm.do";
			} else if(action.equals("delete")) {
				action = "delete.do";
			} else {
				throw new Exception("데이터가 정상적으로 들어오지 않음.");
			}
			
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			
			
		} catch (NumberFormatException e) {
			chk = false;	
			e.printStackTrace();
		} catch (SQLException e) {
			chk = false;	
			e.printStackTrace();
		} catch (Exception e) {
			chk = false;	
			e.printStackTrace();
		}
		
		request.setAttribute("actionURI", action);
		request.setAttribute("chk", chk);
		request.setAttribute("mid", mid);

		return "/WEB-INF/views/guest/confirmPW.jsp";
	}

}
