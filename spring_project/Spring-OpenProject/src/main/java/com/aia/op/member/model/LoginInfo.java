package com.aia.op.member.model;

public class LoginInfo {

	private String uid;
	private String uname;
	private String photo;

	public LoginInfo() {
	}

	public LoginInfo(String uid, String uname, String photo) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.photo = photo;
	}

	public String getUid() {
		return uid;
	}

	public String getUname() {
		return uname;
	}

	public String getPhoto() {
		return photo;
	}

	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", uname=" + uname + ", photo=" + photo + "]";
	}

}
