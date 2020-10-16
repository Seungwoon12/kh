package oop.final1;

//Window는 프로그램 창을 말함
public class Window {
	private int x;//변할 수 있음
	private int y;//변할 수 있음
	
//	아래와 같이 구현하면 이 클래스의 모든 객체는 width=600,height=480이 됨
//	private final int width = 600;//변할 수 없음
//	private final int height = 480;//변할 수 없음
	
//	만약 최초 1회만 설정하고 이후에 수정이 안되게 하고 싶다면
//	= 생성자을 이용하여 값의 설정과 관련된 문제를 해결한다!
//	= 모든 생성자에서 width,height를 초기화해줘야 문제가 생기지 않는다
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