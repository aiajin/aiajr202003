<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>로그인 페이지 입니다.</h1>
	<hr>
	<ul>
		<li>id : <%= request.getParameter("id")%></li>
		<li>pw : <%= request.getParameter("pw")%></li>
	</ul>
</body>
</html>