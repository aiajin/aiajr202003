package com.aia.mm.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberEditRequest {

	private int idx;
	private String uid;
	private String upw;
	private String uname;
	private MultipartFile photo;
	private String oldFile;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

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

	public String getOldFile() {
		return oldFile;
	}

	public void setOldFile(String oldFile) {
		this.oldFile = oldFile;
	}
	
	public Member toMember() {
		return new Member(idx, uid, upw, uname, oldFile.length()>0?oldFile:null, null);
	}

	
	
	@Override
	public String toString() {
		return "MemberEditRequest [idx=" + idx + ", uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", photo="
				+ photo.getOriginalFilename() + ", oldFile=" + oldFile + "]";
	}
	
	
	

}
