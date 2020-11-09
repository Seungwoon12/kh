package api.io.file;

import java.io.File;

public class Test05 {
	public static void main(String[] args) {
		//디렉터리 검색
		//- 디렉터리는 크기가 없다(크기는 안에 있는 파일의 크기)
		File dir = new File("file");
		System.out.println(dir.isDirectory());
		System.out.println(dir.length());
		
		//Q) file 폴더에 있는 모든 파일을 불러오고 싶어요(목록 출력)
		// - 안에 들어있는 파일 개수는 모른다
		// - 안에 들어있는 여러 개의 파일을 꺼낸다 ----> List<File> 또는 File[]
		File[] files = dir.listFiles();
		System.out.println(files.length);
		
		
		for(File f : files) {
			System.out.println(f.getPath());
			//System.out.println(f.getAbsolutePath());
		}
	}
}
