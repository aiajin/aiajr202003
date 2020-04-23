package ex;

public class Tv {
	
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
	void display() {
		System.out.println("TV 재생합니다.");
	}
	

}
