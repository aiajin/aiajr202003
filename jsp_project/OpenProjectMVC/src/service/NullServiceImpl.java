package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// viewpage
		String viewPage = "/WEB-INF/views/null.jsp";
		return viewPage;
	}

}








