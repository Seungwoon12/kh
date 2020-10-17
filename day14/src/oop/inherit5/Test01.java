package oop.inherit5;

public class Test01 {
	public static void main(String[] args) {
		MP3 t1 = new MP3("Lovesick girl");
		AVI t2 = new AVI("인터스텔라","1.85GB", 2);
		PPT t3 = new PPT("KH정보교육원 커리큘럼", "5MB", 100);
		
		t1.print();
		t1.execute();
		t1.forward();
		t1.rewind();
		
		t2.print();
		t2.execute();
		t2.forward();
		t2.rewind();
		
		t3.print();
		t3.execute();
		t3.information();	
	}
	
	
	//duration 자료형을 String으로 하고싶은데 그러면 filesize하고 자료형이 겹치게 돼서 오류남
	// 해결방법이 무엇?
}
