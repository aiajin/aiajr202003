package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// [게시글 읽기 기능 제공 (BoardDao 를 이용해서 게시글 데이터를 읽어오고, 게시글이 존재할 경우 조회수 증가)]

/* 게시글 조회 화면을 보여주기 위해 사용되는 readBoard() 메서드와 게시글 수정화면에서 게시글 원문을 보여주기 위해 사용되는 getBoard() 메서드를 제공함
 	글 수정 폼에서 보여줄 게시글 제목/내용을 출력하기 위한 Board 객체를 구한다.
*/ 	
public class ReadBoardService {
	
	private static ReadBoardService instance = new ReadBoardService();
	public static ReadBoardService getInsteance() {
		return instance;
	}
	private ReadBoardService() {
		
	}
	
	// 게시글을 조회하고, 조회수를 중가시키는 메서드. 내부적으로 selectBoard() 호출 (이 때 selectBoard()의 두번째 파라미터인 increaseCount의 값으로 true를 전달함으로써 조회수를 증가시킴)
	public Board readBoard(int board_idx) throws BoardNotFoundException {
		return selectBoard(board_idx, true);
	}
	
	// @@ 실제 게시글 조회 기능을 구현한 메서드
	private Board selectBoard(int board_idx, boolean increaseCount) throws BoardNotFoundException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			BoardDao boardDao = BoardDao.getInstance();
			//BoardDao를 이용해서 지정한 idx의 Board를 구한다.
			Board board = boardDao.selectById(conn, board_idx);
			
			// 1. 게시글이 없다면, 익셉션 발생
			if (board == null) {
				throw new BoardNotFoundException("게시글이 존재하지 않음: " + board_idx);
			}
			
			// 2. 게시글이 있다면, 조회수 증가. 화면에 보여질 조회수도 1증가 시킨다 ??			
			if (increaseCount) {
				boardDao.increaseReadCount(conn, board_idx);
				board.setReadnum(board.getReadnum() + 1);
			}
			return board;
			
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	// 게시글만 조회하고 조회수는 증가시켜주지 않는 메서드 (수정화면을 보여줄 때는 조회수 증가되면 안되므로, false)
	public Board getBoard(int board_idx) throws BoardNotFoundException {
		return selectBoard(board_idx, false);
	}
		
}


