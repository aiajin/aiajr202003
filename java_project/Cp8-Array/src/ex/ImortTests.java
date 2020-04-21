package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImortTests {

	public static void main(String[] args) {
		
		// java.util.Date
		// 날짜와 시간 정보를 하나로 표현
		Date today = new Date();
		
		System.out.println(today); // today.toString()
		
		SimpleDateFormat dateFormat = 
				
				new SimpleDateFormat("yyyy.MM.dd. HH:mm");
		
		System.out.println(dateFormat.format(today));
		

		
		
		
		
		
		
		
		
		
	}

}
