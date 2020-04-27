package ver04;

// PhoneInfo 클래스를 상속해서 새로운 클래스를 정의
public class PhoneUnivInfo extends PhoneInfo{

	String major;	// 친구의 전공
	String grade;	// 친구의 학년
	
	PhoneUnivInfo(
			String name,
			String phoneNumber, 
			String addr, 
			String email,
			String major,
			String grade) {
		super(name, phoneNumber, addr, email);
		this.major = major;
		this.grade = grade;
		
	}

	@Override
	void showAllInfo() {
		super.showAllInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
