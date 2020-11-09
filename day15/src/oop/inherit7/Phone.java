package oop.inherit7;

//휴대폰 : 추상클래스를 만들어서 필수 기능(추상 메소드)들을 정의
public abstract class Phone {
	//전화기라면 전화 기능이 반드시 있어야 한다! 하지만 내용은 자식 클래스가 알아서 만들겠지...
	public abstract void call();
	//전화기라면 문자 기능이 반드시 있어야 한다! 하지만 내용은 자식 클래스가 알아서 만들겠지...
	public abstract void sms();
	//전화기라면 카메라 기능이 반드시 있어야 한다! 하지만 내용은 자식 클래스가 알아서 만들겠지..
	public abstract void camera();
}