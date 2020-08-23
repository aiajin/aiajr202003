<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.text_right {
		text-align: right;
	}
	
	.text_left {
		text-align: left;
	}
	.chattingBox {
		padding : 15px;
		border : 1px solid #AAA;
		margin: 10px 0;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<!-- Zebra-Dialog CDN -->
<!-- <script src="resources/js/dialog/zebra_dialog.src.js"></script>
<link rel="stylesheet" href="resources/css/dialog/zebra_dialog.css" type="text/css" /> -->

</head>
<body>

	<h1>Chatting Page (id: ${user})</h1>
	<br>
	<div>
		<div>
			<input type="text" id="message" /> <input type="button" id="sendBtn"
				value="전송" />
		</div>
		<br>
		<div class="well" id="chatdata">
			<!-- User Session Info Hidden -->
			<input type="hidden" value='${user}' id="sessionuserid">
		</div>
	</div>
</body>

<script>
	//websocket을 지정한 URL로 연결
	var sock = new SockJS("<c:url value="/echo"/>");
	//websocket 서버에서 메시지를 보내면 자동으로 실행된다.
	sock.onmessage = onMessage;
	//websocket 과 연결을 끊고 싶을때 실행하는 메소드
	sock.onclose = onClose;
	
	
	$(function() {
		$("#sendBtn").click(function() {
			console.log('send message...');
			sendMessage();
		});
	});

	function sendMessage() {
		//websocket으로 메시지를 보내겠다.
		
		var msg = {
			user : '${user}',
			to : 'jin', // 현재 페이지 작성자의 id를 작성
			articleId : '${articleId}',
			articleOwner : '${articleOwner}',
			message : $("#message").val()
		};
		
		sock.send(JSON.stringify(msg));
	}

	//evt 파라미터는 websocket이 보내준 데이터다.
	function onMessage(evt) { //변수 안에 function자체를 넣음.
		var data = evt.data; // 전달 받은 데이터
		
		//alert(data);
		
		msgData = JSON.parse(data); 
		
		var sessionid = null;
		var message = null;
		
		//current session id//
		var currentuser_session = $('#sessionuserid').val();
		console.log('current session id: ' + currentuser_session);
		
		var target = $('#chattingBox-'+msgData.messageId+'-'+msgData.user);
		
		if(target.length==0){
			$('<div id=\"chattingBox-'+msgData.messageId+'-'+msgData.user+'\" class=\"chattingBox\"></div>').html('<h1>'+msgData.user+' : '+msgData.articleOwner+'</h1>').appendTo('body');
			$('#chattingBox-'+msgData.messageId+'-'+msgData.user).append('<hr>')
		}

			

		//나와 상대방이 보낸 메세지를 구분하여 영역을 나눈다.//
		if (msgData.user == currentuser_session) {
			var printHTML = "<div class='well text_right'>";
			printHTML += "<div class='alert alert-info'>";
			printHTML += "<strong>[" + msgData.user + "] -> " + msgData.message
					+ "</strong>";
			printHTML += "</div>";
			printHTML += "</div>";

			$('#chattingBox-'+msgData.messageId+'-'+msgData.user).append(printHTML);
		} else {
			var printHTML = "<div class='well text_left'>";
			printHTML += "<div class='alert alert-warning'>";
			printHTML += "<strong>[" + msgData.user + "] -> " + msgData.message
					+ "</strong>";
			printHTML += "</div>";
			printHTML += "</div>";

			$('#chattingBox-'+msgData.messageId+'-'+msgData.user).append(printHTML);
		}

		console.log('chatting data: ' + data);

		/* sock.close(); */
	}

	function onClose(evt) {
		$("#data").append("연결 끊김");
	}
</script>
</html>