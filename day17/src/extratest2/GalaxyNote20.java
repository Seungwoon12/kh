package extratest2;

public class GalaxyNote20 extends Phone {
	
	public GalaxyNote20(String number) {
		super(number);
	}
	public GalaxyNote20(String number, int price) {
		super(number, price);
	}

	@Override
	public void call() {
		System.out.println("갤럭시 노트로 전화를 겁니다!");
		
	}

	@Override
	public void text() {
		System.out.println("갤럭시 노트로 문자를 보냅니다!");
		
	}
}
