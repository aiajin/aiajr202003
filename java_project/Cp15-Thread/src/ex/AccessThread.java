package ex;

public class AccessThread extends Thread {
	
	TwoNum twoNum;
	
	public AccessThread(TwoNum twoNum) {
		this.twoNum = twoNum;		
	}

	@Override
	public void run() {
		
		twoNum.addOneNum1();
		twoNum.addTwoNum1();
		
		twoNum.addOneNum2();
		twoNum.addTwoNum2();
		
	}
	
	
	

}
