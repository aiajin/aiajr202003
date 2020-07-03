package model;

public class LoginInfo {

	private String uid;
	private String uname;
	private String email;
	private String photo;

	public LoginInfo(String uid, String uname, String email, String photo) {
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.photo = photo;
	}

	public String getUid() {
		return uid;
	}



	public String getUname() {
		return uname;
	}



	public String getEmail() {
		return email;
	}



	public String getPhoto() {
		return photo;
	}



	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", uname=" + uname + ", email=" + email + ", photo=" + photo + "]";
	}

	

}
