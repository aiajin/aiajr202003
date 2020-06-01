package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EMPManager {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("Select Menu");
			System.out.println("----------------");
			System.out.println("1. EMP,  2. DEPT");
			System.out.println("----------------");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				empManager();
				break;
			case 2:
				deptManager();
				break;
			}

		}

	}


	
	
	
	/////////////////////////////////////////////////////////////////
	// DEPT MANAGER
	/////////////////////////////////////////////////////////////////
	
	

	private static void deptManager() {

		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			deptInsert();
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			deptSearch();
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");
			deptDelete();
			break;
		case 5:
			System.out.println("부서 정보를 수정합니다.");
			deptEdit();
			break;

		}


	}
	
	
	
	
	private static void deptEdit() {


		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("수정하고자 하는 부서 이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.

			stmt = conn.createStatement();

			String selectSql = "select * from dept where dname='" + searchName + "'";

			rs = stmt.executeQuery(selectSql);

			int sDeptno = 0;
			String sDname = "";
			String sLoc = "";
			
			if (rs.next()) {
				sDeptno = rs.getInt("deptno");
				sDname = rs.getString("dname");
				sLoc = rs.getString("loc");
			} else {
				System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
				return;
			}

			// 사용자 입력정보 변수
			System.out.println("부서 정보를 입력해주세요.");

			System.out.println("부서 번호 : " + sDeptno);
			System.out.println("부서 번호는 수정되지 않습니다.");

			System.out.println("부서 이름 ( " + sDname + "  ) : ");
			String dname = sc.nextLine();

			System.out.println("지역 ( " + sLoc + "  ) : ");
			String loc = sc.nextLine();


			// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

			String sql = "update dept  set  dname=?, loc=? " + " where deptno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, sDeptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 수정 되었습니다.");
				System.out.println(resultCnt + "행이 수정되었습니다.");
			} else {
				System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
	}



	private static void deptDelete() {


		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("삭제하고자 하는 부서이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "delete from dept  where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			int resultCnt = pstmt.executeUpdate();

			if (resultCnt < 1) {
				System.out.println("삭제할 정보가 검색 결과가 없습니다.");
			} else {
				System.out.println(resultCnt + "행이 삭제 되었습니다.");
			}

			System.out.println("=================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
	}



	private static void deptSearch() {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 부서이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// Mysql
			// "SELECT * FROM dept WHERE dname LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from dept where dname like '%'||?||'%'

			String sql = "select * from dept  where dname like '%'||?||'%' or  loc like '%'||?||'%'";
			// String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			pstmt.setString(2, searchName);
			rs = pstmt.executeQuery();

			int resultCnt = 0;
			System.out.println("검색 결과");
			System.out.println("=======================================================================");
			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.printf("%15s", rs.getString("dname") + "\t");
				System.out.printf("%15s", rs.getString("loc") + "\n");
				resultCnt++;
			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		
	}



	private static void deptInsert() {


		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수
		System.out.println("부서 정보를 입력해주세요.");

		System.out.println("부서번호 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 : ");
		sc.nextLine();
		String dname = sc.nextLine();
		System.out.println("지역 : ");
		String loc = sc.nextLine();
		
		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into dept " + " (deptno, dname, loc) "
					+ " values (?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		
	}



	private static void deptList() {


		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "select * from dept  order by dname";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			int resultCnt = 0;
			System.out.println("검색 결과");
			System.out.println("=======================================================================");
			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				System.out.printf("%15s", rs.getString("dname") + "\t");
				System.out.printf("%15s", rs.getString("loc") + "\n");
				resultCnt++;
			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		
	}


	
	/////////////////////////////////////////////////////////////////
	// EMP MANAGER
	/////////////////////////////////////////////////////////////////
	
	

	private static void empManager() {
		System.out.println("EMP Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			empList();
			break;
		case 2:
			System.out.println("사원 정보를 입력합니다.");
			empInsert();
			break;
		case 3:
			System.out.println("사원 정보를 검색합니다.");
			empSearch();
			break;
		case 4:
			System.out.println("사원정보를 삭제합니다.");
			empDelete();
			break;
		case 5:
			System.out.println("사원정보를 수정합니다.");
			empEdit();
			break;

		}

	}

	private static void empEdit() {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("수정하고자 하는 사원이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.

			stmt = conn.createStatement();

			String selectSql = "select * from emp where ename='" + searchName + "'";

			rs = stmt.executeQuery(selectSql);

			int sEmpno = 0;
			String sEname = "";
			int sDeptno = 0;
			int sSal = 0;

			if (rs.next()) {
				sEmpno = rs.getInt("empno");
				sEname = rs.getString("ename");
				sSal = rs.getInt("sal");
				sDeptno = rs.getInt("deptno");
			} else {
				System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
				return;
			}

			// 사용자 입력정보 변수
			System.out.println("사원 정보를 입력해주세요.");

			System.out.println("사원번호 : " + sEmpno);
			System.out.println("사원번호는 수정되지 않습니다.");

			System.out.println("사원이름 ( " + sEname + "  ) : ");
			String ename = sc.nextLine();

			System.out.println("급여( " + sSal + "  ) : ");
			int sal = sc.nextInt();

			System.out.println("부서번호( " + sDeptno + "  ) : ");
			int deptno = sc.nextInt();

			// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

			String sql = "update emp  set  " + " ename=?, sal=?, deptno=? " + " where empno=?";

			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setInt(2, sal);
			pstmt.setInt(3, deptno);
			pstmt.setInt(4, sEmpno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 수정 되었습니다.");
				System.out.println(resultCnt + "행이 수정되었습니다.");
			} else {
				System.out.println("수정이 되지않았습니다. 확인후 재 시도해주세요.");
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	private static void empList() {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "select * from emp  order by ename";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			int resultCnt = 0;
			System.out.println("검색 결과");
			System.out.println("=======================================================================");
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.printf("%6s", rs.getString("ename") + "\t");
				System.out.printf("%9s", rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate").substring(0, 10) + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				resultCnt++;
			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	private static void empDelete() {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("삭제하고자 하는 사원이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			String sql = "delete from emp  where ename=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			int resultCnt = pstmt.executeUpdate();

			if (resultCnt < 1) {
				System.out.println("삭제할 정보가 검색 결과가 없습니다.");
			} else {
				System.out.println(resultCnt + "행이 삭제 되었습니다.");
			}

			System.out.println("=================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	private static void empSearch() {
		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 사원이름 : ");
		sc.nextLine();
		String searchName = sc.nextLine();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// Mysql
			// "SELECT * FROM epm WHERE name LIKE ?"
			// psmt.setString(1, "%"+name+"%");

			// Oracle
			// select * from emp where ename like '%'||?||'%'

			String sql = "select * from emp  where ename like '%'||?||'%'";
			// String sql = "select * from emp where ename=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();

			int resultCnt = 0;
			System.out.println("검색 결과");
			System.out.println("=======================================================================");
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate").substring(0, 10) + "\t");
				System.out.print(rs.getInt("sal") + "\t");
				System.out.print(rs.getInt("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				resultCnt++;
			}
			if (resultCnt < 1) {
				System.out.println("검색 결과가 없습니다.");
			}

			System.out.println("=======================================================================");

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	private static void empInsert() {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 사용자 입력정보 변수
		System.out.println("사원 정보를 입력해주세요.");

		System.out.println("사원번호 : ");
		int empno = sc.nextInt();
		System.out.println("사원이름 : ");
		sc.nextLine();
		String ename = sc.nextLine();
		System.out.println("직급(업무) : ");
		String job = sc.nextLine();
		System.out.println("관리자 : ");
		int mgr = sc.nextInt();
		System.out.println("입사일 : ");
		sc.nextLine();
		String hiredate = sc.nextLine();
		System.out.println("급여 : ");
		int sal = sc.nextInt();
		System.out.println("수당 : ");
		int comm = sc.nextInt();
		System.out.println("부서번호 : ");
		int deptno = sc.nextInt();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 0. 드라이버 LIB 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결

			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into emp " + " (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);

			int resultCnt = pstmt.executeUpdate();

			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}


}
