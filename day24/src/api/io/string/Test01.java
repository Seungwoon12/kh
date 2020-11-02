package api.io.string;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		//문자열 입출력
		// - 문자열도 객체이지만 특별하게 취급되는 이유가 있다
		// - 문자열은 byte[] 와 호환이 가능하다
		// - 자체적으로 변환이 되므로 분해할 필요가 없다 : .getBytes() 명령 사용
		// - 자체적으로 변환이 되므로 복원할 필요가 없다 : 생성자 사용
		
		String hello = "안녕! hello!";
		byte[] data = hello.getBytes();//String → byte[]
		
		System.out.println(hello);
		System.out.println(Arrays.toString(data));
		
		String recover = new String(data);//byte[] → String
		System.out.println(recover);
	}
}
