package thread;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) {
		//쓰레드 사용 시 주의사항
		//- 만들 때 필요한 설정을 다 해야한다
		//- 구동하기 시작하면 관리가 매우 어려움
		//- 종속관계를 설정하지 않으면 메인과 무관하게 할일을 진행하는 문제가 발생
		//		- .setDaemon()
		//		- 스레드가 10개일 때 9개만 설정할 수 없음(할거면 다 해야함)
		
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
		t.setDaemon(true);//t에게 종속관계를 설정(메인 퇴근하면 같이 퇴근하도록 계약)
		t.setName("종업원1");//t에게 "종업원1"이라는 이름을 부여
		t.setPriority(Thread.MAX_PRIORITY);//t에게 "우선순위" 설정(1:낮음,10:높음,5:보통)
		t.start();
		
		//이 영역에 작성하면 main이 처리합니다(main thread)
		JOptionPane.showMessageDialog(null, "안녕");
	}
}