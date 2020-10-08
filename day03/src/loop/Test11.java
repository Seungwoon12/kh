package loop;

public class Test11 {
	public static void main(String[] args) {
		int total = 0;
		int pushup = 10;
		
		for(int i=1; i<=30; i++) {
			total += pushup;
			pushup += 3;
		}
		System.out.println(total
				);
	}
}
