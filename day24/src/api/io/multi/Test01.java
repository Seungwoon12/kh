package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		File target = new File("file","multi.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		DataOutputStream data = new DataOutputStream(buffer);
		
		data.writeInt(100);
		data.writeChar(100);
		data.writeDouble(100);
		data.writeLong(100);
		data.writeByte(100);
		data.writeFloat(100);
		
		data.flush();
		
		
		
	}
}
