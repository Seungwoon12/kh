package api.collection4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test06_2 {
	public static void main(String[] args) {
		//Iterator : 반복자. 특정 저장소를 자동으로 순회하고 싶을 때 사용
		// - 데이터 1개를 추가하는 저장소라면 전부다 사용이 된다
		Set<String> set = new HashSet<>();
		set.add("빨강");
		set.add("주황");
		set.add("노랑");
		set.add("초록");
		set.add("파랑");
		set.add("남색");
		set.add("보라");
		
		//Iterator는 만드는게 아니라 얻어내는 것
		// - Iterator에는 제네릭 형태를 반드시 지정해야한다
		// - Iterator를 이용하면 "전체를 추출"할 수 있다
		// - 확장 반복문과 하는행동이 비슷하다
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
		for(String str : set) {
			System.out.println(str);
		}
	}
}