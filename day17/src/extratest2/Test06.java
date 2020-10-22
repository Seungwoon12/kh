package extratest2;

public class Test06 {
	public static void main(String[] args) {
		//무작위 핸드폰 5개 생성(반복문)
		
		Phone[] list = new Phone[5];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new Iphone12("010-1234-2345");
		}
		
		for(int i=0; i<list.length; i++) {
			list[i].call();
			list[i].text();
		}
		
		
	}
}
