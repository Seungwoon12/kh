package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//객체 입력
		
		File target = new File("file", "object.txt");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		//[프로그램] ← object ← buffer ← in ← target ← [object.txt]
		//읽는 명령도 1개 : readObject()
		
		Date d = (Date) object.readObject();//ClassNotFoundException
		
		object.close();//다 썼으면 close
		
		System.out.println(d);
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
	}
}