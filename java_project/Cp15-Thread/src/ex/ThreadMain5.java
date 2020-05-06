package ex;

public class ThreadMain5 {

	public static void main(String[] args) {
		
		Sum sum = new Sum();
		
		AddThread at1 = new AddThread(sum, 1, 5000);
		AddThread at2 = new AddThread(sum, 5001, 10000);
		
		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1~100 까지의 합 : " + sum.getNum());
		
		

	}

}





