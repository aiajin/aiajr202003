package com.aia.socket.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aia.socket.HomeController;
import com.aia.socket.domain.Message;
import com.google.gson.Gson;

public class EchoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private Map<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		String chatMember = (String) session.getAttributes().get("user");

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + chatMember);

		sessionList.add(session);
		sessionMap.put(chatMember, session);

		logger.info("{} 연결되었습니다.", session.getId()+":"+chatMember);

		System.out.println("체팅 참여자 : " + chatMember);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String chatMember = (String) session.getAttributes().get("user");
		
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatMember, message.getPayload());
		
		Gson gson = new Gson();
		
		Message msg = gson.fromJson(message.getPayload(), Message.class);
		
		System.out.println(msg);
		
		WebSocketSession ws = sessionMap.get(msg.getTo());
		
		// 전달 메시지
		TextMessage sendMsg = new TextMessage(gson.toJson(msg));
		
		// 상대방에게 메시지 전달
		ws.sendMessage(sendMsg);
		// 자신에게 메시지 전달
		session.sendMessage(sendMsg);

//		for (WebSocketSession webSocketSession : sessionList) {
//			webSocketSession.sendMessage(new TextMessage(chatMember + "|" + message.getPayload()));
//		}

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		String chatMember = (String) session.getAttributes().get("user");
		
		sessionList.remove(session);

		logger.info("{} 연결이 끊김", session.getId()+chatMember);

		System.out.println("체팅 퇴장 : " + chatMember);
		// System.out.println("체팅 퇴장 : " + session.getPrincipal().getName());
	}

}
