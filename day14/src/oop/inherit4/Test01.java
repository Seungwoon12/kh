package oop.inherit4;

public class Test01 {
	public static void main(String[] args) {
		Chrome c = new Chrome("https://www.google.com/", "v20");
		Edge e = new Edge("https://www.naver.com/", "v20");
		c.move();
		c.refresh();
		c.develop();
		
		e.move();
		e.refresh();
		e.windows();
	
	}
}
