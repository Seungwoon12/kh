package oop.inherit5;

public class Type {
	protected String filename;
	protected String filesize;
	protected int duration;
	protected int speed;
	protected int size;

	
	public Type(String filename, String filesize) {
		this.filename = filename;
		this.filesize = filesize;
		
	}
	public Type(String filename) {	
		this.filename = filename;
		this.filesize = "0";
	}

		
	public void execute() {
		System.out.println("실행합니다");
	}
	public void forward() {
		System.out.println("빨리감기 합니다.");
	}
	public void rewind() {
		System.out.println("되감기합니다.");
	}
	
	public void print() {
		System.out.println("파일명 : "+this.filename);
		System.out.println("파일크기 : "+this.filesize);
		
	}
}
