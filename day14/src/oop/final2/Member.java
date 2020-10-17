package oop.final2;

public class Member {
	private final String id;
	private String password;
	private String nickname;
	private int point;
	
	public Member(String id, String password) {
		//둘 중 택1
		//this(id, password, null);
		this.id = id;
		this.setPassword(password);
	}
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.setPassword(password);
		this.setNickname(nickname);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getId() {
		return id;
	}
	
	public void print() {
		System.out.println("아이디  : "+this.id);
		System.out.println("비밀번호 : "+this.password);
		System.out.println("닉네임 : "+this.nickname);
		System.out.println("포인트 : "+this.point);
	}
}