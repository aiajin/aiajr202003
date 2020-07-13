package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController2 extends HttpServlet{

	// 1. Http의 요청을 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 2. 사용자 요청 파악 : request 객체를 이용
		//    request.getParameter(name)
		//    request.getRequestURL()
		//    request.getRequestURI() ★★★★★
		//String type = request.getParameter("type");
		String type = null;
		String command = request.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(request.getContextPath()));
		
		// /fc/date
		if(  command.indexOf(request.getContextPath()) == 0 ) {
			type = command.substring(request.getContextPath().length());
		}
		
		
		System.out.println("요청 파악 : " + type);
		
		// 3. 핵심 처리 : 기능 수행
		Object resultObj = null;
		String page = "/WEB-INF/views/simple_view.jsp";
		
		// http://localhost:8080/fc/greeting
		// http://localhost:8080/fc/date
		if(type == null || type.equals("/greeting") ) {
			resultObj = "안녕하세요";
			page="/WEB-INF/views/view01.jsp";
		} else if(type.equals("/date")) {
			resultObj = new Date();
			page="/WEB-INF/views/view02.jsp";
		} else if(type.equals("/")) {
			page = "/WEB-INF/views/index.jsp";
		} else {
			resultObj = "Invalid Type";
		}
		System.out.println("핵심 처리 결과 : " + resultObj);
		
		// 4. 결과 데이터를 속성에 저장 : view 페이지에 공유(전달)
		request.setAttribute("result", resultObj);
		System.out.println("속성에 저장");
		
		// 5. 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
	}

	
	
	
}
