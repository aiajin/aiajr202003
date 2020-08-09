<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 리스트</title>

<link rel="stylesheet" href="<c:url value="/css/default.css" />">

<style>
td>img {
	width: 50px;
	height: 50px;
}

h1.subtitle+div {
	overflow: hidden;
	text-align: right;
}

div.msg_box {
	width: 98%;
	padding: 20px;
	margin-top: 10px;
	font-size: 14px;
	border-top: 1px solid #DDD;
	border-bottom: 1px solid #DDD;
	overflow: hidden;
}

div.msg_box>div.id {
	float: left;
	width: 30px;
	text-align: center; 
	border-right: 1px solid #DDD;
	border-left: 1px solid #DDD;
}

div.msg_box>div.uname {
	float: left;
	width: 70px;
	text-align: center; 
	margin-left: -1px; 
	border-left : 1px solid #DDD;
	border-right: 1px solid #DDD;
}

div.msg_box>div.message {
	float: left;
	padding: 0 10px;
	margin-left: -1px;
	border-left: 1px solid #DDD;
}

div.msg_box>div.control {
	float: right;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">방명록 메시지</h1>
		<div>
			<input type="button" onclick="location.href='writeForm.do'"
				value="방명록작성">
		</div>
		<c:if test="${not empty listView.messageList}">
			<c:forEach items="${listView.messageList}" var="message">
				<div class="msg_box">
					<div class="id">${message.mid}</div>
					<div class="uname">${message.uname}</div>
					<div class="message">${message.message}</div>
					<div class="control">
						<a href="confirmpw?mid=${message.mid}&action=edit">수정</a>
						<a href="javascript:memberDel(${message.mid})">삭제</a>
					</div>
				</div>

			</c:forEach>

		</c:if>

		<c:if test="${listView.pageTotalCount > 0}">

		<div class="paging">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="i">
			
			<a class="paging_num ${i == listView.currentPageNumber ? 'now_page' : ''}" href="list?page=${i}" >${i}</a>
			
			</c:forEach>
		</div>

		</c:if>

	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>


<script>
	
	function memberDel(idx) {
		if (confirm('선택하신 회원 정보를 삭제하시겠습니까?')) {
			location.href = 'confirmpw?action=delete&mid=' + idx;
		}

	}
</script>
