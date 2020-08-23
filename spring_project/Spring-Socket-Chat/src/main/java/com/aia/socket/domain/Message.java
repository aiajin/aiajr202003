package com.aia.socket.domain;

public class Message {

	private String user;
	private String to;
	private String articleId;
	private String articleOwner;
	private String message;

	public Message(String user, String to, String articleId, String articleOwner, String message) {
		this.user = user;
		this.to = to;
		this.articleId = articleId;
		this.articleOwner = articleOwner;
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

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleOwner() {
		return articleOwner;
	}

	public void setArticleOwner(String articleOwner) {
		this.articleOwner = articleOwner;
	}

	@Override
	public String toString() {
		return "Message [user=" + user + ", to=" + to + ", articleId=" + articleId + ", articleOwner=" + articleOwner
				+ ", message=" + message + "]";
	}



}
