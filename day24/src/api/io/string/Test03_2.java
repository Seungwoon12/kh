package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test03_2 {
	public static void main(String[] args) throws IOException {
		//목표 : Writer를 이용해서 문자열을 "변환 없이" 있는 그대로 출력
		//Writer = OutputStream + 변환 기능
		//- 자료형을 마음대로 선택하여 출력할 수 있는 도구를 추가(PrintWriter)
		//- 자동 개행 등을 선택할 수 있는 기능이 있다
		
		File target = new File("file", "string2.txt");
		FileWriter fw = new FileWriter(target);
		BufferedWriter bw = new BufferedWriter(fw, 8192);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("hello");
		pw.println(100);
		pw.println(3.14);
		pw.println(true);
		pw.println("주말 잘 보내세요!");
		pw.println("카메라 키시구요");
		
		//pw.flush();
		pw.close();
		
	}
}