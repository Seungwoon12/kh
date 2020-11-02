package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test03_1 {
	public static void main(String[] args) throws IOException {
		//목표 : Writer를 이용해서 문자열을 "변환 없이" 있는 그대로 출력
		//Writer = OutputStream + 변환 기능
		//- 문자열도 여러 개의 byte를 전송하는 형태이므로 "버퍼"를 쓰면 좋다
		//- FileWriter에도 버퍼가 내장되어있긴 하지만 성능이 좋지 않다
		//- BufferedWriter를 사용하여 버퍼 성능 향상
		//- 기능상의 차이는 없고 단지 "성능"이 향상됨
		
		//문제점 : byte와 문자열만 전송이 가능하며 다른 형태는 전송이 안됨
		
		File target = new File("file", "string2.txt");
		FileWriter fw = new FileWriter(target);
		BufferedWriter bw = new BufferedWriter(fw, 8192);
		
		bw.write("안녕!");
		bw.write("Hello!");
		//bw.write(3.14);
		
		//bw.flush();
		bw.close();
		
	}
}