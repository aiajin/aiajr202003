<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/include/session.jsp" %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	// [list.jsp로부터 전달받은 BoardListModel 객체를 이용해서 목록 화면을 생성]

	/* list.jsp로부터 전달받은 데이터(boardListModel, beginPage, endPage) 를 이용해서 목록 화면을 생성한다. */
	response.setHeader("Pargma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 목록</title>
</head>
<body>

	<table border="1" cellpadding="0" cellspacing="0">
		<c:if test="${listModel.totalPageCount > 0}">
			<tr>
				<td colspan="5">${listModel.startRow}-${listModel.endRow}
					[${listModel.requestPage}/${listModel.totalPageCount}]</td>
			</tr>
		</c:if>

		<tr align="center">
			<td>No</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		
		<!-- @@ [(swich-case-default)와 동일]: 다중조건 처리할 때 사용 -->
		<c:choose>
			<c:when test="${listModel.hasBoard == false}">
				<tr>
					<td colspan="5">게시글이 없습니다.</td>
				</tr>
			</c:when>
	
			<c:otherwise>
				<c:forEach var="board" items="${listModel.boardList}">
					<tr>
						<td>
							${board.idx}
						</td>
						<td>
							<!-- 답변 글이라면, 중첩 레벨에 따라 화살표 출력 -->
							<c:if test="${board.low > 0}">
								<c:forEach begin="1" end="${board.low}">-</c:forEach>&gt;
							</c:if> 
				
							<!-- 제목 및 읽기 페이지 링크 (jsp 에서 사용될 변수 설정) -->
							<c:set var="query"  value="board_idx=${board.idx}&p=${listModel.requestPage}" />
								<a href="<c:url value="read.jsp?${query}"/>"> ${board.title}</a>
						</td>
						<td>${board.write_name}</td>
						<td>${board.writeday}</td>
						<td>${board.readnum}</td>
					</tr>
				</c:forEach>
				
				<!-- 페이징 -->
				<tr>
					<td colspan="5" align="center">
						<c:if test="${beginPage > 10}">
							<a href="<c:url value="list.jsp?p=${beginPage-1}"/>">이전</a>
						</c:if> 
						<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
							<a href="<c:url value="list.jsp?p=${pno}" />">[${pno}]</a>
						</c:forEach> 
						<c:if test="${endPage < listModel.totalPageCount}">
							<a href="<c:url value="list.jsp?p=${endPage + 1}"/>">다음</a>
						</c:if>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>		
		
		
		<tr>
			<td colspan="5">
				<a href="writeForm.jsp"><input type="button" value="글쓰기"></a>
			</td>
		</tr>
	</table>
	
	<br>			
	<table>
	<tr>
		<td>
			<input type="button" value="메인으로" onclick="location.href='<%= request.getContextPath() %>/member/loginForm.jsp'">
		</td>
	</tr>
	</table>		
	
</body>
</html>