package oop.modifier1;

public class Test01 {
	public static void main(String[] args) {
		Bag b1 = new Bag();
		
		//정보 설정 시 setter메소드를 쓰도록 하는 것이 좋다
		// = 강제가 아니고 권장사항
		// = 이용자가 선택이 가능함
		// = 강제로 setter메소드를 쓸 수밖에 없도록 만들어야한다
		
		//아래처럼 변수접근은 이제부터 불가
//		b1.name = "구찌 마틀라세";
//		b1.price = 2000000;
		
		//메소드를 통한 접근만 허용
//		b1.setName("구찌 마틀라세");
//		b1.setPrice(2000000);
		b1.info("구찌 마틀라세", 2000000);
		
		b1.print();
	}
}