package api.collection3;

import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		//Set은 "집합연산"에 특화되어 있다
		// - 합집합 : 두 개의 집합의 합
		// - 교집합 : 두 개의 집합의 곱
		// - 차집합 : 두 개의 집합의 차
		
		Set<Integer> a = new TreeSet<>();
		a.add(10);
		a.add(20);
		a.add(30);
		
		Set<Integer> b = new TreeSet<>();
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		
		//합집합 : 비어있는 Set을 만들어서 a와 b를 몽땅 추가 (addAll)
		Set<Integer> c = new TreeSet<>();
		c.addAll(a);//a를 c에 전부다 추가해라!
		c.addAll(b);//b를 c에 전부다 추가해라!
		System.out.println(c);
		
		//교집합 : retainAll
		Set<Integer> d = new TreeSet<>(a);//a를 복제해서 d를 생성
		d.retainAll(b);//a ∩ b
		System.out.println(d);
		
		//차집합 : removeAll
		Set<Integer> e = new TreeSet<>(a);//a를 복제해서 e를 생성
		e.removeAll(b);//a - b
		System.out.println(e);
	}
}