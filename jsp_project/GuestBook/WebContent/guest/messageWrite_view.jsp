<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${writeResult > 0}">
	<h1>글이 정상적으로 작성되었습니다.</h1>
	</c:if>
	<c:if test="${writeResult == 0}">
	<h1>글쓰기 실패!!!</h1>
	</c:if>
	
	<a href="list.jsp">목록 보기</a>
</body>
</html>




