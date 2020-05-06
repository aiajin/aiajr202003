package ex;

import javax.swing.JOptionPane;

public class ThreadMain3 {

	public static void main(String[] args) {
		
		System.out.println("프로그램을 시작합니다.");		
		
		String input = JOptionPane.showInputDialog("사용자의 이름을 입력해주세요.");
		
		for(int i=10; i>0 ; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println(input);

	}

}





