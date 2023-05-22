package common;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class JDBCConnect {

	private String driver;
	private String url;
	private String id;
	private String pw;

	public JDBCConnect() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/musthave";
		id = "musthave";
		pw = "1234";
	}

	public JDBCConnect(String driver, String url, String id, String pw) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pw = pw;
	}

	public JDBCConnect(ServletContext app) {
		driver = app.getInitParameter("MySQLDriver");
		url = app.getInitParameter("MySQLURL");
		id = app.getInitParameter("MySQLId");
		pw = app.getInitParameter("MySQLPw");
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, id, pw);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
