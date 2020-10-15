package oop.modifier2;

public class Test01 {
	public static void main(String[] args) {
		Saving s1 = new Saving();
		Saving s2 = new Saving();
		Saving s3 = new Saving();
		
		
		s1.info("생애 최초 주택마련 적금", 2.3f, 0.5f, 100, 100);
		s2.info("내꿈은 사장님 적금", 2.0f, 0.7f, 200, 20);
		s3.info("내 차는 스포츠카 적금", 2.1f, 1.1f, 500, 10);
		
		s1.print();
		s2.print();
		s3.print();
	}
}
