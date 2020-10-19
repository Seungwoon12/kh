package oop.inherit6;

public class MP3 extends MediaFile{
	private int duration;

	public MP3(String filename) {
		super(filename);
	}

	@Override
	public void forward() {
		System.out.println("음악을 빨리감기합니다");
	}
	@Override
	public void rewind() {
		System.out.println("음악을 되감기합니다");
	}
	@Override
	public void execute() {
		System.out.println("음악을 재생합니다");
	}
	
}