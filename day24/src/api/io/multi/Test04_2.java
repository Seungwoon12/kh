package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test04_2 {
	public static void main(String[] args) throws IOException {
		//데이터가 5개라는 걸 어떻게 알까?
		//몰라도 구현 가능!
		
		List<Integer> list = new ArrayList<>();
		
		File target = new File("file", "numbers.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);
		
		//while구문으로 입력받기
		try {
			while(true) {
				int n = data.readInt();
				list.add(n);
			}
		}
		catch(Exception e) {
			//아무것도 할게 없음(다 읽어서 생긴 예외)
		}
		
		data.close();
		
		System.out.println(list);
	}
}