package oop.inherit6;

public class AVI extends MediaFile{
	private int speed = 1;
	
	public AVI(String filename) {
		super(filename);
	}

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
		System.out.println("영상을 "+speed+"배속으로 재생합니다");
	}

}