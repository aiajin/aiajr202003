<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="exceptionType" value="${deleteException.getClass().simpleName}" />

<html>
<head>
<title>삭제 실패</title>
</head>
<body>

	에러:
	<c:choose>
		<c:when test="${exceptionType == 'BoardNotFoundException'}">
			삭제할 게시글이 존재하지 않습니다.
		</c:when>
		<c:when test="${exceptionType == 'InvalidPasswordException'}">
			암호를 잘못 입력하셨습니다.
		</c:when>
	</c:choose>
	<br />
	<input type="button" value="목록보기"  onclick="location.href='list.jsp?p=${param.p}'"/>
	
</body>
</html>