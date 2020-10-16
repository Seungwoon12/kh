package oop.final1;

//Window는 프로그램 창을 말함
public class Window {
	private int x;
	private int y;
	
	private final int width;
	private final int height;
	public Window(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public Window(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
