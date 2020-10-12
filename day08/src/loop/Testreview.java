package loop;

public class Testreview {
	public static void main(String[] args) {
		long total = 0L;
		long start = 1L;
		for(int day=1 ; day<=40 ; day++) {
			total += start;
			start *= 2;
		}
		System.out.println(total);
	}
}
	