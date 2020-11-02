package oop.inherit4;

public class Chrome extends Browser{

	public Chrome(String url, String version) {
		//super()는 첫줄에서 단 한번만 부를 수 있다(this()도 마찬가지)
		super(url, version);
	}
	
	//Browser에 없는 필요한 내용을 추가적으로 정의
	public void develop() {
		System.out.println("개발자도구 실행!");
	}

}
