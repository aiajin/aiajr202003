package card;

public class CardMain { // card.CardMain

	public static void main(String[] args) {
		
		// 인스턴스 생성
		//Card c1 = new Card();
		//c1.kind="Heart";
		//c1.number=7;
		Card c1 = new Card("Heart", 7);
		
		
		// 인스턴스 생성
		Card c2 = new Card();
		c2.kind="spade";
		c2.number=4;
		
		System.out.println("첫번째 카드는 "+c1.kind+" "+c1.number+" 카드의 높이는 "+ c1.height + "이고 폭은 "+c1.width+" 입니다.");
		System.out.println("두번째 카드는 "+c2.kind+" "+c2.number+" 카드의 높이는 "+ c2.height + "이고 폭은 "+c2.width+" 입니다.");
		
		System.out.println("카드의 사이즈를 변경합니다.");
		
		Card.height=125;
		Card.width=50;

		System.out.println("첫번째 카드는 "+c1.kind+" "+c1.number+" 카드의 높이는 "+ c1.height + "이고 폭은 "+c1.width+" 입니다.");
		System.out.println("두번째 카드는 "+c2.kind+" "+c2.number+" 카드의 높이는 "+ c2.height + "이고 폭은 "+c2.width+" 입니다.");
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
