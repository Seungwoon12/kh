package api.collection3;

import java.util.HashSet;
import java.util.Set;

public class Test04 {
	public static void main(String[] args) {
		//각각 본 영화를 준비
		Set<String> chulsoo = new HashSet<>();
		Set<String> yeonghee = new HashSet<>();
		chulsoo.add("살아있다");
		chulsoo.add("반도");
		chulsoo.add("다만 악에서 구하소서");
		chulsoo.add("다크나이트");
		chulsoo.add("단 하루의 기적");
		
		yeonghee.add("다크나이트");
		yeonghee.add("사바하");
		yeonghee.add("테넷");
		yeonghee.add("반도");
		yeonghee.add("살아있다");
		
		System.out.println(chulsoo);
		System.out.println(yeonghee);
		
		//1. 둘다 본 영화 - 교집합(retainAll)
		Set<String> a = new HashSet<>(chulsoo);
		a.retainAll(yeonghee);
		System.out.println(a);
		
		//2. 철수만 본 영화 - 차집합(removeAll) : 철수 - 영희
		Set<String> b = new HashSet<>();
		b.addAll(chulsoo);
		b.removeAll(yeonghee);
		System.out.println(b);
		
		//3. 영희만 본 영화 - 차집합(removeAll) : 영희 - 철수
		Set<String> c = new HashSet<>();
		c.addAll(yeonghee);
		c.removeAll(chulsoo);
		System.out.println(c);
		
		//4. 철수 또는 영희 중 한명이라도 본 영화(addAll) : 영희 ∪ 철수
		Set<String> d = new HashSet<>();
		d.addAll(chulsoo);
		d.addAll(yeonghee);
		System.out.println(d);
	}
}