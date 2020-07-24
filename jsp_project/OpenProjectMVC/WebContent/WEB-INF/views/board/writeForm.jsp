<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default.css">

<style>
.check_ok {
	color: blue;
}

.check_not {
	color: red;
}

#idchk {
	display: none;
}

input[type=text],textarea {
	width: 98%;
}  
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">게시판 글 작성</h1>
		<hr>
		<!-- 입력 폼의 name값은 WritingRequest 객체의 프로퍼티 이름과 동일 (jsp:setProperty 액션 태그를 이용해서 파라미터 값을 객체에 담기 위해)-->
		<form action="write.do" method="post">
			<input type="text" name="writer_id" value="로그인세션저장아이디">
			<input type="text" name="writer_idx" value="10">
			<table class="table">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" size="20" /></td>
				</tr>

				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer_name" value="로그인세션저장이름" readonly /></td>
				</tr>

				<tr>
					<td>내용</td>
					<td><textarea name="content" cols="40" rows="5"></textarea></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="저장" />
						<input type="button" value="취소" onclick="location.href='list.jsp'" />
					</td>
				</tr>
			</table>
		</form>



	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
<script>
	$(document).ready(function() {

		$('#regForm').submit(function() {

		});

	});
</script>









