package api.lang.integer;

public class Test01 {
	public static void main(String[] args) {
		//Q : java.lang.Integer 문서를 보고 100이라는 값을 가지는 객체를 a, b라는 이름으로 생성해라
		// - Integer는 int형 값을 관리하는 클래스
		
		Integer a = new Integer(100);
		Integer b = new Integer("100");
		
		//사용
		//Integer클래스에서는 Object의 기능을 재정의해두었다.
		System.out.println(a.toString());
		System.out.println(b.toString());
		
		// 밑에 내용 정말정말 중요함
		
		//Q : a와 b는 같나?
		// - "같아요?"는  두 가지 경우로 쓰인다.
		//		1. 같은 객체인가?
		//		2. 값이 일치하나?
		// - 객체는 2번으로 비교하므로 equals()를 사용해야한다.
		System.out.println(a == b); //1번을 검사하는 코드(동일)
		System.out.println(a.equals(b)); //2번을 검사하는 코드(동등)
		
	}

	
	
}
