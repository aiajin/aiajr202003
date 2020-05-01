package ver06;


// 상속을 위한 기본 클래스 구성
public abstract class PhoneInfo implements Info {
	
	String name;		// 친구의 이름
	String phoneNumber;	// 친구의 전화번호
	String addr;		// 친구의 주소
	String email;		// 친구의 이메일
	
	// 인스턴스 변수 초기화
	PhoneInfo(String name, 
				String phoneNumber,
				String addr,
				String email){
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;		
	}
	
	// 기본 정보 출력 메서드
	void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("주소 : " + addr);
		System.out.println("이메일 : " + email);
	}
	
	// 2020.04.29
	// 수정 내용 : interface 구현으로 메서드 오버라이딩 생략
	//           PhoneInfo 클래스 -> 추상클래스
	// 전체 정보 출력 메서드
//	public void showAllInfo() {
//		// 상속 후 오버라이딩을 통해 재 구성
//		showBasicInfo();
//		
//	}

}













