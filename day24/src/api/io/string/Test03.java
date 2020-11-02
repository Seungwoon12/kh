package api.io.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//목표 : Writer를 이용해서 문자열을 "변환 없이" 있는 그대로 출력
		//Writer = OutputStream + 변환 기능
		
		File target = new File("file", "string2.txt");
		FileWriter fw = new FileWriter(target);
		
		fw.write("안녕");
		fw.write("Hello");
		
		//fw.flush();
		fw.close();
	}
}