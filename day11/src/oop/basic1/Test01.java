package oop.basic1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		//메세지(객체)를 1개 생성
		//- new : 신규 주문 제작(동적 할당 연산자)
		Message a = new Message();
		
		a.sender = "초롱초롱 라이언";
		a.text = "응 먹고 들어가는중";
		a.time = "오후 12:29";
		a.read = 0;
		
		System.out.println(a);//리모컨
		System.out.println(a.sender);
		System.out.println(a.text);
		System.out.println(a.time);
		System.out.println(a.read);
		
		//메세지(객체) 1개 추가 생성
		Message b = new Message();
		
		System.out.println(b.sender);
		System.out.println(b.text);
		System.out.println(b.time);
		System.out.println(b.read);
	}
}
