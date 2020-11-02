package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

public class Test04_1 {
	public static void main(String[] args) throws Exception{
		//입력
		
		File target = new File("file", "numbers.kh");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream object = new ObjectInputStream(buffer);
		
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) object.readObject();
		//경고의 이유 : 읽어온 객체가 리스트(상자)라는 것은 알겠는데, 내용물까지는 책임질 수 없다라는 의미의 경고
		// - 제네릭은 다운캐스팅시 고려되지 않는다(경고 발생)
		// - 원천적으로 해결은 불가능하며, 오류를 안보도록 표시하는 방법은 있다
		
		object.close();
		
		System.out.println(list);
	}
}
