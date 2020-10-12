package loop2;

public class Test05 {
	public static void main(String[] args) {
		int height = 15;
		double length = 0;
		int day = 0;
		while(true) {	
			if(length < height) {
				length += 3;
				day++;
				if(length >= height) {
					break;
				}
			}
			length -= 2.5;
		}
		System.out.println(day);
	}
}
