package oop.method2;

//목표 : 하나씩 설정할 수 있도록 메소드를 구현
public class Student {
	String name;
	int score;
	
	//초기화 메소드를 변수 하나당 하나씩 생성 - Setter 메소드
	// - name을 설정하는 메소드라면 이름이 set + name = setName 이다
	// - score를 설정하는 메소드라면 이름이 set + score = setScore 이다
	void setName(String name) {
		this.name = name;
	}
	void setScore(int score) {
		if(score >= 0 && score <= 100) {
			this.score = score;
		}
	}
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("점수 : "+this.score+"점");
	}
}