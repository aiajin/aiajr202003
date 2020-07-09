<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pw = request.getParameter("pw");
	int mid = Integer.parseInt(request.getParameter("mid")) ; 
	
	// MessageDeleteService
	// -> dao.selectMessage(mid)
	// -> dao.deleteMessage()


%>

<jsp:forward page="deleteMessage_view.jsp"/>