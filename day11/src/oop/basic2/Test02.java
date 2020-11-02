package oop.basic2;

//프로그램을 구동시키기 위한 메인 메소드가 있는 클래스
public class Test02 {
	public static void main(String[] args) {
		//선수정보 3개 생성
		PlayerData p1 = new PlayerData();
		PlayerData p2 = new PlayerData();
		PlayerData p3 = new PlayerData();
				
		//정보 설정(초기화)
		p1.info("김연아", "피겨스케이팅", 2, 0, 1);
		p2.info("이상화", "스피드스케이팅", 1, 2, 1);
		p3.info("윤성빈", "스켈레톤", 1, 0, 1);
		
		//출력
		p1.print();//p1 입장에서 print 메소드 실행!
		p2.print();//p2 입장에서 print 메소드 실행!
		p3.print();//p3 입장에서 print 메소드 실행!
	}
}