package thread;

public class Test06 {
	public static void main(String[] args) {
		Runnable r = () -> {
			System.out.println("커스텀 스레드!");
		};
		
		
		Thread t = new Thread(r);
		t.setDaemon(true);
		t.start();
		
		System.out.println("메인 스레드!");
	}
}
