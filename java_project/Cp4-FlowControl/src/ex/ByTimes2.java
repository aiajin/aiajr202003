package ex;

public class ByTimes2 {

	public static void main(String[] args) {
		
		// 구구단
		// 단 * 1~9 = 결과 : 2*1=2
		
		// 단
		int i = 2;
		while(i<10) {
			
			System.out.println(i+"단");
			
			System.out.println("----------");
			
			int j=1;
			while(j<10) {
				
				System.out.println(i+" X "+j+" = "+i*j);
				
				j++;
			}
			
			System.out.println("----------");
			
			i++;
			
		}
		
		char c = 'a'+1;
		
		
		
		
	}

}
