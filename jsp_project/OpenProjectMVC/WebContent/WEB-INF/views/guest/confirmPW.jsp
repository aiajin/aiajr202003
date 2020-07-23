<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${chk}">
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

input[type=password] {
	width : 99%;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">${action eq 'edit' ? '수정을 위한' : '삭제를 위한'} 비밀번호를 입력해 주세요.</h1>
		<form action="${actionURI}" method="post">
			<input type="hidden" name="mid" value="${mid}">
			<table class="table">
				<tr>
					<td><input type="password" id="upw" name="upw" required></td>
				</tr>
				<tr>
					<td><input type="submit" value="입력"> <input type="reset"></td>
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
</c:if>
<c:if test="${not chk}">
<script>
	alert('잘못된 요청입니다.\n확인후 다시 요청해주세요.');
	window.history.go(-1);
</script>
</c:if>