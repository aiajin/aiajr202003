package scm;

public class Computer extends Product{
	
	Computer(int price){
		super(price);
	}

	@Override
	public String toString() {
		return "Computer";
	}
	
	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
	
		

}
