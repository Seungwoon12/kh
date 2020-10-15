package oop.modifier3;

public class Test01 {
	public static void main(String[] args) {
		House h1 = new House();
		House h2 = new House();
		House h3 = new House();
		
		h1.setArea("강남");
		h1.setSize(24);
		h1.setPrice(2000);
		
		h2.setArea("독도");
		h2.setSize(100);
		h2.setPrice(5000);
		
		int total = h1.getPrice() + h2.getPrice();
		System.out.println(total);
		
		if(h1.getPrice() > h2.getPrice()) {
			System.out.println(h1.getArea()+" 집 값이 더 비싸요");
		}
		else if(h1.getPrice() < h2.getPrice()) {
			System.out.println(h2.getArea()+" 집 값이 더 비싸요");
		}
		else {
			System.out.println("집 값이 동일해요");
		}
	}
}
