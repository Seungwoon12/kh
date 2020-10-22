package extratest2;

public class Iphone12 extends Phone {
	
	public Iphone12(String number) {
		super(number);
	}

	@Override
	public void call() {
		System.out.println("아이폰으로 전화를 겁니다!");
		
	}

	@Override
	public void text() {
		System.out.println("아이폰으로 문자를 보냅니다!");
		
	}
	
}
