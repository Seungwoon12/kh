package api.lang.object;

//import java.lang.*;

public class Test02 {
	public static void main(String[] args) {
		//Object는 모든 클래스의 조상
		// = Object에는 아무거나 넣을 수 있다.
		// = 업케스팅	
		
		//증거
		Object a = 10; //int를 Object에 업케스팅하여 보관
		Object b = "hello"; // String을 Object에 업캐스팅하여 보관
		Object c = 3.14;
		
		//형태검사(instanceof 연산자)
		//a는 int인가?		true
		//b는 int인가?		false
		System.out.println(a instanceof String);
		System.out.println(b instanceof String);
	}
}
