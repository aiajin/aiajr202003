package board.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// [게시글 목록 화면을 구성하는 데 필요한 정보를 저장!! 게시글(Board) 목록, 요청 페이지 번호, 전체 페이지 개수 등의 정보를 제공]

// [BoardListModel]: 요청한 페이지 번호, 요청한 페이지의 메시지 목록, 전체 메시지 개수, 페이지 개수, 페이지 당 보여줄 메시지 개수 등의 정보를 담는 클래스
public class BoardListModel {

	private List<Board> boardList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;	
	private int endRow;
	
	/* <생성자> 
	 - 메시지 목록(boardList), 메시지 전체 개수(totalPageCount), 요청 페이지 번호(requestPage) 
	   전체 메시지 중에서 현재 메시지 목록의 시작 행과 끝 행을 전달받는다. 
	*/
	public BoardListModel() {
		this(Collections.<Board> emptyList(), 0, 0, 0, 0);
	}

	public BoardListModel(List<Board> boardList, int requestPageNumber, int totalPageCount, int startRow, int endRow) {
		this.boardList = boardList;
		this.requestPage = requestPageNumber;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public boolean isHasBoard() {
		return !boardList.isEmpty();
	}

	public int getRequestPage() {
		return requestPage;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}	
	
}

