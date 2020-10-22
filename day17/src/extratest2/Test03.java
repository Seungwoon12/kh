package extratest2;

public class Test03 {
	public static void main(String[] args) {
		//아이폰 5개 생성(no 반복문)
		Iphone12[] apple = new Iphone12[5];
		
		apple[0] = new Iphone12("010-1233-1231");
		apple[1] = new Iphone12("010-1233-1231");
		apple[2] = new Iphone12("010-1233-1231");
		apple[3] = new Iphone12("010-1233-1231");
		apple[4] = new Iphone12("010-1233-1231");
		
		apple[0].call();	apple[0].text();
		apple[1].call();	apple[1].text();
		apple[2].call();    apple[2].text();
		apple[3].call();    apple[3].text();
		apple[4].call();	apple[4].text();
		
	}
}
