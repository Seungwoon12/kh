package api.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("경로 입력 : ");
		String input = sc.nextLine();
		sc.close();
		
		File target = new File(input);
		if(target.exists()) {//파일
			if(target.isFile()) {
				String name = target.getName();
				long size = target.length();//파일크기는 long(int는 2GB까지밖에 표현을 못함)
				Date d = new Date(target.lastModified());
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = f.format(d);
				System.out.println(name+"/"+size+"byte/"+time);
			}
			else {//디렉터리
				File[] files = target.listFiles();
				for(File f : files) {
					System.out.println(f.getPath());
				}
			}
		}
		else {
			System.out.println("존재하지 않는 파일 또는 폴더입니다");
		}
		
	}
}