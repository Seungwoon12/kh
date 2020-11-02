package oop.modifier5;

public class Test01 {
	public static void main(String[] args) {
		Person a = new Person();
		Person b = new Person();
		Person c = new Person();
		a.info("이소룡", 170, 60);
		b.info("성룡", 175, 70);
		c.info("홍금보", 180, 100);
		
		//1. 객체 정보 출력
		a.print();
		b.print();
		c.print();
		
		//2. 세 객체의 키 평균
		//평균 = 합계 / 개수
		int total = a.getHeight() + b.getHeight() + c.getHeight();
		double average = (double)total / 3;
		System.out.println("평균 : "+average+"cm");
		
		//3. 이소룡의 BMI 출력
		// BMI = 체중(kg) / 키(m) / 키(m) = 체중(kg) / (키(cm) / 100.0) / (키(cm) / 100.0)
		//double bmi = a.getWeight() / (a.getHeight()/100.0) / (a.getHeight()/100.0);
		//double bmi = a.getWeight() / a.getHeightMeter() / a.getHeightMeter();
		//System.out.println("bmi = " + bmi);
		
		System.out.println(a.getName()+" bmi = "+a.getBmi());
		System.out.println(b.getName()+" bmi = "+b.getBmi());
		System.out.println(c.getName()+" bmi = "+c.getBmi());
		
		a.setHeight(180);
		System.out.println(a.getName()+" bmi = "+a.getBmi());
	}
}