<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CookieBox cookieBox = new CookieBox(request);

	String cookieUid = cookieBox.getValue("uid");
	
	String uidValue = "";
	String checked = "";
	
	if(cookieUid!=null){
		uidValue = cookieUid;
		checked = "checked";
	}
	
	

 

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>

</style>
</head>
<body>

	<%@ include file="/include/header.jsp" %>

	<div>
		<h1 class="subtitle">로그인</h1>
		
		<hr>
		
		<form action="login.jsp" method="post">
		
			<input type="text" name="redirecUri" 
			
			value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >			
			
			
			<table class="table">
				<tr>
					<td> ID </td>
					<td> <input type="text" name="uid" value="<%= uidValue%>"> </td>
				</tr>
				<tr>
					<td> PW </td>
					<td> <input type="password" name="pw"> </td>
				</tr>				
				<tr>
					<td></td>
					<td> <input type="checkbox" name="remember" value="r" <%= checked %> > 아이디 기억하기  </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
		
		</form>
		
		
	</div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>









