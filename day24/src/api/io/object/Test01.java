package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//객체 출력
		//[프로그램] → object → buffer → out → [object.txt]
		File target = new File("file", "object.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream object = new ObjectOutputStream(buffer);
		
		//object는 원시형 데이터 뿐 아니라 객체도 전송할 수 있다
		//- 자료형이 너무 많기 때문에 그냥 Object 형태로 출력
		//- 따라서 명령이 1개
		
		Date d = new Date();
		object.writeObject(d);
		
		//강제 비우기
		object.flush();//비워라
		object.close();//비우고 닫아라
		
	}
}
