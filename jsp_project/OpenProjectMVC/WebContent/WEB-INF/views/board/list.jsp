<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="board.model.BoardListModel" %>
<%@ page import="board.service.ListBoardService" %>

<%
	// [게시글 목록 조회 요청을 처리하는 컨트롤러 JSP. ListBoardService.getBoardList() 메서드에 읽어올 페이지 번호를 요청하고, 그 결과인 BoardListModel 객체를 list_view.jsp 에 전달] 

	/* p 파라미터로 읽어올 페이지 번호를 전달 받은뒤, ListArticleService 클래스의 getBoardList() 메서드에 전달한다.
		getBoardList() 메서드는 페이지 번호와 관련된 데이터를 보관한 BoardListModel 객체를 리턴하며, BoardListModel 객체를 list_view.jsp 로 전달!!
	*/
	// p 파라미터로부터 읽어올 페이지 번호를 구한다.
	String pageNumberString = request.getParameter("p");
	int pageNumber = 1;
	if (pageNumberString != null && pageNumberString.length() > 0) {
		pageNumber = Integer.parseInt(pageNumberString);
	}

	ListBoardService listSerivce = ListBoardService.getInstance();
	//ListSerivce.getBoardList()를 이용해서 사용자가 요청한 페이지에 해당하는 boardListModel 객체를 구한다.	
	BoardListModel boardListModel = listSerivce.getBoardList(pageNumber);
	request.setAttribute("listModel", boardListModel);
	
	if (boardListModel.getTotalPageCount() > 0) {
		//페이지 시작 번호와 끝 번호를 계산해서 구한다.
		int beginPageNumber = (boardListModel.getRequestPage() - 1) / 10 * 10 + 1;
		int endPageNumber = beginPageNumber + 9;
		if (endPageNumber > boardListModel.getTotalPageCount()) {
			endPageNumber = boardListModel.getTotalPageCount();
		}
		// 페이지 시작 번호와 끝 번호를 request 객체에 속성으로 저장한다.
		request.setAttribute("beginPage", beginPageNumber);
		request.setAttribute("endPage", endPageNumber);
	}
%>

<jsp:forward page="list_view.jsp" />
