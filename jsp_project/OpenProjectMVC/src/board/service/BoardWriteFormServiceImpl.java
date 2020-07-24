package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import app.util.JdbcUtil;
import board.dao.BoardDao;
import board.model.Board;
import board.model.WriteRequest;

public class BoardWriteFormServiceImpl implements Service {
	

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/board/writeForm.jsp";
	}


}
