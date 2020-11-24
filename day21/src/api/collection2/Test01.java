package api.collection2;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		//목표 : Student를 저장할 수 있는 List 구현
		//Student = String + int
		
		//리스트 생성
		List<Student> list = new ArrayList<>();
		
		//추가 명령 : .add(E)
		// - 데이터를 한 개만 추가할 수 있다
		
//		Student st = new Student("홍길동", 70);
//		list.add(st);
		
		list.add(new Student("홍길동", 70));
		
		list.add(new Student("피카츄", 90));
		list.add(new Student("터미네이터", 50));
		
		//개수 확인 : size()
		System.out.println(list.size());
		System.out.println(list);
		
		//추출 및 출력
		System.out.println(list.get(0));//참조변수(리모컨)
		System.out.println(list.get(0).getName());
		
		Student s = list.get(0);
		System.out.println(s.getName());
		
		//반복문
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getScore());
		}
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			Student stu = list.get(i);
			System.out.println(stu.getName());
			System.out.println(stu.getScore());
		}
		System.out.println();
		for(Student stu : list) {
			System.out.println(stu.getName()); //웹개발에서 가장 많이 나오는 코드
			System.out.println(stu.getScore()); //웹개발에서 가장 많이 나오는 코드
		}
	}
}