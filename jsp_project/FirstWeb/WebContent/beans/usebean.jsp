<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="memberInfo" class="model.LoginInfo" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		memberInfo.setUid("hot");
		memberInfo.setName("뜨거워");
		
	%>

	<h1><%= memberInfo %></h1>
</body>
</html>