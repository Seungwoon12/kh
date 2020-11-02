package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test04_1 {
	public static void main(String[] args) throws IOException {
		//데이터가 5개라는 걸 어떻게 알까?
		//int가 저장되었다는것만 알면, 파일크기/4로 계산
		
		int[] arr = new int[5];
		
		File target = new File("file", "numbers.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);
		
		long count = target.length() / Integer.BYTES;
		
		for(int i=0; i<count; i++) {
			arr[i] = data.readInt();
		}
		
		data.close();
		
		System.out.println(Arrays.toString(arr));
		
	}
}