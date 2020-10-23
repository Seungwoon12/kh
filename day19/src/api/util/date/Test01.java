package api.util.date;

import java.util.Date;

public class Test01 {
	public static void main(String[] args) {
		//java.util.Date 클래스
		// - 생성자중에 비추천(Deprecated)가 많다
		// - 이유는 Y2K
		
		//기본생성자를 이용하면 "현재시간"을 가져온다
		Date a = new Date();
		System.out.println(a);//a.toString()
		
		//연월일을 설정하는 생성자(비추천)
		//- 비추천은 경고와 함께 표식이 나온다
		//- 여러 가지 문제점으로 인해 앞으로 쓰지 말것을 권장(사라질 수도 있다는 표시)
		Date b = new Date(2020, 10, 23);
		System.out.println(b);
		
		//문제점 : 시간이 한국인의 정서에 맞지 않게 나온다
		//해결책 : 시간 형식을 설정하는 클래스를 찾아서 사용하면 끝!(직접하지 않는다)
		
	}
}