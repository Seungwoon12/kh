package api.io.file;

import java.io.File;

public class Test03 {
	public static void main(String[] args) {
		//파일만 객체를 만들 수 있는건 아니다
		//- 디렉터리(폴더)도 되고, 드라이브도 가능
		
		File drive = new File("C:/");
		System.out.println(drive.exists());
		System.out.println(drive.canRead());
		System.out.println(drive.canWrite());
		System.out.println(drive.canExecute());
		System.out.println(drive.isDirectory());//디렉터리인가요?
		System.out.println(drive.isFile());//파일인가요?
	}
}