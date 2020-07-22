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

public class MemberLoginServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		// 사용자 요청 정보를 받는다.
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		String chk = request.getParameter("remember"); 
		
		String rediectUri = request.getParameter("redirecUri");
		
		Connection conn = null;
		
		// 로그인 처리
		Member member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			member = dao.selectByIdpw(conn, uid, pw);
			
			System.out.println(member);
			
			if(member != null){
				
				LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());
				
				request.getSession().setAttribute("loginInfo", loginInfo);

				// 쿠키 설정에 사용한 변수
				String cookieName = "uid";
				String cookiepath = request.getContextPath();
				
				// 회원 아이디 쿠키 설정 
				if(chk!=null){
					response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 60*60*24*365));
				} else {
					response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 0));
				}
				
				// 로그인 이 필요했던 이전 페이지
				String result = "<script>"
						+ "alert('로그인되었습니다.');"
						+ "location.href='"+rediectUri+"'"
						+ "</script>";
				request.setAttribute("result", result);
					
			} else {
				String result = "<script>"
						+ "alert('아이디 또는 비밀번호가 틀립니다.');"
						+ "history.go(-1);"
						+ "</script>";
				request.setAttribute("result", result);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "/WEB-INF/views/member/login.jsp";
	}

}









