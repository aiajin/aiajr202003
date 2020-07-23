package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.Service;

public class BoardWriteFormService implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/board/writeForm.jsp";
	}

}
