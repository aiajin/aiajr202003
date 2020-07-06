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
 
 	<c:out value="jstl tag out -> 데이터를 출력합니다."/>
 	<br>
 	<c:out value="${members[7].email}" default="<i>이메일 없음</i>" escapeXml="false"/>
 	<br>
 	<c:out value="${members[8].email}" escapeXml="false">
 		<span style="color:red">이메일 없음</span>
 	</c:out>
 	
 	<c:if test="${members[8].email == null}">
 		<span style="color:blue">이메일 없음</span>
 	</c:if>
 	
 	
 	
 	<c:forEach 
 				items="${applicationScope.members}" 
 				var="member" 
 				varStatus="status"
 	>
 	<h3>
 	
 	${status.index} ${status.count}
 	
 	이름 : ${member.name}, 이메일 : 
 	
 	<c:out value="${member.email}" escapeXml="false">
 		<span style="color:red">이메일 없음</span>
 	</c:out> 
 	
 	<c:if test="${member.email == null}">
 		<span style="color:blue">이메일 없음</span>
 	</c:if>
 	
 	<c:if test="${ empty member.email}">
 		<span style="color:green">이메일 없음</span>
 	</c:if>
 	
 	
 	
 	
 	</h3>
 	</c:forEach>
 	
 	 
 	
 	
 	<br>
 	
 	<c:forTokens items="손흥민, 010-7777-1111, 런던" delims="," var="token" >
 		${token}<br>
 	</c:forTokens>
 	
 	




















</body>
</html>