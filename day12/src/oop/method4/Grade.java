package oop.method4;

//성적 클래스 = 이름 + 학년 + 국어점수 + 영어점수 + 수학점수 + 총점 + 평균
public class Grade {
	String name;
	int level;
	int korean;
	int english;
	int math;
	
	void setName(String name) {
		this.name = name;
	}
	void setLevel(int level) {
		if(level < 1 || level > 3) {
			return;
		}
		this.level = level;
	}
	void setKorean(int korean) {
		if(!(korean >= 0 && korean <= 100)) {
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
		if(math >= 0 && math <= 100) {
			this.math = math;
		}
	}
	
	void info(String name, int level, int korean, int english, int math) {
		this.setName(name);
		this.setLevel(level);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	void print() {
		System.out.println("## 학생 정보 ##");
		System.out.println("이름 : "+this.name);
		System.out.println("학년 : "+this.level);
		System.out.println("국어 : "+this.korean);
		System.out.println("영어 : "+this.english);
		System.out.println("수학 : "+this.math);
		//총점, 평균 출력
		int total = this.korean + this.english + this.math;
		float avg = total / 3.0f;
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
	}
}
