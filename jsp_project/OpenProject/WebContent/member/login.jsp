<%@page import="model.LoginInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	// 사용자 요청 정보를 받는다.
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("remember"); 
	
	String rediectUri = request.getParameter("redirecUri");
	
	
	// 로그인 처리
	boolean loginChk = false;
	if(uid.equals(pw)){
		LoginInfo loginInfo = 
				new LoginInfo(uid, pw, "test@gmail.com", "default.jpg");
		
		session.setAttribute("loginInfo", loginInfo);
		
		loginChk = true;
	}
	
	System.out.println(loginChk);
	
	if(loginChk){

		// 쿠키 설정에 사용한 변수
		String cookieName = "uid";
		String cookiepath = request.getContextPath();
		
		// 회원 아이디 쿠키 설정 
		if(chk!=null){
			
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 60*60*24*365));
		
		} else {
			response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 0));
		}
		
		// 로그인 이 필요했던 이전 페이지
		response.sendRedirect(rediectUri) ;
			
	} else {
		%>
		<script>
		alert('아이디 또는 비밀번호를 확인후 다시 로그인해 주세요.') 
		history.go(-1);
		</script>
		<%
	}
	
	
%>
<%-- 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">

<style>
</style>
</head>
<body>

	<%@ include file="/include/header.jsp"%>

	<div>
		<h1>로그인</h1>
		
		<hr>

		<table>
			<tr>
				<td>ID</td>
				<td> <%= uid %></td>
			</tr>
			<tr>
				<td>PW</td>
				<td> <%= pw %> </td>
			</tr>
			<tr>
				<td></td>
				<td> 
					<%
						if(chk!=null){
							out.println("아이디를 저장합니다.");
						} else {
							out.println("아이디를 저장하지 않습니다.");
						}
					%>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><%= rediectUri %></td>
			</tr>
		</table>



	</div>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>

 --%>







