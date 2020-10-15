package oop.modifier5;

public class Test01 {
	public static void main(String[] args) {
		Bmi b1 = new Bmi();
		Bmi b2 = new Bmi();
		Bmi b3 = new Bmi();
		
		b1.info("이소룡", 170, 60);
		b2.info("성룡", 175, 70);
		b3.info("홍금보", 180, 100);
		
		b1.print();
		b2.print();
		b3.print();
		
		double average = (b1.getHeight() + b2.getHeight() + b3.getHeight())/3.0;
		
		
		System.out.println("세명의 키 평균 : "+average+"cm");
		System.out.println("이소룡의 BMI : "+b1.getBmi());
		
	}
}
