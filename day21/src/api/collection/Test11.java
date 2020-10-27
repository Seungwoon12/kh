package api.collection;

public class Test11 {
	public static void main(String[] args) {
//		.compareTo() 알아보기
		String a = "김철수";
		String b = "이민수";
		System.out.println(a.compareTo(b));//a-b
		System.out.println(b.compareTo(a));//b-a
		
		System.out.println('김'-'이');
		System.out.println('이'-'김');
	}
}