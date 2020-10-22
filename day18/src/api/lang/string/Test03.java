package api.lang.string;

public class Test03 {
	public static void main(String[] args) {
		// 포함 검사
		// ex) : "http://www.naver.com"에 "naver"라는 글자가 있습니까?
		// - contains() : 단순하게 포함되었는지 아닌지만 확인
		// - indexOf() : / lastIndexOf() : 포함된 위치를 알 수 있음.
		
		String url = "http://www.naver.com";
		System.out.println(url.contains("naver"));
		System.out.println(url.indexOf("naver")); //앞에서 부터
		System.out.println(url.lastIndexOf("naver")); //뒤에서 부터
		
		//여러개를 찾고 싶으면
		System.out.println(url.indexOf(".")); //처음부터 .을 찾아라 = 10
		System.out.println(url.indexOf(".", 11)); //11번위치부터 .을 찾아라 = 16
	}
}
