package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame14 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JButton exit = new JButton("종료!");
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		root.add(exit);
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
//		목표 : exit를 누르면 프로그램을 종료하고 싶다
//		ActionListener a = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		};
		
//		ActionListener는 "메소드가 한개뿐인 함수형 인터페이스"이므로 "람다"를 사용할 수 있다
		ActionListener a = (e)->{
			System.exit(0);
		
		};
		
		exit.addActionListener(a);//exit를 눌렀을 때 a가 가진 코드를 실행하도록 연결해라!(event bind)
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame14() {
		this.place();
		this.event();
		this.setTitle("GUI 예제 14");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Test14 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame14 frame = new MyFrame14();
	}
}