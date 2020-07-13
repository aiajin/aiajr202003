package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestService implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		String page = "/WEB-INF/views/test.jsp";
		
		request.setAttribute("name", "손흥민");
		
		return page;
	}

}
