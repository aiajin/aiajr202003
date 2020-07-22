<%@page import="app.service.ReportRegService"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	ReportRegService service = ReportRegService.getInstance();

	int result = service.regReport(request);
	
	request.setAttribute("result", result);


%>

	<jsp:forward page="upload_view.jsp"/>









