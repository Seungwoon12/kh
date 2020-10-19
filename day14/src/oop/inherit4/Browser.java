package oop.inherit4;

public class Browser {
	protected String url;
	protected String version;
	
	public Browser(String url, String version) {
		this.url = url;
		this.version = version;
	}

	
	public final void move() {
		System.out.println("다른 페이지로 이동합니다.");
	}
	public final void refresh() {
		System.out.println("새로고침을 시도합니다.");
	}		
}
