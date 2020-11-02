package oop.modifier4;

//다른 패키지의 클래스를 이용하고 싶으면 import를 통해 알려줘야함
import oop.modifier3.House;//House라고 하면 여기 있는거라고 생각해라!

public class Test01 {
	public static void main(String[] args) {
		//다른 패키지(oop.modifier3)에 존재하는 House의 객체를 생성
		
		House h1 = new House();//House가 뭐에요?(같은패키지에 없어요..)
		
		//접근제한자가 없는 경우에는 "같은 패키지" 내에서만 접근이 가능하구나...
		// - 자바에서는 같은 패키지가 기본 인식 단위이다(default값 : package접근제한)
		h1.setArea("강남");
		h1.setSize(24);
		h1.setPrice(3000);
	}
}
