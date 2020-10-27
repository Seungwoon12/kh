package api.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		//사다리 타기 게임 만들기
		//1. 인원수 설정(2~24)
		//2. 이름과 항목을 입력
		//3. 사다리가 나오고 애니메이션 추첨(만들 필요가 없음)
		//4. 추첨 결과가 출력
		
		
		//1번 작업
		int people = 3;
		
		//2번 작업
		//이름3번 + 항목3번 입력 후 저장
		// -> 이름과 항목을 같이 저장할건지 아니면 따로 저장할건지 정해야 한다
		// -> 이름과 항목은 형태만 같고 다른 데이터이므로 따로 저장하도록 구현
		List<String> names = new ArrayList<>();
		List<String> actions = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		//이름 입력
		for(int i=0; i<people; i++) {
			System.out.println("이름 입력");
			names.add(sc.next());
		}
		
		//항목 입력
		for(int i=0; i<people; i++) {
			System.out.println("항목 입력");
			actions.add(sc.next());
		}
		
		sc.close();
		
		
		//3번 생략, 4번 작업
		//- 네이버 사다리 보니까 actions만 섞으면 될 것으로 판단됨
		Collections.shuffle(actions);
		//System.out.println("names = "+names);
		//System.out.println("actions = "+actions);
		
		for(int i=0; i<people; i++) {
			System.out.println(names.get(i) + " → " + actions.get(i));
		}
	}
}