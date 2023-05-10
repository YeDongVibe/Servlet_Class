package intro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myservlet03")
public class MyServlet03 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet03");
		//text/html을 하면 html의 헤더라인처럼 웹에 나타남.
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<h2>이것은 서블릿에서 출력하는 문서입니다. 잘보이나요~~~잘보이면 소리질럿!!!!</h2>");
		out.println("<h3>잘보이면 성공!축하포카포~~아주 잘하고 있어요^^굿굿베리 굿</h3>");
		out.close();
	}
}
