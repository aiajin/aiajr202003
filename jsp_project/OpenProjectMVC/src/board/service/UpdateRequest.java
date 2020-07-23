package board.service;

// 게시글 수정 요청 정보 저장
public class UpdateRequest {

	private int idx;
	private String title;
	private String content;
	//private String password;
	
	public int getIdx() { return idx; }
	public void setIdx(int idx) { this.idx = idx; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	
	//public String getPassword() { return password; }
	//public void setPassword(String password) { this.password = password; }
	
}
