package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06 {
	public static void main(String[] args) throws IOException {
		//배열을 이용한 파일 복사
		//- 준비물 : 파일 객체(입력용/출력용), 파일 스트림(입력용/출력용), 버퍼(바이트배열)
		
		File origin = new File("file", "array.test");
		File copy = new File("file", "array.copy");
		
		FileInputStream in = new FileInputStream(origin);
		FileOutputStream out = new FileOutputStream(copy);
		
		//byte는 PC의 물리 저장단위를 의미하는 자료형이다(기본 저장 크기)
		byte[] buffer = new byte[6];
		
		//[array.test] → origin → in → [프로그램] → out → copy → [array.copy]
		
		while(true) {
			int count = in.read(buffer);//buffer에 가득담고 담은개수를 count에 저장해라
			if(count == -1) break;
			out.write(buffer, 0, count);//buffer에 담긴 데이터를 실제 읽은수(count)만큼 내보낸다
		}
		
		//스트림 종료
		in.close();
		out.close();
		
	}
}