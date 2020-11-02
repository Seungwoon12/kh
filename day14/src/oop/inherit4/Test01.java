package oop.inherit4;

public class Test01 {
	public static void main(String[] args) {
		Chrome chrome = new Chrome("http://www.naver.com", "86.0.4240.75");
		chrome.move();
		chrome.refresh();
		chrome.develop();

		Edge edge = new Edge("http://www.naver.com", "86.0.622.43");
		edge.move();
		edge.refresh();
		edge.windows();
	}
}