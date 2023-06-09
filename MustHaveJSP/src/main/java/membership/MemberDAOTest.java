package membership;

import java.util.ArrayList;

public class MemberDAOTest {

	// 인스턴스 생성자 없이 호출이 가능한 것이 static
	// 즉 static이 없으면 객체가 생성이 안되기에 에러가 생김
	private static MemberDAO memberDAO = new MemberDAO();

	private static void printAllMemberDTO() {
		// 모든 맴버 데이터 가져와서 출력
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTOs();
		for (MemberDTO m : list) {
			System.out.println(m);
		}
	}

	public static void insertMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hone");
		memberDTO.setPass("1234");
		memberDTO.setName("홍길동");
		memberDAO.insertMemberDTO(memberDTO);
	}
	
	public static void updateMemberDTO() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("Hone");
		memberDTO.setPass("12345");
		memberDTO.setName("홍길동쿠");
		memberDAO.updateMemberDTO(memberDTO);
	}

	public static void deleteMemberDTO() {
		
		memberDAO.deleteMemberDTO("Hone");
	}
	
	public static void main(String[] args) {
		System.out.println("Basic" + "-".repeat(80));
		printAllMemberDTO();

		System.out.println("insert" + "-".repeat(80));
		
		insertMemberDTO();
		printAllMemberDTO();
		
		System.out.println("update" + "-".repeat(80));	
		
		updateMemberDTO();
		printAllMemberDTO();
		
		System.out.println("delete" + "-".repeat(80));
		
		deleteMemberDTO();
		printAllMemberDTO();
		
		System.out.println("-".repeat(80));
		
		
		

//		// Test getMemberDTO()
//		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
//		System.out.println(memberDTO);


	}

}
