package oop.poly1;

public class V60 extends Phone{
	@Override
	public void call() {
		System.out.println("V60의 전화 기능 사용!");
	}
	@Override
	public void sms() {
		System.out.println("V60의 문자 기능 사용!");
	}
	@Override
	public void camera() {
		System.out.println("V60의 카메라 기능 사용!");
	}
}