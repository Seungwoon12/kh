package api.collection3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02 {
	public static void main(String[] args) {
		//문제
		//1. 로또번호 6개를 중복없이 추첨해서 저장소에 저장하라
		//2. 저장된 번호들을 내림차순이 되도록 구현하라!
		
		//주의사항 : Set은 순서가 무시되는 저장소이므로 순서와 관련된 모든 명령이 사용 불가하다(sort, shuffle, reveser)
		
		//Comparator<Integer> c = (a, b) -> b - a;
		//Set<Integer> lotto = new TreeSet<>(c);
		Set<Integer> lotto = new TreeSet<>((a, b) -> b - a);
		
		Random r = new Random();
		
		while(lotto.size() < 6) {
			int n = r.nextInt(45) + 1;
			lotto.add(n);
		}
		
		//Collections.sort(lotto, c);//불가능
		
		//lotto에 들어있는 데이터들을 한바퀴에 한 개씩 n이라는 변수에 담아주세요(전체반복)
		//- 부분반복이 불가(전체만 가능)
		for(int n : lotto) {
			System.out.println("번호 : " + n);
		}
	}
}