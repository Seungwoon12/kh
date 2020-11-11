package thread;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) {
		//멀티 스레드
		// - Thread의 객체를 생성해야한다
		// - 만들 때 실행할 코드를 알려줘야 한다(익명중첩클래스)
		//		- .run() 재정의해서 작성한다
		// - .start()로 구동하도록 지시한다
		// 익명중첩클래스는 메소드안에 예외를 전가 못함 try/catch로 처리해야함 ex) 아래 Thread.sleep 의 경우
		
		Thread t = new Thread() {
			public void run() {
				//이 영역에 작성하면 t가 처리합니다(별도의 스레드)
				for(int i=1; i<=100; i++) {
					System.out.println("i = " + i);
					
					try {
						Thread.sleep(500);
					} 
					catch (Exception e) {}
				}
			}
		};
		t.start();
		
		//이 영역에 작성하면 main이 처리합니다(main thread)
		JOptionPane.showMessageDialog(null, "안녕");
	}
}