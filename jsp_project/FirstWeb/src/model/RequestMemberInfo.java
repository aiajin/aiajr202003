package model;

public class RequestMemberInfo {

	private String id;
	private String pw;
	private String uname;
	
	

	public RequestMemberInfo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "requestMemberInfo [id=" + id + ", pw=" + pw + ", uname=" + uname + "]";
	}

}
