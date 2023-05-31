package membership;

import java.io.Serializable;

//직렬화시키기 위해 Serializable을 implements함.
public class MemberDTO implements Serializable{
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
	public static final long serialVersionUID = 1L;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id, String pass, String name, String regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	//맴버 변수별 게터와 세터
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegidate() {
		return regidate;
	}

	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}

	
}
