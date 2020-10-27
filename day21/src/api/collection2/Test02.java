package api.collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		//회원을 저장하는 리스트 구현
		List<Member> list = new ArrayList<>();
		
		//데이터 추가
		list.add(new Member("tester", "test1234"));
		list.add(new Member("master", "master1234"));
		list.add(new Member("user", "user1234"));
		list.add(new Member("student", "student1234"));
		list.add(new Member("admin", "admin1234"));

		//정렬
//		Collections.sort(list);//Member를 어떻게 정렬해야할지 모르기 때문에 오류!
		
//		회원(Member)을 비교하는 기준을 객체로 만든다
//		Comparator<Member> c = new Comparator<Member>() {
//			@Override
//			public int compare(Member a, Member b) {
//				return a.getId().compareTo(b.getId());//a.id - b.id
//			}
//		};
		
//		Comparator<Member> c = (a, b)->{
//			return a.getId().compareTo(b.getId());
//		};
		
		Comparator<Member> c = (a, b) -> a.getId().compareTo(b.getId());
		Collections.sort(list, c);
		
		//출력
		for(Member member : list) {
			member.print();
//			System.out.println(member.getId());
//			System.out.println(member.getPassword());
		}
	}
}