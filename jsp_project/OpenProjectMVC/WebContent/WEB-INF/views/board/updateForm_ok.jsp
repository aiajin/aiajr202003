<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="board.service.UpdateBoardService"%>
<%@ page import="board.model.Board"%>

<%
	// 글 수정 요청을 UpdateBoardService 에 전달해서 글 수정 요청을 처리함
	// UpdateRequest 객체를 생성한 뒤, UpdateBoardService 클래스를 이용해서 수정 요청을 처리한다.
	request.setCharacterEncoding("euc-kr");
%>

<jsp:useBean id="updateRequest"	class="board.service.UpdateRequest" />
<jsp:setProperty name="updateRequest" property="*" />

<%
	String viewPage = null;

	try {
		Board board = UpdateBoardService.getInstance().update(updateRequest);
		request.setAttribute("updatedBoard", board);
		viewPage = "update_success.jsp";		
	
	} catch (Exception ex) {
		request.setAttribute("updateException", ex);
		viewPage = "update_error.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />