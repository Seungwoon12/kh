package api.io.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		//Test01에 살펴본 문자열을 byte배열로 변경하는 특징을 활용한 파일 출력 수행
		
		String text = "안녕! hello!";
		
		File target = new File("file", "string.txt");
		FileOutputStream out = new FileOutputStream(target);
		
		//출력
		//out.write(text);//문자열은 출력이 안됨
		out.write(text.getBytes());//바이트 배열로 바꾸면 됨
		
		out.close();
	}
}