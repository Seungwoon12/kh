package loop;

public class Test12 {
	public static void main(String[] args) {
		long money = 1L;
		long total = 0L;
		for(int day=1 ; day<=40 ; day++) {
			total += money;
			money *= 2;
		}
		System.out.println(total+"원");
	}
}
