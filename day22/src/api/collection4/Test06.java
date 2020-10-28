package api.collection4;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//Iterator : 반복자. 특정 저장소를 자동으로 순회하고 싶을 때 사용
		String str = "빨강 주황 노랑 초록 파랑 남색 보라";
		Scanner sc = new Scanner(str);
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
	}
}