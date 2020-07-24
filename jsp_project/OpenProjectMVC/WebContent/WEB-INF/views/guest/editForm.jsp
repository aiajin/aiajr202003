<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${message eq null}">
<script>
	alert('비밀번호가 일치 하지 않습니다.');
	location.href='list.do';
</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 리스트</title>

<link rel="stylesheet" href="<c:url value="/css/default.css" />">

<style>
td>img {
	width: 50px;
	height: 50px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">방명록 메시지 수정</h1>
		<form action="edit.do" method="post">
			<input type="text" id="mid" name="mid" value="${message.mid}" required>
			<table>
				<tr>
					<td><label for="uname">이름</label></td>
					<td><input type="text" id="uname" name="uname" value="${message.message}" required></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호</label></td>
					<td><input type="password" name="pw" id="pw"  value="" required></td>
				</tr>
				<tr>
					<td><label for="message">메시지</label></td>
					<td><textarea name="message" id="message" rows="10" cols="20"
							required>${message.message}</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="글쓰기"> <input
						type="reset"></td>
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
