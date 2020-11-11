package thread;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame08 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JButton left = new JButton("버튼1");
	private JButton right = new JButton("버튼2");
	
	//스레드 생성
	//1번 스레드 : left의 색상을 2초마다 변경
	private Runnable r1 = ()->{
		int n = 0;
		while(true) {
			if(n % 2 == 0) {
				left.setBackground(Color.red);
			}
			else {
				left.setBackground(null);
			}
			
			try {
				Thread.sleep(2000L);
			}catch(Exception e) {
				break;
			}
			
			n++;
		}
	};
	private Thread t1 = new Thread(r1);
	
	//2번 스레드 : right의 색상을 3초마다 변경
	private Runnable r2 = ()->{
		int n = 0;
		while(true) {
			if(n % 2 == 0) {
				right.setBackground(Color.blue);
			}
			else {
				right.setBackground(null);
			}
			
			try {
				Thread.sleep(3000L);
			}catch(Exception e) {
				break;
			}
			
			n++;
		}
	};
	private Thread t2 = new Thread(r2);
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		root.setLayout(new GridLayout(1, 2));
		
		root.add(left);
		root.add(right);
		
		t1.setDaemon(true);
		t1.start();
		t2.setDaemon(true);
		t2.start();
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		
		left.addActionListener(e -> {
			t1.interrupt();
		});
		
		right.addActionListener(e -> {
			t2.interrupt();
		});
		
		
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame08() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 08");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test08 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame08 frame = new MyFrame08();
	}
}