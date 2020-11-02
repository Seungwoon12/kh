package oop.constructor1;

public class Student {
	private String name;
	private int score;
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
		if(score < 0 || score > 100) {
			return;
		}
		this.score = score;
	}
	
	//원래 사용하던 info를 생성자로 변경해서 사용
	// - 생성자는 void와 같은 반환형을 적을 수 없고
	// - 이름이 클래스 이름과 동일하다(반드시)
	// - 메소드와 비슷하게 생겼지만 "생성"방식을 정하는 용도로 쓰이는 구문
	public Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	public void print() {
		System.out.println(this.name);
		System.out.println(this.score);
	}
}
