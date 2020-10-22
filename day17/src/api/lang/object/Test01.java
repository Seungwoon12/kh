package api.lang.object;

//import java.lang.*; 이 생략되어 있음
public class Test01 {
	public static void main(String[] args) {
		//목표 : 남이만든 Object 클래스가 뭐하는 놈인지는 모르겠지만 객체를 만들어보자
		Object a = new Object();
		Object b = new Object();
		
		//만들었으니 뭘 할 수 있나 보자
		
		//hashCode()는 객체 일련번호(hashcode)만 숫자로 반환하는 명령
		//hashcode()는 객체를 구분하기 위한 번호(주소가 아님) - 일련번호가 다르면 다른 객체라고 판단
		int v1 = a.hashCode();
		int v2 = b.hashCode();	
		System.out.println(v1);
		System.out.println(v2);
		
		//문제 : a, b 각각 toString 기능을 사용하고 그 결과를 출력하세요.
		//toString()은 객체 요약정보를 반환하는 명령 - 형태@일련번호
		String a1 = a.toString();
		String a2 = b.toString();	
		System.out.println(a1);
		System.out.println(a2);
	}
}
