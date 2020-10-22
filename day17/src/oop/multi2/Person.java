package oop.multi2;

//의사이면서 가수인 사람 클래스
// - 인터페이스는 implements 라는 별도의 키워드로 상속받아야 한다.(extends는 클래스 상속받을때)
// - implements, extends 둘다 쓰는 경우에는 extends가 앞에 와야함 더 중요하니깐
// - 인터페이스를  여러개 상속받을 때는 콤마(,)를 사용하여 구분한다.
// - super라는 키워드는 상속받은 Class를 지칭한다.

public class Person extends Female implements Singer, Doctor {

	@Override
	public void sing() {
		System.out.println("노래하고");
		
	}

	@Override
	public void dance() {
		System.out.println("춤추고");
		
	}

	@Override
	public void observe() {
		System.out.println("진료하고");
		
	}
	
}
