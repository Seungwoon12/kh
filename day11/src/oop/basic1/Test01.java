package oop.basic1;

public class Test01 {
	public static void main(String[] args) {
		
		Message a = new Message();
		
		a.sender = "초롱초롱 라이언";
		a.text = "응 먹고 들가는중";
		a.time = "오후 12:29";
		a.read = 0;
		
		System.out.println(a.sender);
		System.out.println(a.text);
		System.out.println(a.time);
		System.out.println(a.read);
		
		
		
		Message b = new Message();
		
		System.out.println(b.sender);
		System.out.println(b.text);
		System.out.println(b.time);
		System.out.println(b.read);
	}
}
