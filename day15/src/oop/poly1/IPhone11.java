package oop.poly1;

public class IPhone11 extends Phone{
	@Override
	public void call() {
		System.out.println("iPhone11의 전화 기능 사용!");
	}
	@Override
	public void sms() {
		System.out.println("iPhone11의 문자 기능 사용!");
	}
	@Override
	public void camera() {
		System.out.println("iPhone11의 카메라 기능 사용!");
	}
}