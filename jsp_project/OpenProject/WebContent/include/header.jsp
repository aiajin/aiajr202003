<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Boolean loginCheck = session.getAttribute("loginInfo")==null?false:true; 
%>
	<h1 id="header">Open Project</h1>
	<ul id="nav">
		<li><a href="<%= request.getContextPath() %>/member/memberRegForm.jsp">회원가입</a></li>
	<%
		// 로그인 상태에 따라 메뉴가 다르게 노출
		if(loginCheck){
	%>
		<li><a href="${pageContext.request.contextPath}/member/logout.jsp">로그아웃</a></li>
	<%} else { %>
		<li><a href="<%= request.getContextPath() %>/member/loginForm.jsp">로그인</a></li>
	<%} %>
		<li><a href="<%= request.getContextPath() %>/member/mypage/mypage.jsp">마이페이지</a></li>
		<li><a href="<%= request.getContextPath() %>/guestbook/list.jsp">방명록(비회원)</a></li>
		<li><a href="<%= request.getContextPath() %>/board/list.jsp">방명록(회원제)</a></li>
	</ul>