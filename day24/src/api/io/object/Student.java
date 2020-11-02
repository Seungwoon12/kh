package api.io.object;

import java.io.Serializable;

//이 클래스가 객체 입출력을 위한 "자격"을 획득하려면 반드시 상속을 받아야 한다
//- java.io.Serializable 인터페이스(마킹 인터페이스 : 자격 부여를 위한 인터페이스)
//- 상속을 받고나면 "버전"을 설정하라는 경고가 나온다
//- 클래스의 변경을 감지할 수 있는 장치
//- 버전을 바꾸면 이전 버전에서 저장한 객체들은 모두 사용이 불가능해짐(강제 업데이트)
//- 객체에 있는 많은 정보중에 저장하고 싶지 않은 항목이 있을 수도 있다.
//- 입출력 제외 키워드인 transient를 붙여 출력에서 제외시킬 수 있다.
public class Student implements Serializable{
	/**
	 * serialVersionUID는 이 클래스의 버전
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient int score;//이 항목은 출력에서 제외하겠다
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}