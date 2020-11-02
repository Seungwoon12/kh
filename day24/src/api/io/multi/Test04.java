package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
		//데이터 개수를 알면 배열, 모르면 List
		
		int[] arr = new int[5];
		
		File target = new File("file", "numbers.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		DataInputStream data = new DataInputStream(buffer);
		
		arr[0] = data.readInt();
		arr[1] = data.readInt();
		arr[2] = data.readInt();
		arr[3] = data.readInt();
		arr[4] = data.readInt();
		
		data.close();
		
	}
}

