package com.aia.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.jdbc.ConnectionProvider;
import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.model.LoginInfo;
import com.aia.op.member.model.LoginRequest;
import com.aia.op.member.model.Member;
import com.aia.op.util.CookieBox;

@Service
public class MemberLoginService {
	
	@Autowired
	MemberDao dao;

	public String login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {

		String loginResult = "";

		Connection conn = null;

		// 로그인 처리
		Member member = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			member = dao.selectByIdpw(conn, loginRequest.getUid(), loginRequest.getUpw());

			System.out.println("LoginService Member : " + member);

			if (member != null) {

				LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());

				session.setAttribute("loginInfo", loginInfo);

				// 쿠키 설정에 사용한 변수
				String cookieName = "uid";
				String cookiepath = session.getServletContext().getContextPath();

				// 회원 아이디 쿠키 설정
				if (loginRequest.getRemember() != null) {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 60 * 60 * 24 * 365));
				} else {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 0));
				}

				// 로그인 이 필요했던 이전 페이지
				loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + loginRequest.getRedirecUri() + "'" + "</script>";

			} else {
				loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loginResult;

	}

}
