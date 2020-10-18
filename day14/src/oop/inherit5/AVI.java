package oop.inherit5;

public class AVI extends Type {
	
	public AVI(String filename, String filesize, int speed) {
		super(filename, filesize);
		this.speed = speed;
	}
	
	public AVI(String filename, String filesize) {
		super(filename, filesize);
		this.speed = 1;
	}
	public AVI(String filename, int speed) {
		super(filename);
		this.speed = speed;
	}
	
	public AVI(String filename) {
		super(filename);
		this.speed = 1;
	}
	
	@Override
	public void execute() {
		System.out.println("영상 재생을 "+speed+"배속으로 시작합니다.");
	}
	@Override
	public void forward() {
		System.out.println("영상을 빨리감기 합니다.");
	}
	@Override
	public void rewind() {
		System.out.println("영상을 되감기합니다.");
	}
	@Override
	public void print() {
		System.out.println("파일명 : "+super.filename);
		System.out.println("파일크기 : "+super.filesize);
		System.out.println("배속 : "+this.speed);
	}	
}
