package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02_1 {
	public static void main(String[] args) throws IOException {
//		single.kh 파일을 읽기 위한 도구들을 준비해보세요
//		 - 주의 : target은 무조건 존재하는 파일이어야 한다
		File target = new File("file", "single.sw");
		FileInputStream in = new FileInputStream(target);
		
//		[프로그램] ← in ← target ← [single.kh]
//		in을 이용하여 파일의 데이터들을 1byte씩 읽는다!
//		2. while문을 이용하여 EOF까지 읽는다
//			- EOF(End Of File) : 파일 내용의 끝을 의미하는 값
//			- EOF는 입력의 형태마다 다른 값을 가지며, 지금(바이트 입력)은 -1
		
		while(true) {
			int data = in.read();
			if(data == -1) break;
			System.out.println("data = " + data);
		}
//		int data;
//		while((data = in.read()) != -1) {
//			System.out.println(data);
//		}
		
		in.close();
	}
}
