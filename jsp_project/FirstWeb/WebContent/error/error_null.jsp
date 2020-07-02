<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
</head>
<body>
	<h1>NullPointerException 발생</h1>
	<a href="<%= request.getContextPath()%>/index.jsp">홈으로 가기</a>
</body>
</html>