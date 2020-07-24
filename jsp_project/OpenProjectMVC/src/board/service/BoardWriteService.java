package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import app.util.JdbcUtil;
import board.dao.BoardDao;
import board.model.Board;
import board.model.WriteRequest;


public class BoardWriteService implements Service {

	private static BoardWriteService instance = new BoardWriteService();

	public static BoardWriteService getInstance() {
		return instance;
	}

	private BoardWriteService() {

	}
	
	BoardDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		WriteRequest writeRequest = new WriteRequest(
				request.getParameter("title"), 
				request.getParameter("content"), 
				Integer.parseInt(request.getParameter("writer_idx")), 
				request.getParameter("writer_id"), 
				request.getParameter("writer_name"));
		
		
		Board board = writeRequest.toBoard();

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = BoardDao.getInstance();

			conn.setAutoCommit(false);
			int board_idx = dao.insert(conn, board);

			if (board_idx == -1) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("DB ���� ����: " + board_idx);
			}

			conn.commit();

			//board.setIdx(board_idx);

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException("DB ����: " + e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {

				}
			}
			JdbcUtil.close(conn);
		} // end try
		return "/WEB-INF/views/board/write.jsp";
	}

}
