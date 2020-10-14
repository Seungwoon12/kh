package oop.method2;

public class Student {
	String name;
	int score;
	
	
	void setName(String name) {
		this.name = name;
		
	}
	
	void setScore(int score) {
		if(score >= 0 && score <= 100) {
			this.score = score;
		}	
	}
	
	void print() {
		System.out.println("이름 : "+this.name );
		System.out.println("점수 : "+this.score+"점");
	}
}
