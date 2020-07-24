package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// 게시글 수정 기능 제공
public class UpdateBoardService {
	private static UpdateBoardService instance = new UpdateBoardService();

	public static UpdateBoardService getInstance() {
		return instance;
	}

	private UpdateBoardService() {

	}

	public Board update(UpdateRequest updateRequest) throws BoardNotFoundException {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				//BoardCheckHelper checkHelper = new BoardCheckHelper();
				// 게시글 존재 여부와 암호가 일치하는 여부 확인
				//checkHelper.checkExists(conn, updateRequest.getIdx());
	
				// UpdateRequest로 부터 Board 생성
				Board updatedBoard = new Board();
				updatedBoard.setIdx(updateRequest.getIdx());
				updatedBoard.setTitle(updateRequest.getTitle());
				updatedBoard.setContent(updateRequest.getContent());
	
				BoardDao boardDao = BoardDao.getInstance();
				int updateCount = boardDao.update(conn, updatedBoard);			
	
				if (updateCount == 0) {
					throw new BoardNotFoundException("게시글이 존재하지 않음: "+ updateRequest.getIdx());
				}
				
				// 수정된 Board 객체 구함
				Board board = boardDao.selectById(conn, updateRequest.getIdx());
			conn.commit();
			
			return board;

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException("DB 에러: " + e.getMessage(), e);
		} catch (BoardNotFoundException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
				JdbcUtil.close(conn);
			}
		}	//end try
		
	}
}
