<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그인 처리 
	// 아이디의 값과 비밀번호의 값을 문자열 비교해서 같으면 로그인 처리 (session 속성에 저장)
	// 1. 아이디, 비밀번호 데이터를 받는다
	// 2. 로그인을 위한 비교 : 아이디 비밀번호 문자열 비교
	// 3. 로그인 처리 : 세션에 사용자 정보를 저장
	// 4. 응답 처리 : html 로그인처리 일 때, 로그인이 되지 않았을 때
	
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	
	boolean loginChk = false;
	
	if(uid.equals(pw)){
		// 로그인 처리 : 세션의 속성에 데이터 저장
		session.setAttribute("memberId", uid);
		loginChk = true;
	}
	
%>

<%
	if(loginChk) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 되었습니다.</h1>
	<h2>id : <%= uid %>, pw : <%= pw %> </h2>
	<a href="mypage.jsp">My Page</a> <a href="logout.jsp">logout</a>
</body>
</html>
<%
	}
%>