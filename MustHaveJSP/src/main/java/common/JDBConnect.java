package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnect {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/musthave";
			String id = "musthave";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 연결 성공(기본생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void close() {
//		try {
//			if(rs != null) {
//				rs.close();
//			}
//			if(stmt != null) {
//				stmt.close();
//			}
//			if(psmt != null) {
//				psmt.close();
//			}
//			if(con != null) {
//				con.close();
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	public static void main(String[] args) {
		Connection con  = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		//JDBConnect jdbConnect = new JDBConnect();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "musthave", "1234");
			
			st = con.createStatement();//statement라는 클래스의 객체를 만들어서 st라는 참조변수에 할당함.
			rs = st.executeQuery("Select id, pass, name from member order by id");//executeQuery라는 매서드러 데이터베이스에 select~~라는 query를 날림.
			
			
			while(rs.next()) {//rs라는 참조변수가 결과값을 저장함. //cursor processing하는 듯한 역할
				System.out.println(String.format("%s. %s, %s", //String.format이라는 것을 통해 String형태의 값을 댕겨옴. //%s : 문자열, %c : 문자 1개, %d : int, %l : long, %f : float
						rs.getString("id"), rs.getString("pass"), rs.getString("name")));
				//get~를 통해 각 필드명을 입력하여 데이터를 가져옴. 
			}
			
			rs1 = st.executeQuery("Select title,content,id from board");
			while(rs1.next()) {//rs라는 참조변수가 결과값을 저장함. //cursor processing하는 듯한 역할
				System.out.println(String.format("%s. %s, %s", //String.format이라는 것을 통해 String형태의 값을 댕겨옴. //%s : 문자열, %c : 문자 1개, %d : int, %l : long, %f : float
						rs1.getString("title"), rs1.getString("content"), rs1.getString("id")));
				//get~를 통해 각 필드명을 입력하여 데이터를 가져옴. 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if(rs1 != null) rs1.close();//null이 아니면 닫아라.
				if (st != null) st.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  

	}

}
