package extratest2;

public class Test04 {
	public static void main(String[] args) {
		//아이폰 5개 생성(반복문 사용)
		Iphone12[] apple = new Iphone12[5];
		
		for(int i=0; i<apple.length; i++) {
			apple[i] = new Iphone12("010-1234-5678");
		}
		
		for(int i=0; i < apple.length; i++) {
			apple[i].call();
			apple[i].text();
		}
		
	}
}
