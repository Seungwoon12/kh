  
package api.lang.stringbuffer;

public class Test02 {
	public static void main(String[] args) {
		//StringBuffer를 사용하여 덧셈을 진행
		// - 낭비가 없고 시간이 빠름(시간복잡도가 낮다)
		
		StringBuffer buffer = new StringBuffer();//비어있는 공간 생성
		
		long a = System.currentTimeMillis();
		for(int i=0; i<10000000; i++) {
			buffer.append("hello");//hello를 덧붙여라
//			buffer.append("\n");//엔터를 덧붙여라
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a+"ms");//소요시간
		
		System.out.println(buffer.toString());//문자열로 바꿔서 출력해라!
	}
}