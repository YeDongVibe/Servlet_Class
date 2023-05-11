package sec;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class gugudan extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	// 파라미터 : localhost8080/~~~/~~&num=3에서 num=3이라는 것을 의미.
	// doGet : get방식으로 요청하기 위해 사용.
	// HttpServletRequest req : 서버에 요청할때 필요한 모든 정보<num=3>를 담김.
	// HttpServletResponse resp :
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset = utf-8");

		String type = req.getParameter("type");
		String snum = req.getParameter("num"); // req.getParameter : 정보를 읽음.

		int num = 2; // num을 입력 안할시 기본값으로 2단 출력
		if (snum != null) {
			// 입력하게 되면 num값을 출력함.
			num = Integer.parseInt(snum);
		}

		try (PrintWriter out = resp.getWriter();) {
			if (type == null || type.equals("list")) {

				out.println("<h2>구구단 타입 (Servlet)</h2>");

				out.println(String.format("<h3>%d단 입니다.</h3>", num));

				for (int i = 1; i < 10; i++) {
					// int res = (i+1) * i;
					// out.println("<ul>i+1 * i = res</ul>");

					out.println(String.format("<li>%d * %d = %d</li>", num, i, i * num));
				}

			} else {
				out.println("<table border = \"1\">");
				out.println("<h2>구구단 타입 (Servlet)</h2>");

				out.println(String.format("<h3>%d단 입니다.</h3>", num));

				for (int i = 1; i < 10; i++) {
					// int res = (i+1) * i;
					// out.println("<ul>i+1 * i = res</ul>");

					out.println(String.format("<tr><td>%d * %d = %d</td></tr>", num, i, i * num));
				}
				out.println("</table>");

			}

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

//http://localhost:8080/ServletStudy/gugudan?num=숫자 : 숫자 입력시 해당 구구단 출력
//http://localhost:8080/ServletStudy/gugudan?num=9&type=~~&~~~

//get 방식 : url 뒤에 파라미터를 붙여서 가는 방식
//post 방식 : 우리가 요청하는 것을 숨겨서 가는 방식