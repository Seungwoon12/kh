package api.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		//파일 객체 생성
		File a = new File("file", "hello.txt");
		File b = new File("file", "hello2.txt");
		
		if(!a.exists() || !b.exists()) {
			System.err.println("파일이 없습니다");
			System.exit(-1);//운영체제에게 전달할 상태메세지 : 일반적으로 0 아니면 다 비정상 종료
		}
		
		//1.각각의 이름을 출력
		System.out.println(a.getName());
		System.out.println(b.getName());
		
		//2.각각의 경로를 출력(절대,상대)
		System.out.println(a.getPath());
		System.out.println(a.getAbsolutePath());
		System.out.println(b.getPath());
		System.out.println(b.getAbsolutePath());
		
		//3.크기가 큰 파일의 이름을 출력
		if(a.length() > b.length()) {
			System.out.println(a.getName()+"의 크기가 큽니다");
		}
		else if(a.length() < b.length()) {
			System.out.println(b.getName()+"의 크기가 큽니다");
		}
		else {
			System.out.println("두 파일은 크기가 같습니다");
		}
		
		//4.최신파일의 이름을 출력
		System.out.println(a.lastModified());//최종 수정시각
		System.out.println(b.lastModified());
		if(a.lastModified() > b.lastModified()) {
			System.out.println(a.getName()+"가 최신파일입니다");
		}
		else if(a.lastModified() < b.lastModified()) {
			System.out.println(b.getName()+"가 최신파일입니다");
		}
		else {
			System.out.println("수정 시각이 같습니다");
		}
		
		//Date와 SimpleDateFormat을 이용하면 원하는 형식으로 변경도 가능
		Date d = new Date(a.lastModified());
		SimpleDateFormat f = new SimpleDateFormat("y년 M월 d일 E요일 a h시 m분 s초");
		System.out.println(f.format(d));
	}
}