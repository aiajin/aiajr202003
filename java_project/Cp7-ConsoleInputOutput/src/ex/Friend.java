package ex;

public class Friend {

	String myName;
	
	Friend(String name){
		myName = name;		
	}
	
	// Object 클래의 toString() 메서드를 재 구성한다 -> 오버라이딩
	// 메서드의 선언부가 원본 메서드의 선언부와 동일해야한다.
	public String toString() {		
		return "제 이름은 " + this.myName + "입니다.";		
	}


//	@Override
//	public String toString() {
//		return "Friend [myName=" + myName + "]";
//	}
	
	
	
	
	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");
		
		System.out.println(f1.toString());
		System.out.println(f1);
		
		System.out.println(f2.toString());		
		System.out.println(f2);
		
		
	}
	
}
