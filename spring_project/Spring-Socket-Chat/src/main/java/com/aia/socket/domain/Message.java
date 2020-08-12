package com.aia.socket.domain;

public class Message {

	private String user;
	private String to;
	private String message;

	public Message(String user, String to, String message) {
		this.user = user;
		this.to = to;
		this.message = message;
	}

	public Message() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [user=" + user + ", to=" + to + ", message=" + message + "]";
	}

	
}
