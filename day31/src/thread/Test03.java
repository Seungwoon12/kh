package thread;

import javax.swing.JOptionPane;

public class Test03 {
	public static void main(String[] args) throws InterruptedException {
		//기본적으로 하나의 스레드는 동시에 한 개의 작업을 수행할 수 있다.
		//작업이 늘어나면 순서대로 진행된다는 특징을 가진다
		
		//싱글 스레드 : 스레드 1개
		
		JOptionPane.showMessageDialog(null, "안녕");
		
		for(int i=1; i<=100; i++) {
			System.out.println("i = " + i);
			Thread.sleep(500);
		}
	}
}