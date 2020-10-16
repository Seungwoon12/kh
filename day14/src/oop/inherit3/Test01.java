package oop.inherit3;

public class Test01 {
	public static void main(String[] args) {
		//뽀로로 인스턴스 1개, 타요 인스턴스 1개를 생성
		Pororo p = new Pororo("뽀로로");
		p.hello();//상속받은 기능
		p.nag();//고유 기능
		
		Tayo t = new Tayo("타요");
		t.hello();//상속받은 기능
		t.drive();//고유 기능
	}
}