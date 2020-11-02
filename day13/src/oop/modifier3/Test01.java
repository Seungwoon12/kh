package oop.modifier3;

public class Test01 {
	public static void main(String[] args) {
		//집 2채 생성
		House h1 = new House();
		House h2 = new House();
		
		h1.setArea("강남");
		h1.setSize(24);
		h1.setPrice(2000);
		
		h2.setArea("독도");
		h2.setSize(100);
		h2.setPrice(5000);
		
		//첫번째 집과 두번째 집 가격의 합계를 출력
		//int total = h1.price + h2.price;
		int total = h1.getPrice() + h2.getPrice();
		System.out.println(total);
		
		//첫번째 집과 두번째 집 중에서 비싼집을 출력
		if(h1.getPrice() > h2.getPrice()) {
			System.out.println(h1.getArea()+"에 있는 집이 비쌉니다");
		}
		else if(h1.getPrice() < h2.getPrice()){
			System.out.println(h2.getArea()+"에 있는 집이 비쌉니다");
		}
		else {
			System.out.println("같은 가격입니다");
		}
	}
}