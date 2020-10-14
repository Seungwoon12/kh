package oop.method1;

public class Student {
	
	String name;
	int score;



	void info(String name, int score) {
		this.name = name;
		if(score >= 0 && score <= 100) {
			this.score = score;
		}
	
	}
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("점수 : "+this.score);
	}
	
	
	
	
}