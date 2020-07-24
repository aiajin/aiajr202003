<%@ page contentType="text/html; charset=EUC-KR"%>

<%
	// 삭제 요청을 DeleteBoardService에 전달
	// 삭제 요청 정보를 담은 DeleteRequest 객체를 생성한 뒤, DeleteBoardService의 delete() 메서드를 실행해서 삭제 요청을 처리한다. 
	request.setCharacterEncoding("euc-kr");
%>

<%@page import="board.service.DeleteBoardService"%>

<jsp:useBean id="deleteRequest" class="board.service.DeleteRequest" />
<jsp:setProperty name="deleteRequest" property="*" />

<%
	String viewPage = null;

	try {
		DeleteBoardService.getInstance().deleteBoard(deleteRequest);
		viewPage = "delete_success.jsp";
	} catch (Exception ex) {
		request.setAttribute("deleteException", ex);
		viewPage = "delete_error.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />