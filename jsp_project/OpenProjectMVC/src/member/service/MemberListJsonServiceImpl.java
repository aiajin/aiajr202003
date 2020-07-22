package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import member.dao.MemberDao;
import member.model.Member;

public class MemberListJsonServiceImpl implements Service {

MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		// view 로 전달할 결과 데이터
		//MemberListView listView = null;
		List<Member> list = null;
		// JSON 문자열
		String listJson = null;// {"name":"son"}
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			list = dao.selectTotalList(conn);
			
			Gson gson = new Gson();
			
			// Java Object -> JSON
			listJson = gson.toJson(list);
			
			
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		}
		
		
		request.setAttribute("list", listJson);
		
		return "/WEB-INF/views/member/memberListJson.jsp";
	}

}









