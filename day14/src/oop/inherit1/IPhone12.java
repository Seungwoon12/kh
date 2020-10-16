package oop.inherit1;

//아이폰12
public class IPhone12 {
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
		System.out.println("사진 촬영!");
	}
	public void siri() {
		System.out.println("시리야!");
	}
}
