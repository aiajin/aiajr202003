package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;

// [답변 쓰기 로직 구현 (답변이라면 상위글의 ref,step,low를 받아서 db내의 같은 ref 중에서 자기보다 큰 step값들을 1씩 증가시킨다!!)]
/*  1. 답변 달 부모글이 있는지 체크 (없으면 익셉션 발생)
    2. 답변 저장 하기 전 update (db내의 같은 ref 중 자기보다 큰 step의 step 값을 1 증가시킨다.)
    3. 답변 저장 (받아온 상위글의 step+1, low+1 한 값을 저장)
 */
public class ReplyBoardService {
	
	private static ReplyBoardService instance = new ReplyBoardService();
	public static ReplyBoardService getInstance() {
		return instance;
	}
	private ReplyBoardService() {
	}


	public Board reply(ReplyingRequest replyingRequest) throws BoardNotFoundException {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
				BoardDao boardDao = BoardDao.getInstance();
				//[1] 답변 달 부모글 있는지 체크
				//부모글 Board 객체 구함
				Board parent = boardDao.selectById(conn, replyingRequest.getParentBoard_idx());
				
				try {
					checkParent(parent, replyingRequest.getParentBoard_idx());
					
				// @@ 답변 달 부모글이 없어서 익셉션이 발생되면, 트랜잭션을 롤백하고 해당 익셉션을 재발생시킴
				} catch (Exception e) {
					JdbcUtil.rollback(conn);
					// 부모 글이 없다면 BoardNotFoundException
					if (e instanceof BoardNotFoundException) {
						throw (BoardNotFoundException) e;
					}
				} // end try 2 
				
				//[2] 답변 저장 하기 전 update
//System.out.println("replyingRequest.getStep(): "+ replyingRequest.getStep());				
//System.out.println("replyingRequest.getRef(): "+ replyingRequest.getRef());

				boardDao.reply_before_update(conn, replyingRequest.getStep(), replyingRequest.getRef());
//System.out.println("reply_before_update 실행완료");

				//[3] 답변 저장
				Board board = new Board();
				
				board.setTitle(replyingRequest.getTitle());
				board.setContent(replyingRequest.getContent());
				board.setRef(replyingRequest.getRef());
				board.setStep(replyingRequest.getStep()+1);
				board.setLow(replyingRequest.getLow()+1);
				board.setWrite_id(replyingRequest.getWrite_id());
				board.setWrite_name(replyingRequest.getWrite_name());
				board.setWriteday(new Date());			
				
				int board_idx = boardDao.reply_insert(conn, board);
	
				if (board_idx == -1) {
					throw new RuntimeException("DB 삽입 실패: " + board_idx);
				}
			conn.commit();
			
			board.setIdx(board_idx);
			return board;
			
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException("DB 에러: " + e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					
				}
			}
			JdbcUtil.close(conn);
		} // end try1
		
	}

	private void checkParent(Board parent, int parentBoard_idx) throws BoardNotFoundException {
		if (parent == null) {
			throw new BoardNotFoundException("부모글이 존재하지 않음: " + parentBoard_idx);
		}
	}

}
