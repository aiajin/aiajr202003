package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class MemberListServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		
		
		return "/WEB-INF/views/member/memberList.jsp";
	}

}









