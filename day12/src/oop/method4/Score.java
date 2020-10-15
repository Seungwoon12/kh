package oop.method4;

public class Score {
	String name;
	int grade;
	int korean;
	int english;
	int math;

	
	void setName(String name) {
		this.name = name;
	}	
	void setGrade(int grade) {
		if(grade < 1 || grade > 3) {
			return;		
		}
		this.grade = grade;
	}
	void setKorean(int korean) {
		if(korean < 0 || korean > 100) {
			return;
		}
		this.korean = korean;
	}	
	void setEnglish(int english) {
		if(english < 0 || english > 100) {
			return;
		}
		this.english = english;
	}	
	void setMath(int math) {
		if(math < 0 || math > 100) {
			return;
		}
		this.math = math;
	}
		
	void info(String name, int grade, int korean, int english, int math) {
		this.setName(name);
		this.setGrade(grade);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
		
	}
	
	
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("학년 : "+this.grade);
		System.out.println("국어점수 : "+this.korean);
		System.out.println("영어점수 : "+this.english);
		System.out.println("수학점수 : "+this.math);
		int total = this.korean + this.english + this.math;
		float average = total / 3.0f;
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+average);
	}
	
	
}
