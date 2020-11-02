package oop.basic2;

//선수정보 	= 이름 + 종목 + 금메달수 + 은메달수 + 동메달수
//			= String + String + int + int + int
public class PlayerData {
	String name;
	String type;
	int gold;
	int silver;
	int bronze;
	
	//메모장처럼 코드에 이름을 붙여 저장할 수 있는 영역
	// = 메소드(method)
	// = print라는 이름으로 생성
	// = void나 ()는 현재는 설명할 수 없음(차차 배움)
	// = 메소드에서는 자기자신을 의미하는 단어로 this라는 키워드가 제공됨
	void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("종목 : "+this.type);
		System.out.println("금메달 : "+this.gold+"개");
		System.out.println("은메달 : "+this.silver+"개");
		System.out.println("동메달 : "+this.bronze+"개");
	}
	
	//정보 설정(초기화) 코드를 저장할 메소드 생성
	// = 그때그때 다른 값으로 데이터가 초기화 되어야 함
	// = 이 문제를 해결하기 위해서는 "외부" 데이터를 전달받아야 함
	// = 매개변수 (준비물) 이라고 부른다
	// = 이 메소드는 실행하려면 5개의 데이터가 필요
	void info(String a, String b, int c, int d, int e) {
		this.name = a;
		this.type = b;
		this.gold = c;
		this.silver = d;
		this.bronze = e;
	}
	
}