<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Spring MVC@  
	</h1>

	<ul> 
		<li><a href="<c:url value='/hello'/>">/hello</a></li>
		<li><a href="bye">/bye</a></li>
		
		<!-- /mvc/login/login -->
		<li><a href="<c:url value='/login/login'/>">/login/login(GET)</a></li>
		
		<li><a href="<c:url value="/search" />">/search</a></li>
		<li><a href="<c:url value="/search/searchForm" />">/searchForm</a></li>
		
		
		
		<li><a href="<c:url value="/order/order" />">/order/order</a></li>
		
		<li><a href="<c:url value="/cookie/makeCookie" />">/cookie/makeCookie</a></li>
		<li><a href="<c:url value="/cookie/viewCookie" />">/cookie/viewCookie</a></li>
		
		<li><a href="<c:url value="/header/getHeader" />">/header/getHeader</a></li>
		
		<li><a href="<c:url value="/report/reportForm" />">/report/reportForm</a></li>
	</ul>	 














</body>
</html>
