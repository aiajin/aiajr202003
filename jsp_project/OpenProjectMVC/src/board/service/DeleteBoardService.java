package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// 삭제 기능 제공

// BoardCheckHelper 클래스를 이용하여, 게시글 존재 여부와 암호 일치 여부를 확인 하고, 암호가 일치하면 BoardDao.delete()를 이용해서 삭제!!
public class DeleteBoardService {
	
	private static DeleteBoardService instance = new DeleteBoardService();
	public static DeleteBoardService getInstance() {
		return instance;
	}
	private DeleteBoardService() {

	}

	public void deleteBoard(DeleteRequest deleteRequest) throws BoardNotFoundException {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				//BoardCheckHelper checkHelper = new BoardCheckHelper();
				// 삭제할 게시글이 존재하는지의 여부와 암호가 일치하는지 확인
				//checkHelper.checkExistsAndPassword(conn, deleteRequest.getBoardId(), deleteRequest.getPassword());
	
				BoardDao boardDao = BoardDao.getInstance();
				boardDao.delete(conn, deleteRequest.getIdx());
			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		/*} catch (BoardNotFoundException e) {
			JdbcUtil.rollback(conn);
			throw e;*/
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
			}
			JdbcUtil.close(conn);
		}
		
	}
}
