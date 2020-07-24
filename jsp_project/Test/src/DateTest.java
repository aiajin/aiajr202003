import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();

		System.out.println(now);
		
		java.sql.Date now2 = new java.sql.Date(now.getTime());
		
		System.out.println(now2);
		
		Date now3 = new Date(now2.getTime());
		
		System.out.println(now3);
	}

}
