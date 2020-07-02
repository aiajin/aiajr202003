<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500</title>
</head>
<body>
	<h1>처리과정에서 오류가 발생했습니다. 처음부터 다시 시작해주세요.<br>
		계속해서 오류가 발생하면 관리자에 문의하세요
	</h1>
	<a href="<%= request.getContextPath()%>/index.jsp">홈으로 가기</a>
</body>
</html>