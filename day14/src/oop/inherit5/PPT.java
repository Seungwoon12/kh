package oop.inherit5;

public class PPT extends Type{
	
	public PPT(String filename, String filesize, int size) {
		super(filename, filesize);
		this.size= size;
	}
	public PPT(String filename, String filesize) {
		super(filename, filesize);
		this.size = 1;
	}
	public PPT(String filename, int size) {
		super(filename);
		this.size = size;
	}
	public PPT(String filename) {
		super(filename);
		this.size = 1;
	}
	
	
	
	@Override
	public void execute () {
		System.out.println("파워포인트 애니메이션을 재생합니다.");
	}
	
	public void information() {
		System.out.println(filename+", "+filesize+", "+size+"장");
	}
	
	@Override
	public void print() {
		System.out.println("파일명 : "+super.filename);
		System.out.println("파일크기 : "+super.filesize);
		System.out.println("장수 : "+this.size+"장");
	}
}
