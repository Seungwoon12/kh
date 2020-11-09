package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06_1 {
	public static void main(String[] args) throws IOException {
		//배열을 이용한 파일 복사
		//- 준비물 : 파일 객체(입력용/출력용), 파일 스트림(입력용/출력용), 버퍼(바이트배열)
		
		File origin = new File("C:\\Users\\김승운\\Desktop/2.png");
		File copy = new File("C:\\Users\\김승운\\Desktop/2copy.png");
		
		FileInputStream in = new FileInputStream(origin);
		FileOutputStream out = new FileOutputStream(copy);
		
		//byte는 PC의 물리 저장단위를 의미하는 자료형이다(기본 저장 크기)
		//- 버퍼는 무조건 크다고 좋은것이 아님(크면 오버헤드가 생김)
		//- 컴퓨터는 물리적으로 2진수로 표현되기때문에 크기가 2의 제곱수로 정해짐
		//- 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, ...
		//- 잘 모를 때에는 1024, 2048, 4096, 8192 정도를 사용하면 효율적
		//- 8192가 자바에 내장된 버퍼의 기본 크기
		byte[] buffer = new byte[1024];
		
		//[array.test] → origin → in → [프로그램] → out → copy → [array.copy]
		
		long total = origin.length();//총 옮길 크기
		long acc = 0L;//실제 옮긴 크기
		
		long start = System.currentTimeMillis();
		while(true) {
			int count = in.read(buffer);//buffer에 가득담고 담은개수를 count에 저장해라
			if(count == -1) break;
			out.write(buffer, 0, count);//buffer에 담긴 데이터를 실제 읽은수(count)만큼 내보낸다
			acc += count;//옮긴 개수 누적
			double percent = acc * 100.0 / total;
			System.out.println(acc + "/" + total+"("+percent+"%)");
		}
		long finish = System.currentTimeMillis();
		long time = finish - start;
		System.out.println("소요시간 : "+time+"ms");
		
		//스트림 종료
		in.close();
		out.close();
		
		
		
	}
}
