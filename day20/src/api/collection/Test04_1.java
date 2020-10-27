package api.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test04_1 {
	public static void main(String[] args) {
//		로또번호 6개 저장 후 출력
		List<Integer> lotto = new LinkedList<>();
		
//		랜덤 채우기(1부터 45 사이의 정수)
		Random r = new Random();
		
//		중복이 생기건 안생기건 간에 size()를 기준으로 반복을 진행
//		- 횟수는 모르지만 종료 시점은 size() == 6
//		- 반대로 실행 시점은 size() < 6
		while(lotto.size() < 6) {
			int num = r.nextInt(45) + 1;
			if(!lotto.contains(num)) {//없으면
				lotto.add(num);
			}
		}
		
//		출력
		System.out.println(lotto);
//		for(int i=0; i < lotto.size(); i++) {
//			System.out.println(lotto.get(i));
//		}
		for(int n : lotto) {
			System.out.println("번호 : "+n);
		}
	}
}