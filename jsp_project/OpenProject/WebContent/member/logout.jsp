<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 세션객체를 소멸시킨다.
	session.invalidate();
	
	// index 페이지로 이동
	response.sendRedirect(request.getContextPath());
%>