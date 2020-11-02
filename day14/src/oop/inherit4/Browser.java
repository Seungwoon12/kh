package oop.inherit4;

//브라우저 클래스(상위 클래스)
// - 변수, 메소드, 생성자
public class Browser {
	//멤버 변수 
	protected String url;
	protected String version;
	
	//생성자 : url, version이 반드시 설정되도록 구현
	public Browser(String url, String version) {
		this.setUrl(url);
		this.setVersion(version);
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	//메소드 : 재정의 여부
	// - 모든 브라우저가 동일해야하는 기능이라면 final 추가
	// - 브라우저마다 달라질 수도 있다고 생각한다면 final 제거
	public final void move() {
		System.out.println("페이지를 이동합니다!");
	}
	public final void refresh() {
		System.out.println("페이지를 새로고침합니다!");
	}
}
