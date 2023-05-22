package membership;

import java.util.ArrayList;

public class MemberDAOTest {
	
	//인스턴스 생성자 없이 호출이 가능한 것이 static
	//즉 static이 없으면 객체가 생성이 안되기에 에러가 생김
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static void main(String[] args) {

		
		//Test getMemberDTO()
		MemberDTO memberDTO = memberDAO.getMemberDTO("test1", "1111");
		System.out.println(memberDTO);
		
		
		
		//모든 맴버 데이터 가져와서 출력
		ArrayList<MemberDTO> list = memberDAO.getAllMemberDTOs();
		for(MemberDTO m : list) {
			System.out.println(m);
		}
		
		//신규 회원 객체를 만들어서 추가
		ArrayList<MemberDTO> list1 = memberDAO.insertMemberDTO();
		for(MemberDTO m : list1) {
			System.out.println(m);
		}

	}

}
