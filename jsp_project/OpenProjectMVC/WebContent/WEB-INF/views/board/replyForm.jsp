<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/include/session.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답변쓰기</title>
</head>
<body>

				<form action="replyForm_ok.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" size="20" value="re: " /></td>
	</tr>
	
	<tr>
		<td>작성자</td>
		<td><input type="text" name="write_name"  value="<%=session_name%>" readonly/></td>
	</tr>	
		
	<tr>
		<td>내용</td>
		<td><textarea name="content" cols="40" rows="5"></textarea></td>
	</tr>
		
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="저장" /> 
			<input type="button" value="취소"  onclick="location.href='list.jsp?p=${param.p}'"/>
		</td>
	</tr>
	</table>
				<input type="hidden" name="parentBoard_idx" value="${param.board_idx}" />
				<input type="hidden" name="p" value="${param.p}" />
				
				<input type="hidden" name="ref" value="${param.ref}" />									
				<input type="hidden" name="step" value="${param.step}" />
				<input type="hidden" name="low" value="${param.low}" />
				<input type="hidden" name="write_id" value="<%=session_id%>" >	
				</form>

</body>
</html>