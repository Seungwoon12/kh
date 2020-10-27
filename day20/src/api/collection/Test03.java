package api.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//List에 숫자를 5개 저장 후 출력
		// - 주의 : Generic에는 Reference Type(참조형) 만 적을 수 있다.
		// - 이유 : null이 포함될 수 있기 때문(원시형 데이터는 null 표현 불가)
		List<Integer> list = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 5개 입력");
		for(int i=0; i<5; i++) {
			int input = sc.nextInt();
			list.add(input);
		}
		sc.close();
		
		System.out.println("데이터 개수 : "+list.size());
		System.out.println(list);
		
		//데이터 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		//선형 저장소라면(Iterable) 확장 반복문을 사용할 수 있다.
		for(int n : list) {
			//n == list.get(i)
			System.out.println(n);
		}
	}
}