package oop.inherit5;

public class MP3 extends Type {
	
	public MP3(String filename, String filesize, int duration) {
		super(filename, filesize);
		this.duration = duration;
	}
	public MP3(String filename, String filesize) {
		super(filename, filesize);
		this.duration = 0;
	}
	public MP3(String filename, int duration) {
		super(filename);
		this.duration = duration;
	}
	public MP3(String filename) {
		super(filename, "0");
		this.duration = 0;
	}
	
	
	@Override
	public void execute() {
		System.out.println("음악 재생을 시작합니다.");
	}
	@Override
	public void forward() {
		System.out.println("음악을 빨리감기 합니다.");
	}
	@Override
	public void rewind() {
		System.out.println("음악을 되감기합니다.");
	}
	@Override
	public void print() {
		System.out.println("파일명 : "+super.filename);
		System.out.println("파일크기 : "+super.filesize);
		System.out.println("재생시간 : "+this.duration+"초");
	}	
}
