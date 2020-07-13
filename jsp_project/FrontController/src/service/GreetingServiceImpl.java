package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// viewpage
		String viewPage = "/WEB-INF/views/view01.jsp";
		
		// 응답 데이터 처리
		String  result = "안녕하세요";
		
		// request 속성에 저장
		request.setAttribute("result", result);
		
		
		return viewPage;
	}

}








