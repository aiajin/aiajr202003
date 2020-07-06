<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "손흥민");
	request.setAttribute("age", 10);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL </title>
</head>
<body>

	<h1>${10+31}, ${10 div 3} , ${10 mod 3}</h1>
	<h1>${10 == 1}, ${10 eq 1}, ${10 ne 1}, ${ 10 lt 1 }, ${10 gt 1 }</h1>

	<h1> ${ 10 ne 1 ? '같지않다' : '같다' }</h1>
	
	<h1> ${ name eq '손흥민' ? 'Top Class' : 'Other Player' } </h1>
	
	<h1> ${ age > 19 ?  '입장 가능' : '입장 불가'}</h1>

	<h1>요청 URI <%= request.getRequestURI() %></h1>
	<h1>요청 URI ${pageContext.request.requestURI}</h1>
	<h1>request 속성에 저장된 name : <%= request.getAttribute("name") %></h1>
	<h1>request 속성에 저장된 name : ${requestScope.name}</h1>
	<h1>request 속성에 저장된 name : ${name}</h1>
	<h1>파라미터 code 의 값 : <%= request.getParameter("code") %></h1>
	<h1>파라미터 code 의 값 : ${param.code}</h1>
	<h1>JSESSIONID 쿠키 값 : ${cookie.JSESSIONID.value}</h1>
	


</body>
</html>










