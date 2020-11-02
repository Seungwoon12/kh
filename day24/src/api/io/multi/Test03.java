package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//여러개의 형태를 섞어서 출력하기보다 하나의 형태를 입출력하는 경우가 많다
		
		int[] arr = new int[] {3, 5, 2, 1, 4};
		
		//준비물 : 파일 객체, 출력용 스트림, 버퍼 스트림, 분할 스트림
		File target = new File("file", "numbers.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);
		
		//data를 이용하여 출력
		//data.writeInt(arr);
		//for(int i=0; i < arr.length; i++) {
		//	data.writeInt(arr[i]);
		//}
		for(int n : arr) {
			data.writeInt(n);
		}
		
		//data.flush();
		data.close();
	}
}