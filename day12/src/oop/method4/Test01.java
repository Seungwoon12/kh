package oop.method4;

public class Test01 {
	public static void main(String[] args) {
		Score s1 = new Score();
		Score s2 = new Score();
		Score s3 = new Score();
		
		s1.info("피카츄", 1, 50, 60, 60);
		s2.info("파이리", 2, 75, 70, 60);
		s3.info("꼬부기", 3, 75, 80, 30);
		
		s1.print();
		s2.print();
		s3.print();
		
	}
}
