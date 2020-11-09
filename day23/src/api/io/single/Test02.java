package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		//single.sw 파일을 읽기 위한 도구들을 준비해보세요
		// - 주의 : target은 무조건 존재하는 파일이어야 한다
		File target = new File("file", "single.sw");
		FileInputStream in = new FileInputStream(target);
		
		//[프로그램] ← in ← target ← [single.sw]
		//in을 이용하여 파일의 데이터들을 1byte씩 읽는다!
		//1. 글자수(.length()) 만큼 반복하며 읽는다
		for(int i=0; i<target.length(); i++) {
			int data = in.read();
			System.out.println("data = " + data);
		}
		
		in.close();
	}
}