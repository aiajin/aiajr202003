package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
		// DB Connection 정보
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		return DriverManager.getConnection(dbUrl, user, pw);
	}
	
	
}
