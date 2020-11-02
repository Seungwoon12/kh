package oop.basic2;

//프로그램을 구동시키기 위한 메인 메소드가 있는 클래스
public class Test01 {
	public static void main(String[] args) {
		//선수정보 3개 생성
		PlayerData p1 = new PlayerData();
		PlayerData p2 = new PlayerData();
		PlayerData p3 = new PlayerData();
		
		//정보 설정(초기화)
		p1.name = "김연아";
		p1.type = "피겨스케이팅";
		p1.gold = 2;
		p1.silver = 0;
		p1.bronze = 1;
		
		p2.name = "이상화";
		p2.type = "스피드스케이팅";
		p2.gold = 1;
		p2.silver = 2;
		p2.bronze = 1;
		
		p3.name = "윤성빈";
		p3.type = "스켈레톤";
		p3.gold = 1;
		p3.silver = 0;
		p3.bronze = 1;
		
		//출력
		System.out.println("이름 : "+p1.name);
		System.out.println("종목 : "+p1.type);
		System.out.println("금메달 : "+p1.gold+"개");
		System.out.println("은메달 : "+p1.silver+"개");
		System.out.println("동메달 : "+p1.bronze+"개");
		
		System.out.println("이름 : "+p2.name);
		System.out.println("종목 : "+p2.type);
		System.out.println("금메달 : "+p2.gold+"개");
		System.out.println("은메달 : "+p2.silver+"개");
		System.out.println("동메달 : "+p2.bronze+"개");
		
		System.out.println("이름 : "+p3.name);
		System.out.println("종목 : "+p3.type);
		System.out.println("금메달 : "+p3.gold+"개");
		System.out.println("은메달 : "+p3.silver+"개");
		System.out.println("동메달 : "+p3.bronze+"개");
	}
}
