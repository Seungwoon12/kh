package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//프레임워크 : 강력한 규칙으로 사용자가 그대로 이용할 수 밖에 없도록 만들어진 도구 모음
		//자바 컬렉션 프레임워크(JCF) : 자바에서 대용량 데이터를 관리하기 위해 만들어진 프레임워크
		
		//전화번호부 형식의 저장소 : 순서가 무시
		Set a = new TreeSet();
		
		//코로나명부 형식의 저장소 : 순서가 유지
		List b = new ArrayList();
		
		//데이터 추가 : .add()
		a.add("태연");
		a.add("박효신");
		a.add("박정민");
		a.add("한지민");
		a.add("나은");
		
		b.add("태연");
		b.add("박효신");
		b.add("박정민");
		b.add("한지민");
		b.add("나은");
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
}