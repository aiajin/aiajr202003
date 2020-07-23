package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import board.dao.BoardDao;
import board.model.Board;
import board.model.BoardListModel;

// BoardDao 로 부터 요청한 페이지에 해당하는 게시글 목록을 읽어와 BoardListModel 객체를 리턴!!

/* [ListBoardService]: 요청한 페이지 번호에 포함된 메시지 목록 구하기
 - BoardDao 클래스의 selectCount(), select() 메서드를 이용해 
	사용자가 요청한 페이지에 해당하는 게시글 목록을 구한 뒤,
	BoardListModel 객체에 목록을 담아서 리천한다!!
*/
public class ListBoardService {

	private static ListBoardService instance = new ListBoardService();
	
	public static ListBoardService getInstance() {
		return instance;
	}
	
	//한 페이지에 보여줄 글 개수
	public static final int COUNT_PER_PAGE = 10;
	
	public BoardListModel getBoardList(int requestPageNumber) {
		if( requestPageNumber < 0 ) {
			throw new IllegalArgumentException("page number < 0 : "
				+ requestPageNumber);
		}
		
		BoardDao boardDao = BoardDao.getInstance();
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			//전체 글 개수 
			int totalBoardCount = boardDao.selectCount(conn);
			
			// @@ 전체 게시글=0 이라면, BoardListModel 객체 리턴
			if( totalBoardCount == 0 ) {
				return new BoardListModel();
			}
			
			//calculateTotalPageCount() 메서드 호출해서, 전체 페이지 개수 구함
			int totalPageCount = calculateTotalPageCount(totalBoardCount);
			
			//요청한 페이지 번호를 이용해서, 읽어올 행의 시작 행과 끝 행에 속하는 board 목록을 구한다.
			int firstRow = (requestPageNumber - 1) * COUNT_PER_PAGE + 1;
			int endRow = firstRow + COUNT_PER_PAGE - 1;
			
			if (endRow > totalBoardCount) {
				endRow = totalBoardCount;
			}
			
			// BoardDao.select() 메서드 이용해서, 시작 행과 끝 행에 속하는 Board 목록을 구한다.
			List<Board> boardList = boardDao.select(conn, firstRow, endRow);
			
			// Board 목록. 요청 페이지 번호, 전체 페이지 개수,  시작 행, 끝 행을 이용해서 BoardListModel 객체를 생성한 뒤 리턴
			BoardListModel boardListView = new BoardListModel( boardList, requestPageNumber, totalPageCount, firstRow, endRow);
			return boardListView;
			
			
		} catch (SQLException e) {
			throw new RuntimeException("DB 에러: "+e.getMessage(), e);
		} finally { JdbcUtil.close(conn);
		
		} //end try
		
	}
	
	// 전체 게시글 개수로부터 전체 페이지 개수를 구해주는 메서드
	private int calculateTotalPageCount(int totalBoardCount) {
		if( totalBoardCount == 0 ) {
			return 0;
		}
		int pageCount = totalBoardCount / COUNT_PER_PAGE;
		if( totalBoardCount % COUNT_PER_PAGE > 0 ) {
			pageCount++;
		}
		return pageCount;
	}
}

