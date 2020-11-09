package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame19 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//목표 : 윈도우(프레임)에 이벤트를 설정해서 상태를 확인
		//- iconified : 최소화
		//- activated : 활성화
		WindowListener w = new WindowListener() {
			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified");
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified");
			}
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated");
			}
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("windowOpened");
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				
				//확인창을 띄우고 확인을 누르면 프로그램을 종료
				JOptionPane.showMessageDialog(root, "프로그램이 종료됩니다");
				
				//setVisible(false);
				dispose();
				//System.exit(0);
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed");
			}
		};
		
		//프레임(this)에 윈도우 이벤트 처리기 연결
		this.addWindowListener(w);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame19() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 19");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test19 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame19 frame = new MyFrame19();
	}
}