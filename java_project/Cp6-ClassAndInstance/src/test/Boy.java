package test;

import card.Card;

public class Boy {	// test.Boy
	
	
	// 구슬의 개수
	int numOfMarble;
	
	
	Boy(int num){
		numOfMarble = num;
	}
	
	
	
	
	// 구슬의 개수 설정
	void setMarble(int num) {
		numOfMarble=num;
	}
	
	
	void gameWin(Boy boy, int num) {
		numOfMarble+=num;
		boy.numOfMarble-=num;
	}
	
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 "+numOfMarble+"개 입니다.");
	}
	
	public static void main(String[] args) {
		
		// 철수 생성
		Boy boy1 = new Boy(15);
		// 영희 생성
		Boy boy2 = new Boy(9);
		
		// 철수는 구슬을 15개 보유, 영희는 구슬을 9개 보유
		//boy1.setMarble(15);
		//boy2.setMarble(9);
		
		System.out.println("철수는 구슬을 "+boy1.numOfMarble+"개 보유, 영희는 구슬을 "+boy2.numOfMarble+"개 보유");
		
		System.out.println("-----------------------------------------");
		
		// 1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다
		System.out.println("1차 게임에서 철수는 영희의 구슬 2개를 획득한다");
		
		boy1.gameWin(boy2, 2);
		
		System.out.println("철수");
		boy1.showData();
		System.out.println("영희");
		boy2.showData();
		
		System.out.println("-----------------------------------------");
		
		// 2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.
		System.out.println("2차 게임에서 영희는 철수의 구슬 7개를 획득한다.");
		boy2.gameWin(boy1, 7);

		System.out.println("철수");
		boy1.showData();
		System.out.println("영희");
		boy2.showData();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
