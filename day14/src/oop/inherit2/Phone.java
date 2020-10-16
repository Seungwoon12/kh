package oop.inherit2;

//상위(super) 클래스 또는 부모(parent) 클래스
//- 클래스들의 공통점을 추상화시켜 만든 클래스
//- 상위 클래스는 객체 생성을 하면 안됨
public class Phone {
	private String number;//전화기라면 전화번호가 있어야지!
	private String color;//전화기라면 색상이 있어야지!
	private int price;//전화기라면 가격이 있어야지!
	
	//전화기라면 전화 기능이 있어야지!
	public void call() {
		System.out.println("전화 걸기!");
	}
	//전화기라면 문자 기능이 있어야지!
	public void sms() {
		System.out.println("문자 보내기!");
	}
	//전화기라면 사진 촬영 기능이 있어야지!
	public void camera() {
		System.out.println("카메라 촬영!");
	}
}