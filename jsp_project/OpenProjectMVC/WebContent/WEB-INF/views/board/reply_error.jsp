<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="exceptionType" value="${replyException.getClass().simpleName}" />

<html>
<head>
<title>답변 실패</title>
</head>
<body>

	에러:
	<c:choose>
		<c:when test="${exceptionType == 'BoardNotFoundException'}">
			답변을 등록할 게시글이 존재하지 않습니다.
		</c:when>
	</c:choose>
	<br />
	<input type="button" value="목록보기"  onclick="location.href='list.jsp?p=${param.p}'"/>
	
</body>
</html>