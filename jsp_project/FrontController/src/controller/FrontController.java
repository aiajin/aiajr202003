package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DateServiceImpl;
import service.GreetingServiceImpl;
import service.IndexServiceImpl;
import service.NullServiceImpl;
import service.Service;

public class FrontController extends HttpServlet{
	
	private Map<String, Service> commands = new HashMap<String, Service>();

	@Override
	public void init() throws ServletException {
		
		commands.put("/", new IndexServiceImpl());
		commands.put("/index", new IndexServiceImpl());
		commands.put("/greeting", new GreetingServiceImpl());
		commands.put("/date", new DateServiceImpl());
		commands.put("null", new NullServiceImpl());
		
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

		Service service = commands.get(type);
		
		if(service == null) {
			service = commands.get("null");
		}
		

//		if(type.equals("/greeting") ) {
//			service = new GreetingServiceImpl();
//		} else if(type.equals("/date")) {
//			service = new DateServiceImpl();
//		} else if(type.equals("/") || type.equals("/index") ) {
//			service = new IndexServiceImpl();
//		} else {
//			service = new NullServiceImpl();
//		}
		
		String page = service.getViewPage(request, response);
		
	
		// 5. 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
	}


	// 1. Http의 요청을 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	
	
}
