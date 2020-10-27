  
package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test06 {
	public static void main(String[] args) {
		//저장소를 만들고 친구들을 추가
		List<String> friends = new ArrayList<>();
		friends.add("철수");
		friends.add("영희");
		friends.add("영수");
		friends.add("민지");
		friends.add("미영");
		friends.add("민수");
		
		Collections.shuffle(friends);
		System.out.println(friends);
		
		//무작위로 섞인 friends 저장소에서 데이터를 2개 추첨 = String을 2개 추첨
		//무작위로 섞인 friends 저장소에서 데이터 2개 묶음을 추첨 = List<String> 추첨
		String a = friends.get(0);
		String b = friends.get(1);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		List<String> sub = friends.subList(0, 2);
		System.out.println(sub);
	}
}