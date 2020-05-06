package ex;

public class ThreadMain8 {

	public static void main(String[] args) {
		
		TwoNum tn = new TwoNum();
		
		AccessThread at1 = new AccessThread(tn);
		AccessThread at2 = new AccessThread(tn);
		
		at1.start();
		at2.start();
		
		
		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tn.showNums();
		
		
		
		

	}

}





