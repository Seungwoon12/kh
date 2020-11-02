package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test03 {
	public static void main(String[] args) throws Exception{
		
		int[] arr = new int[] {3, 5, 2, 1, 4};
		
		
		//arr을 통째로 출력
		File target = new File("file", "numbers.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//출력
		object.writeObject(arr);
		
		
		//종료
		//object.flush();
		object.close();
	}
}