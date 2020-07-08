package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.EmpDao;
import jdbc.ConnectionProvider;
import model.Emp;

public class EmpListService {
	
	// 싱클톤 패턴
	private EmpListService() {
	}
	private static EmpListService service = new EmpListService();
	public static EmpListService getInstance() {
		return service;
	}
	
	
	
	EmpDao dao ;
	
	// 예외처리 , 트랜젝션
	public List<Emp> getEmpList(){
		// 사용할 Dao 인스턴스
		dao = EmpDao.getInstance();
		// Connection 
		Connection conn=null;
		List<Emp> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			list = dao.getEmpList(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

}
