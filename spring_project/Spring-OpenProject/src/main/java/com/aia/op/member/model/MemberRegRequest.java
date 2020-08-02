package com.aia.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	private String uid;
	private String upw;
	private String uname;
	private MultipartFile photo;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	// MemberRegRequest -> Member 
	public Member toMember() {
		return new Member(uid, upw, uname);
	}
	
	

	@Override
	public String toString() {
		return "MemberRegRequest [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo=" + photo + "]";
	}

}
