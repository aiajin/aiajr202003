package membership;


// 회원 정보를 저장하기 위한 클래스 생성
public class Member {
	
	String memberId;
	String memberName;
	String memberEmail;
	
	// 생성자
	Member(String memberId, String memberName, String memberEmail){
		this.memberId=memberId;
		this.memberName=memberName;
		this.memberEmail=memberEmail;		
	}
	
	void showInfo() {
		System.out.println("아이디 : " + this.memberId);
		System.out.println("이  름 : " + this.memberName);
		System.out.println("이메일 : " + this.memberEmail);
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}
	
	
	

	
	
	
	
	
}
