package api.io.single;

import java.io.File;
import java.io.FileOutputStream;

public class Test04 {
	public static void main(String[] args) throws Exception{
		//바이트 출력의 하이라이트 : 바이트 배열 출력
		//준비물 : 파일 객체, 출력용 스트림, 배열(칸수는 마음대로)
		
		File target = new File("file", "array.test");
		FileOutputStream out = new FileOutputStream(target);

		byte[] data = new byte[] {104, 101, 108, 108, 111, 10};//hello\n
		
		//연결되어있는 구조는 동일하다
		//[프로그램] → out → target → [array.test]
		
		out.write(data);//data에 들어있는 값을 다 출력해라
		out.write(data);//data에 들어있는 값을 다 출력해라
		out.write(data, 0, 4);//data에 들어있는 값을 0부터 4개 출력해라
		out.write(data, 1, 4);//data에 들어있는 값을 1부터 4개 출력해라
		
		out.close();
		
		
	}
}