<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="board.service.ReadBoardService"%>
<%@page import="board.service.BoardNotFoundException"%>
<%@page import="board.model.Board"%>

<%
	//[BoardService.readBoared() 메서드를 이용(지정한 idx에 해당하는 Board 객체를 구함)해서 게시글 데이터를 읽어온 뒤, read_view.jsp 로 내용을 보여줌]
	int board_idx = Integer.parseInt(request.getParameter("board_idx"));
	String viewPage = null;
	
	try {
		Board board = ReadBoardService.getInsteance().readBoard(board_idx);
		request.setAttribute("board", board);
		viewPage = "read_view.jsp";
		
	} catch (BoardNotFoundException ex) {
		viewPage = "board_not_found.jsp";
	}
%>

<jsp:forward page="<%=viewPage%>" />