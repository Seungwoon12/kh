package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test08 {
	public static void main(String[] args) {
		//남은 List의 명령
		//- 데이터 삭제 : remove()
		
		List<Integer> list = new ArrayList<>();
		for(int i=10; i<=100; i+=10) {
			list.add(i);
		}

		System.out.println(list);
		
		list.remove(0);//0번 위치 데이터 삭제
		System.out.println(list);
		
		//list.remove(50);//데이터가 아니라 위치로 인식(오류)
		list.remove(new Integer(50));
		list.remove(Integer.valueOf(50));
		System.out.println(list);
		
		//전체 삭제
		list.clear();
		System.out.println(list);
	}
}