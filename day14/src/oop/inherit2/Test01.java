package oop.inherit2;

public class Test01 {
	public static void main(String[] args) {
		//목표 : GalaxyNote20과 IPhone12를 각각 인스턴스화 하여 상속이 잘 이루어졌는지 파악
		
		GalaxyNote20 note = new GalaxyNote20();
		//note에 들어있는 변수는 3개, 메소드는 4개
		note.call();
		note.sms();
		note.camera();
		note.bixby();
		
		IPhone12 iphone = new IPhone12();
		//iphone에 들어있는 변수는 3개, 메소드는 4개
		iphone.call();
		iphone.sms();
		iphone.camera();
		iphone.siri();
	}
}