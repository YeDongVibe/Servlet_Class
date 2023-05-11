package intro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet01 extends HttpServlet {
	//HttpServlet이라는 class에서 상속을 받아야지 Hosting 및 구현이 가능.
	//이 영역에 선언부(스크립트 요소)가 입력된다.
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service : 이 매서드를 호출하여 실행. 즉 메인class가 없어도 실행이 가능.
		//현재 이 영역에 코트부(스크립틀릿)가 입력된다.
		System.out.println("MyServlet01");
	}
}
