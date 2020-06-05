package ver07;

import java.sql.Connection;
import java.sql.SQLException;

import ver07.domain.PhoneBookDto;

public class PhoneBookManager {
	
	PhoneBookDao dao = new PhoneBookDao();
	
	
	
	void insetUnivInfo() {
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);

			PhoneBookDto pbDto = new PhoneBookDto(
					0, 
					"SON", 
					"010-9999-8888", 
					"son@gmail.com", 
					"LONDON", 
					null, 
					"COMPUTER", 
					"1", 
					null);
			
			dao.basicInfoInsert(pbDto, conn);
			dao.univInfoInsert(pbDto, conn);
			
			
			conn.commit();
			
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
					
				} catch (SQLException e1) {
					System.out.println("rollback 에러!!");
					e1.printStackTrace();
				}	
			}
			
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
