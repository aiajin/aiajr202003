<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> members = new ArrayList();
	members.add(new Member("손흥민1", "son1@gmail.com"));
	members.add(new Member("손흥민2", "son2@gmail.com"));
	members.add(new Member("손흥민3", null));
	members.add(new Member("손흥민4", "son4@gmail.com"));
	members.add(new Member("손흥민5", "son5@gmail.com"));
	members.add(new Member("손흥민6", "son6@gmail.com"));
	members.add(new Member("손흥민7", "son7@gmail.com"));
	members.add(new Member("손흥민8", null));
	members.add(new Member("손흥민9", null));
	members.add(new Member("손흥민10", "son10@gmail.com"));
	
	application.setAttribute("members", members);
%>
데이터 생성!!!



