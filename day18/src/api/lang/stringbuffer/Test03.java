 package api.lang.stringbuffer;

public class Test03 {
	public static void main(String[] args) {
		//StringBuffer 대신 StringBuilder 사용
		
		StringBuilder buffer = new StringBuilder();//비어있는 공간 생성
		
		long a = System.currentTimeMillis();
		for(int i=0; i<100000000; i++) {
			buffer.append("hello");//hello를 덧붙여라
			buffer.append("\n");//엔터를 덧붙여라
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a+"ms");//소요시간
		
//		System.out.println(buffer.toString());//문자열로 바꿔서 출력해라!
	}
}

		//동기화가 설정되었다(StringBuffer)
		// = 잠금장치가 있다
		// = 느리다(잠금/풀림을 해야하니까)
		// = 안전하다(데이터 손실이 없다)