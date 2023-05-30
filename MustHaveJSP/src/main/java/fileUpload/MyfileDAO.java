package fileUpload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JDBCConnect;

public class MyfileDAO extends JDBCConnect {

	public int insertFile(Connection con, MyfileDTO dto) {
		int applyResult = 0;
		PreparedStatement psmt = null;
		try {
			String query = "Insert into myfile (name,title,cate,ofile,sfile) values (?, ?, ?, ?, ?);";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1,dto.getName());
			psmt.setString(2,dto.getTitle());
			psmt.setString(3,dto.getCate());
			psmt.setString(4,dto.getOfile());
			psmt.setString(5,dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("다시하라");
			e.printStackTrace();
		}finally {

			try {
	        	if(psmt != null) psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	
    }
		return applyResult;
	}
	
}
