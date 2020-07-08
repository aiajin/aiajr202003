<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table td {
		padding:10px;
	}
	
	input, textarea {
		padding : 5px;
	}
	
}
	
</style>
</head>
<body>

	<h3>방명록 글쓰기</h3>
	<hr>
	
	<form action="messageWrite.jsp" method="post">
		<table>
			<tr>
				<td><label for="uname">이름</label></td>
				<td><input type="text" id="uname" name="uname" required></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td>
				<td><input type="password" name="pw" id="pw" required></td>
			</tr>
			<tr>
				<td><label for="message">메시지</label> </td>
				<td><textarea name="message" id="message" rows="10" cols="20" required></textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="글쓰기"> 
					<input type="reset"> 
				</td>
			</tr>
		</table>
	</form>












</body>
</html>