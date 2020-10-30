package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) throws IOException {
		//바이트 배열 입력
		//준비물 : 파일 객체, 입력용 스트림, 저장공간(바이트 배열, 버퍼)
		// - 배열 크기를 얼마로 하는게 좋을까?
		
		File target = new File("file", "array.test");
		FileInputStream in = new FileInputStream(target);
		byte[] data = new byte[6];
		
		//예상 : 총20글자 = 6 + 6 + 6 + 2
		//배열로 입력받을 때 가장 큰 문제는 몇개를 읽었는지 알아내야 한다는 것
		int size;
		size = in.read(data);//준비된 data에 되는대로 채워넣어라(6개)
		System.out.println(size);
		System.out.println(Arrays.toString(data));
		
		size = in.read(data);//준비된 data에 되는대로 채워넣어라(6개)
		System.out.println(size);
		System.out.println(Arrays.toString(data));
		
		size = in.read(data);//준비된 data에 되는대로 채워넣어라(6개)
		System.out.println(size);
		System.out.println(Arrays.toString(data));
		
		size = in.read(data);//준비된 data에 되는대로 채워넣어라(2개)
		System.out.println(size);
		System.out.println(Arrays.toString(data));
		
		size = in.read(data);//준비된 data에 되는대로 채워넣어라(0개)
		System.out.println(size);
		System.out.println(Arrays.toString(data));
		
		in.close();
	}
}