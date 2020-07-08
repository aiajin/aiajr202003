<%@page import="service.EmpListService"%>
<%@page import="dao.EmpDao"%>
<%@page import="guestbook.jdbc.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP LIST</title>
<style>
table {
	width: 80%;
}

table td {
	padding: 10px;
	text-align: center;
}
</style>
</head>
<body>

	<%
	
	List<Emp> empList = EmpListService.getInstance().getEmpList();
	request.setAttribute("empList", empList);
	%>

	<jsp:forward page="empList_view.jsp" />













</body>
</html>