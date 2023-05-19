package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCConnect {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pw = "1234";

	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, id, pw);
	}

	public static void main(String[] args) throws Exception {
		JDBCConnect jdbcConnect = new JDBCConnect();
		Connection con = jdbcConnect.getConnection();

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from board");

		try {
			while (rs.next()) {
				System.out.println(String.format("%s. %s, %s", rs.getString("title"), rs.getString("content"),
						rs.getString("id")));
			}
			System.out.println();
			
			ResultSet rs1 = st.executeQuery("select * from member");

			while (rs1.next()) {
				System.out.println(
						String.format("%s. %s, %s", rs1.getString("id"), rs1.getString("pass"), rs1.getString("name")));
			}
		}

		catch (SQLException e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				rs.close();
			if (rs1 != null)
				rs1.close();
			if (st != null)
				st.close();
		}

		con.close();

	}

}
