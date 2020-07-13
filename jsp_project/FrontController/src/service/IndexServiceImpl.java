package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// viewpage
		String viewPage = "/WEB-INF/views/index.jsp";
		return viewPage;
	}

}








