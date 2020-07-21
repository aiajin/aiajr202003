<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true" %>
<?xml version="1.0" encoding="UTF-8"?>
<members>
<c:forEach items="${list}" var="member">
	<member>
		<idx>${member.idx}</idx>
		<uid>${member.uid}</uid>
		<uname>${member.uname}</uname>
		<password>${member.upw}</password>
		<photo>${member.uphoto}</photo>
	</member>
</c:forEach>
</members>

