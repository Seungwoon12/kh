package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame16 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JButton bt = new JButton("눌러!");

	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		
		root.add(bt);
		
		//버튼의 크기를 강제로 설정
		bt.setPreferredSize(new Dimension(200, 80));
		
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//버튼에 마우스 이벤트를 설정
		//- MouseListener는 메소드가 5개라서 1개만 쓰더라도 5개를 다 재정의 해야함
		//- 이러한 불편사항을 해결하기 위해 메소드가 2개 이상인 Listener는 Adapter가 존재함
		//- 이벤트 처리객체로 MouseAdapter를 만들면 원하는 처리메소드만 재정의해서 사용이 가능하다
		MouseListener mou = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click");
				dispose();
			}
		};
		
		//bt에 마우스 청취자로 mou를 설정
		bt.addMouseListener(mou);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame16() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 16");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test16 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame16 frame = new MyFrame16();
	}
}