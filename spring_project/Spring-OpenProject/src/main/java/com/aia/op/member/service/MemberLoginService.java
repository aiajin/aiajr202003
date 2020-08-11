package com.aia.op.member.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.member.dao.MemberDaoInterface;
import com.aia.op.member.model.LoginInfo;
import com.aia.op.member.model.LoginRequest;
import com.aia.op.member.model.Member;
import com.aia.op.util.CookieBox;

@Service
public class MemberLoginService {
	
//	@Autowired
//	MemberDao dao;
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate ;
	

	public String login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {
		
		
		// inteface의 Mapper 객체 생성
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		
		String loginResult = "";

		// 로그인 처리
		Member member = null;

		member = dao.selectByIdpw(loginRequest.getUid(), loginRequest.getUpw());

		System.out.println("LoginService Member : " + member);

		if (member != null && member.getVerify() == 'Y') {

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
			

		} else if(member != null && member.getVerify() == 'N') {

			loginResult = "<script>"; 
			loginResult += "	if(confirm('회원 가입 후 메일인증이 안되었습니다.\n인증메일을 다시 보내시겠습니까?')) {";
			loginResult += "		$.ajax(\'../member/verify/reMailSend?email="+member.getUid()+"\',{})";
			loginResult += "	}";
			loginResult += "	location.href=\'" + loginRequest.getRedirecUri() + "\';"; 
			loginResult += "</script>";
			
		} else {
			loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
		}

		return loginResult;

	}

}
