<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Cookie[] cookies = request.getCookies();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 정보 수정</h1>
	<%
		/* Cookie cookie = new Cookie("uid", "hot");
		cookie.setPath("/web/"); */
	
	
		response.addCookie(CookieBox.createCookie("uid", "HOT", "/web/", -1));
		
	%>
	
	<a href="viewCookie.jsp">쿠키값 확인하기</a>

</body>
</html>