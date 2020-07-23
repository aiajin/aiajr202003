<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ include file="/include/session.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<html>
<head>
<title>글 읽기</title>
</head>
<body>
	
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td>제목</td>
		<td>${board.title}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${board.write_name}</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td><fmt:formatDate value="${board.writeday}" pattern="yyyy-MM-dd" /></td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<!-- 
				[pre]: 입력한 내용의 공백이나 줄바꿈 문자를 화면에 그대로 출력해준다!! 
				[out]: string이나, a 와 같은 태그의 문자를 html 태그가 아닌 문자로 출력하기 위해 사용
			-->		
			<pre><c:out value="${board.content}" /></pre>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="padding: 5px;">
			<input type="button" value="목록으로"  onclick="location.href='list.jsp?p=${param.p}'"/>		
			<input type="button" value="답변쓰기"  onclick="location.href='replyForm.jsp?board_idx=${board.idx}&ref=${board.ref}&step=${board.step}&low=${board.low}&p=${param.p}'"/>
			<input type="button" value="수정"  onclick="location.href='update.jsp?board_idx=${board.idx}&p=${param.p}'"/>
			<input type="button" value="삭제"  onclick="location.href='delete_ok.jsp?idx=${board.idx}'"/>
		</td>
	</tr>	
	</table>
	
</body>
</html>