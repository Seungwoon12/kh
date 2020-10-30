package api.io.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		File target = new File("file", "single.sw");
		
		FileOutputStream out = new FileOutputStream(target);
		
		out.write(65);
		out.write('B');
		out.write(9);
		out.write(104);
		out.write(101);
		out.write(108);
		out.write(108);
		out.write(111);
		out.write(10);
		out.write(30000);
		
		out.close();
		
	}
}
