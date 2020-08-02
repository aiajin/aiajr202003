package com.aia.op.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LogoutService {

	public boolean logout(HttpSession session) {
		
		session.invalidate();
		
		// 로그아웃 시 추가 작업 코드를 작성합니다. 
		
		return true;
	}
	
}
