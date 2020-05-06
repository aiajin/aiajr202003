package ex;

public class TwoNum {
	
	int num1=0;
	int num2=0;
	
	void addOneNum1() {
		synchronized (this) {
			num1 += 1;	
		}
	}
	
	void addTwoNum1() {
		synchronized (this) {
			num1 += 2;
		}
		
	}
	
	void addOneNum2() {		
		synchronized (key1) {
			num2 += 1;	
		}
	}
	
	void addTwoNum2() {		
		synchronized (key1) {
			num2 += 2;
		}
		
	}
	
	Object key1 = new Object();
	String key2 = "key2";
	
	void showNums() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}

}










