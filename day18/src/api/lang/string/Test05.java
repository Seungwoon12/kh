package api.lang.string;

public class Test05 {
	public static void main(String[] args) {
		//	문자열 편집기능
		// - 대문자를 소문자로 변환 : toLowerCase()
		// - 소문자를 대문자로 변환 : toUpperCase()
		String address = "HTTP://WWW.NAVER.COM";
		
		System.out.println(address);
		System.out.println(address.toLowerCase());
		
		//불필요한 여백 제거(앞-left / 뒤-right) : trim()
		// - 주의 : 글자 사이의 여백은 제거할 수 없음.
		// - 입력창을 이용할 때 유용하게 사용가능
		// - 통신에서 불필요하게 전송되는 여백을 제거
		
		String address2 = "      HTTP://WWW.NAVER.COM      ";
		System.out.println(address2);
		System.out.println(address2.trim().toLowerCase()); // 연쇄호출(메소드 체이닝, ,method chaning)
		
		// 문자열 자르기 : substring()
		String name = "최번개";
		System.out.println(name);
//		String firstname = name.substring(1, 3);
		String firstname = name.substring(1); //1부터 끝까지
		String lastname = name.substring(0, 1);
		System.out.println("이름 : "+firstname);
		System.out.println("성 : "+lastname);
	}
}
