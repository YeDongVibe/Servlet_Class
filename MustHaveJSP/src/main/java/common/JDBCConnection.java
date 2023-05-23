package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspWriter;

public class JDBCConnection {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pw = "1234";
	
	public JDBCConnection() {
		//기본생성자 만들기
	}

	public JDBCConnection(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;	
	}
	public JDBCConnection(ServletContext application) {
		driver = application.getInitParameter("MySQLDriver");
		url = application.getInitParameter("MySQLURL");
		id = application.getInitParameter("MySQLId");
		pw = application.getInitParameter("MySQLPw");
	}

	public Connection getConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public void closeConnection(Connection con) {
		try {
			if(con !=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeMemberToTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		
		try {
			out.println("<table border = \"1\">");
			//out.write("<table>");
			out.write("<tr>");
			out.write("<td align=center>id</td><td align=center>pass</td><td align=center>name</td><td align=center>regidate</td>");
			out.write("</tr>");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			
			while(rs.next()) {

				out.write("<tr>");
				out.write("<td align=center>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs.getString("pass")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs.getString("name")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs.getString("regidate")); out.write("</td>");
				out.write("</tr>");
				
			}
			out.write("</table>");

			out.println("<table border = \"1\">");
			//out.write("<table>");
			out.write("<tr>");
			out.write("<td align=center>title</td><td align=center>content</td><td align=center>id</td><td align=center>postdate</td>");
			out.write("</tr>");
			out.println("<br />");

			

			rs1 = st.executeQuery("select * from board");
			
			while(rs1.next()) {

				out.write("<tr>");
				out.write("<td align=center>"); out.write(rs1.getString("title")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs1.getString("content")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs1.getString("id")); out.write("</td>");
				out.write("<td align=center>"); out.write(rs1.getString("postdate")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs1 != null)
					rs1.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	
	public static void main(String[] args) throws Exception {
		JDBCConnection jdbcCon = new JDBCConnection();
		Connection con = jdbcCon.getConnection();
		
		con.close();

	}
	

}
