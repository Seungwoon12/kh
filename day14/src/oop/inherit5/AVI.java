package oop.inherit5;

//final이 붙은 클래스는 더이상 상속이 불가능하다
public final class AVI extends MediaFile{
	private int speed = 1;//기본값을 1로 설정한다
	
	public AVI(String filename) {
		super(filename);
	}

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	//메소드
	//- source 메뉴의 override/implements method 선택
	@Override
	public void forward() {
		System.out.println("영상을 빨리감기합니다");
	}
	@Override
	public void rewind() {
		System.out.println("영상을 되감기합니다");
	}
	@Override
	public void execute() {
		System.out.println("영상 재생을 "+this.speed+"배속으로 시작합니다");
	}
	
}