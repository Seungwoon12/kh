package api.lang.string;

public class Test07 {
	public static void main(String[] args) {
		// 문자열 편집(2)
		// - 문자열 분해 : 구분자(delim)을 이용하여 문자열 분해
		// 분해한 결과물의 자료형은 문자열 여러개(String[])다. cf) String[]은 "스트링 배열"라고 함
		String colors = "빨/주/노/초/파/남/보";
		String[] token = colors.split("/");
		System.out.println(token.length);
		
		for(int i=0; i<token.length; i++) {
			System.out.println(token[i]);
		}
		
		String email = "student@khacademy.com";
		String[] part = email.split("@"); //@를 기준으로 분할
		System.out.println("앞부분 : "+part[0]);
		System.out.println("뒷부분 : "+part[1]);
		
		//문자열 치환: 특정글자를 원하는 모양으로 변경 : replace()
		// 욕설 필터링 등에 활용 가능
		String text = "나는 피자가 좋아요";
		String text2 = text.replace("피자", "자바");
		System.out.println(text);
		System.out.println(text2);
	}
}
