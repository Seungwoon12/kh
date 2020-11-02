package oop.inherit1;

//갤럭시 노트 20
public class GalaxyNote20 {
	//멤버 변수
	private String number;
	private String color;
	private int price;
	
	//setter&getter 외의 기능(메소드)
	public void call() {
		System.out.println("전화 걸기!");
	}
	public void sms() {
		System.out.println("문자 보내기!");
	}
	public void camera() {
		System.out.println("카메라 촬영!");
	}
	public void bixby() {
		System.out.println("하이 빅스비!");
	}
}
