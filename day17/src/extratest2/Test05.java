package extratest2;

public class Test05 {
	public static void main(String[] args) {
		//무작위 핸드폰 5개 생성(no 반복문)
		Phone[] list = new Phone[5];
		
		list[0] = new Iphone12("010-1234-5678");
		list[1] = new GalaxyNote20("010-1234-5678");
		list[2] = new Iphone12("010-1234-5678");
		list[3] = new GalaxyNote20("010-1234-5678");
		list[4] = new Iphone12("010-1234-5678");
		
		list[0].call();		list[0].text();
		list[1].call();		list[1].text();
		list[2].call();		list[2].text();
		list[3].call(); 	list[3].text();
		list[4].call(); 	list[4].text();
	}
}
