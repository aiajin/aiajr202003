<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css">
<style>
	div.mypage_box {
		width : 450px;
	}
	img {
		display: block;
		width: 100px;
	}
	h1, h3 {
		text-align: center;
	}
</style>
</head>
<body>


<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!-- 해더 끝 -->


<!-- 컨텐츠 시작 -->
<div id="contents">
	
	<h1>인증되었습니다. <br>로그인 후 정상적인 서비스 실행이 가능합니다.<br> 감사합니다.</h1>
	<h3><a href="../login/login">로그인 하기</a></h3>
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<!-- 푸터 끝 -->





</body>
</html>
















