package ex;

public class ByTimes1 {

	public static void main(String[] args) {
		
		// 구구단
		// 단 * 1~9 = 결과 : 2*1=2
		
		// 단
		for(int i=2; i<10; i++) {
			System.out.println(i+"단");
			System.out.println("-----------");
			for(int j=1; j<10; j++) {
				System.out.println(i+" X "+j+" = "+i*j);
			}
			System.out.println("-----------");
		}
		
		
		
	}

}
