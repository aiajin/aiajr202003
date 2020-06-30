<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 테스트</title>
</head>
<body>
	<h1>안녕하세요. JSP로 응답 페이지를 생성했습니다.</h1>
	<%
		Date now = new Date();
		String message = "Hello~!!";
	%>
	<p>현재 시간은 : <%= now %></p>
	<h3><%= message %></h3>
</body>
</html>












