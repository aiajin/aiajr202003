package ex;

public class CalMinThread extends Thread {
	
	Calcurator cal ;
	
	public CalMinThread(Calcurator c) {
		cal = c;
	}

	@Override
	public void run() {
		System.out.println(cal.min(2, 1));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cal.min(4, 2));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
