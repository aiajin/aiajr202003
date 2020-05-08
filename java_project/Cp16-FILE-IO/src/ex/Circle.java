package ex;

import java.io.Serializable;

public class Circle implements Serializable {

	int xPos;
	int yPos;
	double rad;

	public Circle(int xPos, int yPos, double rad) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rad = rad;
	}
	
	void showCircleInfo() {
		System.out.println("xPos :"+xPos+", yPos : "+yPos);
		System.out.println("rad : " + rad);
	}

}
