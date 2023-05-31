package file_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class ObjectMain2 {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	public void serialize1(List<MemberDTO> list, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			
			for (MemberDTO m : list) {
				oos.writeObject(m);
			}
		}
	}

	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		// FileInputStream을 만든다음 ObjectInputStream를 만들어 각 내용을 기입
		try (FileInputStream fis = new FileInputStream(fileName); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			// ObjectInputStream에만 아래의 객체가 존재함.(read/wirteObject 매서드)
			m = (MemberDTO) ois.readObject();
		}
		return m;
	}
	
	public List<MemberDTO> deserialize1(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		List<MemberDTO> list = new ArrayList<>();
		// FileInputStream을 만든다음 ObjectInputStream를 만들어 각 내용을 기입
		try (FileInputStream fis = new FileInputStream(fileName); 
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
//			while((m = (MemberDTO)ois.readObject()) != null) {
//			// ObjectInputStream에만 아래의 객체가 존재함.(read/wirteObject 매서드)
//			list.add((MemberDTO)m);
//			}
			for(int i = 0; i < 4; i++) {
				m = (MemberDTO) ois.readObject();
				list.add((MemberDTO)m);
			}
		}
		return list;
	}

	public static void main(String[] args) throws Exception {

		ObjectMain om = new ObjectMain();

		List<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("100", "123", "홍길동", "2023-01-01"));
		list.add(new MemberDTO("200", "123", "홍이동", "2023-01-01"));
		list.add(new MemberDTO("300", "123", "홍삼동", "2023-01-01"));
		list.add(new MemberDTO("400", "123", "홍사동", "2023-01-01"));

		om.serialize(list, "testObject.dat");

		list = om.deserialize1("testObjects.dat");
		for(MemberDTO m : list)
			System.out.println(m);
	}
}
