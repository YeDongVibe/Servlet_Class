package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/musthave";
	private String id="musthave";
	private String pw="1234";
	
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pw);
	}

	public static void main(String[] args) throws Exception {
		JDBCConnect jdbcConnect = new JDBCConnect();
		Connection con = jdbcConnect.getConnection();
		
		con.close();

	}

}
