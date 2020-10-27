package api.collection2;

public class Member {
	private String id;
	private String password;
	public Member() {
		super();
	}
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void print() {
		System.out.println("id = "+id+", password = "+password);
	}
}