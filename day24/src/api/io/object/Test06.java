package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Test06 {
	public static void main(String[] args) throws Exception{
		//입력
		
		File target = new File("file", "student.kh");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		Student stu = (Student) object.readObject();
		
		object.close();
		
		System.out.println(stu.getName());
		System.out.println(stu.getScore());
	}
}
