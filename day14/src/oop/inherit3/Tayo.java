package oop.inherit3;

public class Tayo extends Doll{
	//상속으로 변수2개와 메소드1개를 받음
	
	public void drive() {
		System.out.println("부릉부릉!");
	}
	
	//부모클래스에 생성자가 있으면 나도 있어야 된다(형태를 맞춘다!)
		// - 부모클래스 생성에 필요로 데이터를 넘겨주지 않으면 절대 상속 불가!
		public Tayo(String name) {
			super(name);
		}
	}
