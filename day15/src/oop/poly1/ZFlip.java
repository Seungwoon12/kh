package oop.poly1;

public class ZFlip extends Phone{

	@Override
	public void call() {
		System.out.println("ZFilp의 전화 기능 실행!");
	}
	@Override
	public void sms() {
		System.out.println("ZFlip의 문자 기능 실행!");
	}
	@Override
	public void camera() {
		System.out.println("ZFilp의 카메라 기능 실행");
	}

}