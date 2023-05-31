package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(urlPatterns = "/13Servlet/MemberAuth.mvc", initParams = {
		@WebInitParam(name = "admin_id", value = "nakja") })
public class MemberAuth extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MemberDAO dao;

	@Override
	public void init() throws ServletException {
		
		//application 내장 객체 얻기
		ServletContext application = this.getServletContext();
		
		//web.xml 에서 DB 연결 정보 얻기
		String driver = application.getInitParameter("MySQLDriver");
		String conenctURL = application.getInitParameter("MySQLURL");
		String oId = application.getInitParameter("MySQLId");
		String oPass = application.getInitParameter("MySQLPw");

		dao = new MemberDAO(driver, conenctURL, oId, oPass);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_id = this.getInitParameter("admin_id");

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		MemberDTO memberDTO = dao.getMemberDTO(id, pass);

		String memberName = memberDTO.getName();
		if (memberName != null) {
			req.setAttribute("authMessage", memberName + "회원님 방가방가^^*");
		} 
		else {
			if (admin_id.equals(id)) {
				req.setAttribute("authMessage", admin_id + "는 최고 관리자입당");
			} else {
				req.setAttribute("authMessage", "귀하는 회원 아님");
			}
		}
		req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);
		
		//web-INF는 내부적으로 사용하는 파일이라서 외부에서 사용불가
		//req.getRequestDispatcher("/WEB-INF/view/MemberAuthView.jsp").forward(req, resp);
	}

//	@Override
//	public void destroy() {
//		dao.close();
//	}
}
