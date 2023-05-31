package file_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import membership.MemberDTO;

public class ObjectMain {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		//FileInputStream을 만든다음 ObjectInputStream를 만들어 각 내용을 기입
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			//ObjectInputStream에만 아래의 객체가 존재함.(read/wirteObject 매서드)
			m = (MemberDTO)ois.readObject();
		}		
		return m;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain om = new ObjectMain();

		om.serialize(new MemberDTO("100", "123", "홍길동", "2023-01-01"), "testObject.dat");
		
		MemberDTO m = om.deserialize("testObject.dat");
		System.out.println(m);
	}
}
