<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pw = request.getParameter("pw");
	int mid = Integer.parseInt(request.getParameter("mid")) ; 
	
	// MessageDeleteService
	// -> dao.selectMessage(mid)
	// -> dao.deleteMessage()
	
	DeleteMessageService service = DeleteMessageService.getInstance();
	int resultCnt = service.deleteMessage(mid, pw);
	
	request.setAttribute("resultCode", resultCnt);

%>

<jsp:forward page="deleteMessage_view.jsp"/>











