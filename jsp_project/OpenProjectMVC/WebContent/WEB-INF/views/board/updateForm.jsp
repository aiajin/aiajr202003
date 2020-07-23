<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/include/session.jsp" %>    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>수정하기</title>
</head>
<body>

				<form action="updateForm_ok.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0">				
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" size="20" value="${board.title}" /></td>
	</tr>
	
	<tr>
		<td>내용</td>
		<td><textarea name="content" cols="40" rows="5">${board.content}</textarea></td>
	</tr>
		
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정" /> 
			<input type="button" value="취소"  onclick="location.href='list.jsp?p=${param.p}'"/>
		</td>
	</tr>
	</table>
			<input type="hidden" name="idx" value="${board.idx}" />
			<input type="hidden" name="p" value="${param.p}" />
			</form>

</body>