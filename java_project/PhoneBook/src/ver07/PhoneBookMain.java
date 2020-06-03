package ver07;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		
		try {
		
			// 1. 오라클 드라이버 라이브러리 추가 : ojdbc6.jar
			// 2. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			PhoneBookManager pbm = new PhoneBookManager();
			
			pbm.insetUnivInfo();
			
		
		
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 드라이버가 로드되지 않아 프로그램을 종료 합니다.");
			e.printStackTrace();
		}
		
		
	}

}
