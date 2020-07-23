package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.util.JdbcUtil;
import board.model.Board;

// [ListBoardService �� �ʿ�� �ϴ� ������ ����]
/* [BoardDao]
 - Board ���̺� ���� CRUD ������ �������ִ� �޼��带 �����ϰ� �ִ� �߻�Ŭ����
 - Delete ������ ���� ��� DBMS�� �������� ����� �� �ִ� ����� ������ �Բ� ������. 
 */
public class BoardDao {
	/* [�̱��� ����]: Ŭ���� �� �� ���� ��ü�� �����ǵ��� �����ϴ� ���� ���� 
	   - ���񽺳� DAO�� �Ź� ��ü�� ������ �ʿ䰡 �����Ƿ�, �̱��� ���� �����ϱ⿡ ����
	*/
	// 1. ������ ��ü�� ���� �ʵ忡 ����
	private static BoardDao instance = new BoardDao();
	// 2. ������ ��ü�� ������ �� �ִ� ���� �޼��� ����	
	public static BoardDao getInstance() {
		return instance;
	}
	// 3. �����ڸ� private���� �����ؼ� �ܺο��� �������� ����	
	private BoardDao() {

	}

	
	// ## �Է�
	// �Ķ���ͷ� ���� ���� Board ��ü�κ��� ���� �о��,  insert ��Ų ��, �����ϸ� �űԷ� ���Ե� �������� Ű ���� ����
	public int insert(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// insert ���� ��, ��� ������ insertedCount�� ����
			pstmt = conn.prepareStatement("insert into board3 "
				+ "(title, content, readnum, ref, step, low, isdel, writer_idx, writer_id, writer_name) "
				+ "values (?, ?, 0, , 0, 0, 0, ?, ?, ?)");

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getWriter_idx());
			pstmt.setString(4, board.getWriter_id());
			pstmt.setString(5, board.getWriter_name());			

			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select BOARD3_IDX_SEQ.currval from dual");

				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			return -1;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		} // end try
	}

	
	// # �Խñ��� ��ü ����
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from board3");
			rs.next();
			return rs.getInt(1);

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	
	// ## ����Ʈ 
	public List<Board> select(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// board �����͸� ref desc, step asc ������ �����ؼ�, ���� ��� �� �࿡ �ش��ϴ� �ุ ���Ѵ�.
			pstmt = conn.prepareStatement("select idx, title, content, readnum, ref, step, low, isdel, write_id, write_name, writeday from ( "
							+ "select rownum rnum, idx, title, content, readnum, ref, step, low, isdel, write_id, write_name, writeday from ("
							+ "select * from board3 a order by a.ref desc, a.step asc, a.idx asc) where rownum <= ?"
							+ ") where rnum >= ? ");
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, firstRow);
			
			rs = pstmt.executeQuery();
			
			//1. �����Ͱ� ���ٸ�, �� List ����
			if (!rs.next()) {
				return Collections.emptyList();
			}
			
			//2. �����Ͱ� �ִٸ�, �����ͷκ��� Board ��ü�� ������ boardList�� �����ϰ�, boardList ��ü�� ����
			List<Board> boardList = new ArrayList<Board>();

			do {
				//@@ �Խñ� ����� �о�� �� ���Ǵ� BoardDao.select() �޼���� �Խñ� ������ �ʿ����� �����Ƿ�, readContent �Ķ���� ������ false�� ������!!
				Board board = makeBoardFromResultSet(rs, false);
				boardList.add(board);
			} while (rs.next());
			return boardList;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// ResultSet���κ��� �����͸� �о�� Board ��ü�� ������ �ش�.
	// readContent �� ���� ����, board ���̺�κ��� content Į���� ���� �о���� ���� ����
	private Board makeBoardFromResultSet(ResultSet rs, boolean readContent) throws SQLException {
		Board board = new Board();
		board.setIdx(rs.getInt("idx"));
		
		board.setTitle(rs.getString("title"));
		if (readContent) {
			board.setContent(rs.getString("content"));
		}		
		
		board.setReadnum(rs.getInt("readnum"));
		board.setRef(rs.getInt("ref"));
		board.setStep(rs.getInt("step"));
		board.setLow(rs.getInt("low"));
		board.setIsdel(rs.getInt("isdel"));
		board.setWrite_id(rs.getString("write_id"));
		board.setWrite_name(rs.getString("write_name"));
		board.setWriteday(rs.getDate("writeday"));

		return board;
	}
	
	
	// ## �б� ���� �޼���
	// ������ idx �� �ش��ϴ� ������ ��ȸ (���� ������, Board ��ü�� ������ �� ����, ���� ������ null����)
	public Board selectById(Connection conn, int board_idx) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from board3 "
				+ "where idx = ?");
			
			pstmt.setInt(1, board_idx);
			rs = pstmt.executeQuery();
			
			//1. �����Ͱ� ���ٸ� null ����
			if (!rs.next()) {
				return null;
			}
			//2. �����Ͱ� �ִٸ� ResultSet���� ����, Board ��ü�� ������ �� ����
			Board board = makeBoardFromResultSet(rs, true);
			return board;
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// # ��ȸ�� 1 ����
	public void increaseReadCount(Connection conn, int board_idx) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("update board3 "
				+ "set readnum = readnum + 1 "
				+ "where idx = ?");
			
			pstmt.setInt(1, board_idx);
			pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
	}	

	
	// ## ����
	public int update(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("update board3 "
				+ "set title = ?, content = ? where idx = ?");
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getIdx());
			
			return pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	
	// ## ����
	public void delete(Connection conn, int board_idx) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("delete from board3 "
				+ "where idx = ?");
			
			pstmt.setInt(1, board_idx);
			pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
	}		

	
	
	// ## �亯 ���� �޼���
	/* �亯 �� �� �ʿ��� �޼��� 
	    1. �亯 �� �θ���� �ִ��� üũ (  selectById()  )
		2. reply_before_update()
		3. reply_insert()
	 */
	// # [1] selectById() �� �亯 �� �θ�� �ִ��� üũ
	
	// # [2] �亯 ���� �ϱ� �� update
	// db���� ���� ref �� �ڱ⺸�� ū step�� step ���� 1 ������Ų��
	public void reply_before_update(Connection conn, int ref, int step) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("update board3 "
				+ "set step = step+1 where ref = ? and step > ?");

			pstmt.setInt(1, ref);
			pstmt.setInt(2, step);
			pstmt.executeUpdate();
			//return pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
		}
	}	
	
	// # [3] �亯 ����
	// �Ķ���ͷ� ���� ���� Board ��ü�κ��� ���� �о��,  insert ��Ų ��, �����ϸ� �űԷ� ���Ե� �������� Ű ���� ����
	public int reply_insert(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// reply_insert ���� ��, ��� ������ reply_insertedCount�� ����
			pstmt = conn.prepareStatement("insert into board3 "
				+ "(idx, title, content, readnum, ref, step, low, isdel, write_id, write_name, writeday) "
				+ "values (BOARD3_IDX_SEQ.NEXTVAL, ?, ?, 0, ?, ?, ?, 0, ?, ?, ?)");

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getRef());
			pstmt.setInt(4, board.getStep());
			pstmt.setInt(5, board.getLow());
			pstmt.setString(6, board.getWrite_id());
			pstmt.setString(7, board.getWrite_name());			
			pstmt.setTimestamp(8, new Timestamp(board.getWriteday().getTime()));
		
			int reply_insertedCount = pstmt.executeUpdate();

			// 1. ���Ե� ���� �ִٸ�, reply_insertedCount�� ������ ���� Ű ��(board_idx)�� �����Ѵ�.
			if (reply_insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select BOARD3_IDX_SEQ.currval from dual");

				if (rs.next()) {
					return rs.getInt(1);
				}
			}
			// 2. ���Ե� ���� ���ٸ�, -1 ����
			return -1;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		} // end try
	}	
	
}
