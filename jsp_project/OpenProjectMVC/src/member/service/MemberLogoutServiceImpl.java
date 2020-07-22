package member.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import app.util.CookieBox;
import member.dao.MemberDao;
import member.model.LoginInfo;
import member.model.Member;

public class MemberLogoutServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		// 현재 세션을 소멸시킵니다.
		request.getSession().invalidate();
		
		
		return "/WEB-INF/views/member/logout.jsp";
	}

}









