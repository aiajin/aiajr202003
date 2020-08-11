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
</style>
</head>
<body>


<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<!-- 해더 끝 -->

<!-- 컨텐츠 시작 -->
<div id="contents">
	
	<h1>이메일 미인증 회원 입니다.<br>이메일 인증 후 다시 로그인 해 주세요.</h1>
	<h3><a href="#" id="reMailSend">이메일 다시보내기 (${reEmail})</a></h3>
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<!-- 푸터 끝 -->



<script>
	
	$(document).ready(function(){
		$('#reMailSend').click(function(){
			
			$.ajax({
				url : 'verify/reMailSend',
				type : 'post',
				data : {email : '${reEmail}'},
				success : function(data){
					if(data == 'success'){
						alert('메일이 발송 되었습니다.');
					}
				}
				
				
			});
			
			return false;
		});
	});

</script>





</body>
</html>
















