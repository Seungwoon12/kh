package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test05 {
	public static void main(String[] args) {
		//List등 Collection을 보조하는 클래스 : Collections
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		//List도 배열처럼 순서가 중요하기 때문에 순서와 관련된 조작이 필요
		// - 직접하기는 어려우니 도구를 활용해서 처리
		
		//1. 순서 뒤집기(reverse)
		Collections.reverse(list);
		System.out.println(list);
		
		//2. 뒤섞기(shuffle)
		Collections.shuffle(list);
		System.out.println(list);
		
		//3. 정렬(sort)
		Collections.sort(list);
		System.out.println(list);
		
	}
}