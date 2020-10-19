package oop.inherit6;

public abstract class MediaFile extends File{
	//변수 추가할 것 없음
	
	public MediaFile(String filename) {
		super(filename);
	}
	
	//추상 메소드로 forward(), rewind()를 추가
	//public abstract void execute();//상속된 내용
	public abstract void forward();
	public abstract void rewind();
}