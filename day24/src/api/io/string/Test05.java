package api.io.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner를 사용하여 파일을 읽는 방법
		//- 장점 : 다양한 명령으로 내가 원하는 형태에 맞게 입력이 가능(.nextInt(), .nextDouble(), .next())
		//- 단점 : 형태를 고려하지 않는다면 성능상 느리다(외장 버퍼 설정 불가)
		
		File target = new File("file", "string2.txt");
		Scanner sc = new Scanner(target);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}