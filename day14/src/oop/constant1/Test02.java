package oop.constant1;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Random r = new Random();
		int com = r.nextInt(3/*개*/) + 1/*부터*/;
		System.out.println("com = "+com);
		
		switch(com) {
		case RSP.가위:
			System.out.println("가위!");
			break;
		case RSP.바위:
			System.out.println("바위!");
			break;
		case RSP.보자기:
			System.out.println("보자기!");
			break;
		}
	}
}