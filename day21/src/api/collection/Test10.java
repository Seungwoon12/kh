package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test10 {
	public static void main(String[] args) {
//		List를 내가 원하는 방식으로 정렬하는 방법(custom sort)
//		목표 : list를 "내림차순"으로 정렬
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		System.out.println(list);
		
//		Collections.sort(list);//오름차순
		
//		내림차순 처럼 별도의 정렬방식을 구현하려면 정렬에 해당하는 객체를 생성
//		= Comparator라는 인터페이스를 익명중첩클래스 형태로 생성하여 코드를 작성
//		= 재정의한 메소드에서 0을 반환하게 되면 현상유지를 하라는 뜻(통과)
//		= 재정의한 메소드에서 양수를 반환하게 되면 두 자리를 바꾸라는 뜻(잘못된 상태)
//		= 재정의한 메소드에서 음수를 반환하게 되면 두 자리를 유지하라는 뜻(올바른 상태)
//		Comparable, Comparator
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;//내림차순
//				return o1 - o2;//오름차순
//				if(o2 > o1) {//뒤에값이 더 크면
//					return 1;
//				}
//				else {//아니면
//					return -1;
//				}
			}
		};
		
		Collections.sort(list, c);//c에서 시키는대로 정렬해라!
		
		System.out.println(list);
		
//		람다(lambda)를 이용한 Comparator 생성
		Comparator<Integer> d = (o1, o2)-> o1 - o2;
		Collections.sort(list, d);//list를 d라는 방식으로 정렬
		System.out.println(list);
	}
}