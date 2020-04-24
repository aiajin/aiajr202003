package scm;

public class Audio extends Product {

	Audio(int price){
		super(price);
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
	void music() {
		System.out.println("음악을 듣습니다.");
	}
	
	
}
