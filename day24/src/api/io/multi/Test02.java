package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		
		File target = new File("file/multi.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);	
		DataInputStream data = new DataInputStream(buffer);
		
		int a = data.readInt();
		char b = data.readChar();
		double c = data.readDouble();
		long d = data.readLong();
		byte e = data.readByte();
		float f = data.readFloat();
		
		data.close();
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		System.out.println("d = "+d);
		System.out.println("e = "+e);
		System.out.println("f = "+f);
		
		
		
	}
}
