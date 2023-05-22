package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCConnection;

public class MemberDAO extends JDBCConnection {

	// default 생성자 만들기
	public MemberDAO() {
	}

	// executeQuery문 사용
	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환합니다.
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원 정보 DTO 객체 생성
		String query = "SELECT * FROM member WHERE id=? AND pass=?"; // 쿼리문 템플릿

		Connection con = getConnection();
		if (con == null) {
			return null;
		}

		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, upass); // 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery(); // 쿼리문 실행

			// 결과 처리
			if (rs.next()) {
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return dto; // DTO 객체 반환
	}

	public ArrayList<MemberDTO> getAllMemberDTOs() {

		Connection con = getConnection();
		if (con == null) {
			return null;
		}

		Statement st = null;
		ResultSet rs = null;

		ArrayList<MemberDTO> list = null;

		try {
			// 쿼리 실행
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM member");

			list = new ArrayList<>();

			// 결과 처리
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;
	}

	// executeUpdate 사용
	public int insertMemberDTO(MemberDTO member) {

		String query = "insert into member (id, pass, name) values (?,?,?)";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}

		PreparedStatement psmt = null;
		int ret = 0;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, member.getId()); // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, member.getPass()); // 쿼리문의 두 번째 인파라미터에 값 설정
			psmt.setString(3, member.getName()); // 쿼리문의 두 번째 인파라미터에 값 설정
			ret = psmt.executeUpdate(); // 쿼리문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return ret; // DTO 객체 반환
	}

	public int updateMemberDTO(MemberDTO member) {
		String query = "Update member set pass=?, name=? where id = ?";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}

		PreparedStatement psmt = null;
		int ret = 0;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, member.getPass()); // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, member.getName()); // 쿼리문의 두 번째 인파라미터에 값 설정
			psmt.setString(3, member.getId()); // 쿼리문의 두 번째 인파라미터에 값 설정
			ret = psmt.executeUpdate(); // 쿼리문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return ret; // DTO 객체 반환

	}

	public int deleteMemberDTO(String uid) {
		String query = "delete from member where id = ?";

		Connection con = getConnection();
		if (con == null) {
			return 0;
		}

		PreparedStatement psmt = null;
		int ret = 0;

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid); // 쿼리문의 첫 번째 인파라미터에 값 설정
			ret = psmt.executeUpdate(); // 쿼리문 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return ret; // DTO 객체 반환
	}

}
