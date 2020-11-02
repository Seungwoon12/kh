package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05 {
	public static void main(String[] args) throws IOException {
		//객체 중에는 "내가 만든 클래스의 객체"도 있다
		//- 내가 만든 클래스의 객체를 출력해보자!
		//- 원래 객체 입출력은 아무 객체나 되는 것이 아니라 "인증마크(자격)"가 있어야 한다
		
		Student stu = new Student("홍길동", 90);
		
		File target = new File("file", "student.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//object라는 통로에 stu를 출력
		object.writeObject(stu);
		
		//통로 닫기
		//object.flush();
		object.close();
	}
}