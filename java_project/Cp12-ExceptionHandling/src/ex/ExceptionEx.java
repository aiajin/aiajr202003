package ex;

import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {

		try {

			int age = readAge();
			
			

			System.out.println("나이는 " + age + "세 입니다.");

		} catch (AgeInputException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램이 정상 종료되었습니다.");

	}

	static int readAge() throws AgeInputException {

		Scanner kb = new Scanner(System.in);

		System.out.println("나이를 입력해주세요.");
		int age = kb.nextInt();
		
		
		if (age < 0) {

			// Exception e = new Exception("고의로 발생 시킴");
			AgeInputException e = new AgeInputException();

			throw e; // 장제적으로 예외 발생 지점
		}
		
		
		
		return age;

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
