package scm;

public class Buyer {
	
	int money;		// 구매의 보유 금액
	int bonusPoint; // 구매자의 보유 포인트
	
	Product[] item; // 구매시에 담을 제품 배열
	int numOfProduct; // 구매 제품 개수
	
	Buyer(){
		this.money = 1000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.numOfProduct=0;
	}
	
	void buy(Product p) {
		
		// 구매 상품의 금액과 나의 보유금액 비교해서 구매 여부 처리
		if(money < p.price) {
			System.out.println("잔액이 부족해서 구매할 수 없습니다.");
			return;
		}
		
		// 구애 처리
		this.money -= p.price; // 보유한 금액에서 제품의 금액 차감
		this.bonusPoint += p.bonusPoint;	// 보유한 포인트에 제품의 포인트를 추가
		
		item[numOfProduct++] = p;
		//numOfProduct++;
		
		
		System.out.println(p + "를 구매하셨습니다.");
		
	}
	
	// 구매 내역을 출력
	void summary() {
		
		int sum=0; // 구매 제품의 총액
		int points=0;  // 구매한 제품들의 포인트 총합
		
		String itemList = "";  // 구매 제품의 이름 목록
		
		for(int i=0; i<numOfProduct; i++) {
			itemList += item[i]+", ";			
			// itemList = itemList + (item[i]+", ");
			sum +=item[i].price;
			points +=item[i].bonusPoint;
			
		}
		
		System.out.println("구매 목록 ==============");
		System.out.println("구매하신 제품은 ");
		System.out.println(itemList+"입니다.");
		System.out.println("구매하신 제품들의 총 금액은 " + sum + "입니다.");
		System.out.println("구매하신 제품들의 적립될 총 포인트는 " + points + "점 입니다");
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
