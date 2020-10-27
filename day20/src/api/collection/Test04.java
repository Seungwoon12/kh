package api.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
//		로또번호 6개 저장 후 출력
		List<Integer> lotto = new LinkedList<>();
		
//		랜덤 채우기(1부터 45 사이의 정수)
		Random r = new Random();
		
//		주의 : i<list.size() 라고 작성하면 단 한번도 실행되지 않는다
		for(int i=0; i < 6; i++) {
			int num = r.nextInt(45) + 1;
			if(!lotto.contains(num)) {
				lotto.add(num);
			}
			else {
				System.out.println("중복");
				i--;
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