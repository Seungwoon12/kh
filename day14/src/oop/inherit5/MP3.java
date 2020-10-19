package oop.inherit5;

//클래스에 final이 붙으면 더이상 상속이 이루어질 수 없다(상속 금지)
public final class MP3 extends MediaFile{
	//추가되는 변수가 존재
	private int duration;

	public MP3(String filename) {
		//super는 MediaFile을 말함
		super(filename);
	}

	//execute, forward, rewind 모두 재정의
	@Override
	public void execute() {
		System.out.println("음악 재생을 시작합니다");
	}
	@Override
	public void forward() {
		System.out.println("음악을 빨리감기 합니다");
	}
	@Override
	public void rewind() {
		System.out.println("음악을 되감기 합니다");
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}