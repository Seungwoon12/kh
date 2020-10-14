package oop.basic2;

public class Test02 {
	public static void main(String[] args) {
		
		Record p1 = new Record();
		Record p2 = new Record();
		Record p3 = new Record();
		
		
		
		
		p1.info("김연아", "피겨스케이팅", 2, 0, 1);
		p2.info("이상화", "스피드스케이팅", 1, 2, 1);
		p3.info("윤성빈", "스켈레톤", 1, 0, 1);
		
		p1.print();
		p2.print();
		p3.print();
		

		
		
		
	}
}
