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
	<h1>잘못된 요청 입니다. 경로를 다시 확인하시고 요청해주세요.</h1>
	<a href="<%= request.getContextPath()%>/index.jsp">홈으로 가기</a>
</body>
</html>