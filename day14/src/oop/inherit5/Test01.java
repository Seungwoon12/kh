package oop.inherit5;

public class Test01 {
	public static void main(String[] args) {
		//AVI, MP3, PPT의 객체를 생성하여 각각 기능을 실행!
		//캡슐화 : 내부 구조는 감추고 기능 단위로 외부에 노출시키는 프로그래밍 디자인 방식
		MP3 mp3 = new MP3("test.mp3");
		mp3.execute();
		mp3.rewind();
		mp3.forward();
		
		AVI avi = new AVI("test.avi");
		avi.execute();
		avi.rewind();
		avi.forward();
		
		PPT ppt = new PPT("test.pptx");
		ppt.execute();
		ppt.information();
	}
}