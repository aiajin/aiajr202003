<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TAG</title>
</head>
<body>
 
 	<select name="year">
 		<c:forEach var="year" begin="1950" end="2020" step="1">
 			<option value="${year}" ${param.year==year?'selected':''} >${year}</option>
 		</c:forEach>
 	</select>















</body>
</html>