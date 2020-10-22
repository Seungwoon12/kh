package extratest2;

import java.util.Random;

public class Test07 {
	public static final int GalaxyNote20 = 0;
	public static final int Iphone12 = 1;
	
	public static void main(String[] args) {
		
		Phone[] list = new Phone[5];
		
		Random r = new Random();
		
		for(int i=0; i < list.length; i++) {
			int choice = r.nextInt(2) + 0;
			
			if(choice == 0) {
				list[i] = new GalaxyNote20("010-1234-5678");
			}
			else {
				list[i] = new Iphone12("010-1234-5678");
			}
			
		
		}
		
		for(int i=0; i<list.length; i++) {
			list[i].call();
			list[i].text();
		}
		
		
		
	}
}
