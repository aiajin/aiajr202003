<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="board.service.BoardWriteService" %>
<%@ page import="board.model.Board" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	// [사용자의 요청으로 부터, WritingRequest 객체를 생성한 뒤, WriteBoardService에 WritingRequest 객체를 전달해서 게시글 쓰기를 실행]
	request.setCharacterEncoding("euc-kr");
%>

<!-- 글쓰기 요청 정보를 담은 WritingRequest 객체 생성 -->
<jsp:useBean id="writingRequest" class="board.service.WritingRequest" />
<jsp:setProperty name="writingRequest" property="*" />

<%
	// WriteBoardService.write()에 WritngRequest 객체 전달
	Board writeBoard = BoardWriteService.getInstance().write(writingRequest);
	request.setAttribute("writeBoard", writeBoard);
%>

<script>
	parent.location.href="list.jsp";
</script>

