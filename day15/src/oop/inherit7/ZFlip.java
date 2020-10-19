package oop.inherit7;

public final class ZFlip extends Phone {
		
	@Override
	public void call() {
		System.out.println("ZFlip의 전화 기능 사용!");
	}
	@Override
	public void sms() {
		System.out.println("ZFlip의 문자 기능 사용!");
	}
	@Override
	public void camera() {
		System.out.println("ZFlip의 카메라 기능 사용!");
	}
}
