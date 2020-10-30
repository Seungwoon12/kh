package api.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test04 {
	public static void main(String[] args) {
		//드라이브는 최대 26개(A: ~ Z:)
		
		List<File> list = new ArrayList<>();
		
		for(char i='A'; i<='Z'; i++) {
			File drive = new File(i+":/");
			if(drive.canRead()) {
				list.add(drive);
			}
		}
		
		System.out.println("드라이브 검색이 완료되었습니다");
		System.out.println("결과 수 : " + list.size());
		for(File drive : list) {
			System.out.println(drive.getAbsolutePath());
		}
	}
}