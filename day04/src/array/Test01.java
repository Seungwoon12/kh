package array;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		/*
			배열(Array)
			- 여러 개의 데이터를 묶음으로 관리하는 저장소
			- 변수의 모음
			- 기존에는 1명의 점수를 입력받아 계산 또는 출력(낱개)
			- 배열에서는 10명,20명,5000명의 점수를 입력받아 계산 또는 출력(묶음)
			- 필연적으로 반복문이 등장할 수 밖에 없음
			- 배열의 목표는 일괄 / 묶음 처리
			- 참조형
		*/
		
		// 변수를 만드는 방법(ex : 10이라는 숫자를 저장)
		int a = 10;
		
		// 배열을 만드는 방법(ex : 10, 20, 30, 40, 50이라는 숫자를 저장)
		// - 5칸짜리 배열을 생성(각각의 칸이 변수)
		int[] b = new int[5];
		System.out.println(b.length);//배열의 칸 수(자동계산)
		
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		b[3] = 40;
		b[4] = 50;
//		b[5] = 60;//없는 위치
		
//		System.out.println(b);//의미없음
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
		System.out.println(b[4]);
//		System.out.println(b[5]);//없는 위치
	}
}