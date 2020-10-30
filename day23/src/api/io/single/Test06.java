package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06 {
	public static void main(String[] args) throws IOException {
		File origin = new File("file/hello.txt");
		File dest =  new File("file/copy2.txt");
		
		FileInputStream in = new FileInputStream(origin);
		FileOutputStream out = new FileOutputStream(dest);
		
		byte[] data = new byte[4];
		
		while(true) {
			int size = in.read(data);
			if(size == -1) break;
			out.write(data, 0, size);
			System.out.println(size);
			System.out.println(Arrays.toString(data));
		}
		
		in.close();
		out.close();
		
	}
	
}
