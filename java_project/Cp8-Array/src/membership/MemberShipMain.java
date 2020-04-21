package membership;

public class MemberShipMain {

	public static void main(String[] args) {
		
		
		// 회원 정보 5개를 저장 할 수 있는 배열을 생성
		// Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간
		// Member m1, m2, m3, m4, m5
		Member[] members = new Member[5];
		
		// Member 타입의 인스턴스 주소 저장
		members[0] = new Member("cool", "시원한", "cool@gmail");
		members[1] = new Member("hot", "뜨거운", "hot@gmail");
		members[2] = new Member("son", "손흥민", "son@gmail");
		members[3] = new Member("park", "박지성", "park@gmail");
		members[4] = new Member("cha", "차두리", "cha@gmail");
		
//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
//		members[5].showInfo();
		
		for(int i=0; i<members.length; i++) {
			System.out.println(members[i]);
		}
		
		System.out.println("=============================");
		

		for(int i=0; i<members.length; i++) {
			members[i].showInfo();
			System.out.println("---------------------");
		}
		
		
		
		
		
		
		
		
//		Member member = 
//				new Member(
//						"cool", 
//						"시원한", 
//						"cool@gmail.com");
//		
//		member.showInfo();
//		
//		System.out.println("-----------");
//		
//		System.out.println(member);  // member.toString() 호출
		

		
		
		
		
		
		
	}

}
