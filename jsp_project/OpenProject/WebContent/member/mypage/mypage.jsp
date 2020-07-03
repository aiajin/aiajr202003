<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/sessionCheck.jsp" %>
<%
	if(loginInfo!=null){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>

</style>
</head>
<body>

	<%@ include file="/include/header.jsp" %>

	<div>
		<h1 class="subtitle">마이페이지</h1>
		
		<hr>
		
		<h3>로그인 회원 정보 </h3>
		
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><%= loginInfo.getUid() %></td>				
			</tr>
			<tr>
				<td>이름</td>
				<td><%= loginInfo.getUname() %></td>				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td></td>				
			</tr>
			<tr>
				<td>이메일</td>
				<td><%= loginInfo.getEmail() %></td>				
			</tr>
			<tr>
				<td>사진</td>
				<td><%= loginInfo.getPhoto() %></td>				
			</tr>
		</table>
		
	</div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>
<%} %>









