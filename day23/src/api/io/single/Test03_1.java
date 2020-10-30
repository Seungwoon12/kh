package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		//준비물
		//1. 입력용 파일객체, 입력용 스트림
		//2. 출력용 파일객체, 출력용 스트림
		
		File origin = new File("file", "hello.txt");//입력용 파일
		File dest = new File("file", "copy.txt");//출력용 파일
		
		FileInputStream in = new FileInputStream(origin);//입력용 스트림
		FileOutputStream out = new FileOutputStream(dest);//출력용 스트림
		
		//[hello.txt] → origin → in → [프로그램] → out → dest → [copy.txt]
		
		while(true) {
			//1글자만 복사 : 한 글자를 입력받아 반대편으로 출력
			int data = in.read();
			if(data == -1) break;
			out.write(data);
		}
		
		in.close();
		out.close();
		
	}
}
