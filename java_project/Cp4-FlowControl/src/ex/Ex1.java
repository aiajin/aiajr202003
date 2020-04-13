package ex;

public class Ex1 {

	public static void main(String[] args) {
		// 1~ 10까지의 합
		// 반복 +1 씩 
		
		// 연산의 합을 담는 변수
		int sum = 0;
		
		for(int i=1 ; i<=10; i++) {
			//System.out.println(i);
			sum = sum + i;			
		}
		
		System.out.println("1 부터 10까지의 숫자의 합 : " + sum);
		

		int i=1;
		sum = 0;
		
		while(i<=10) {
			//System.out.println(i);
			sum += i;
			i++;
		}
		
		System.out.println("1 부터 10까지의 숫자의 합 : " + sum);
		
		
		
		

	}

}
