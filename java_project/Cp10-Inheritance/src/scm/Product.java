package scm;


// 상품 객체들의 상위클래스
public class Product {
	
	final int price; // 제품의 가격
	final int bonusPoint; // 제품의 포인트
	
	
	Product(int price){
		this.price = price;
		this.bonusPoint = this.price/10;
	}
	
}
