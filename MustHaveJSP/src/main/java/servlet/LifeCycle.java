package servlet;


import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/13Servlet/LifeCycle.do")

public class LifeCycle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//servlet 호출되자말자 한번 실행하는 매서드
	@PostConstruct
	public void myPostConstruct() {
		System.out.println("myPostConstruct() 호출");
	}
	//servlet 호출되자말자 한번 실행하는 매서드
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service() 호출");
		//super.service~~를 주석 처리하면 doget이든 dopost든 실행이 되지 않는다.
		//service에서 do로 넘어가기 때문
		super.service(req, resp);
		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet () 호출");
		//req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost () 호출");
		//req.getRequestDispatcher("/13Servlet/LifeCycle.jsp").forward(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destory() 호출");
	}
	@PreDestroy
	public void myPreDestroy() {
		System.out.println("myPreDestroy() 호출");
	}
 	
}
