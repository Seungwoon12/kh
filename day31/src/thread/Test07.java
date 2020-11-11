package thread;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame07 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
	}
	
	public void event() {
		
	}
	
	public void menu() {
		
	}
	
	public void title() {
		
		Thread t = new Thread() {
			@Override
			public void run() {
				while(true) {
					Date d = new Date();
					Format f = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
					MyFrame07.this.setTitle(f.format(d));
					
					try {
						Thread.sleep(1000L);
					}
					catch(Exception e) {}
				}
				
			}
		};
		t.setDaemon(true);
		t.start();
		
	
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame07() {
		this.place();
		this.event();
		this.menu();
		this.title();
//		this.setTitle("GUI 예제 07");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Test07 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame07 frame = new MyFrame07();
	}
}
