package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame15 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JLabel label = new JLabel("Hello Java!", JLabel.CENTER);
	
	private JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	private JButton red = new JButton("빨강");
	private JButton blue = new JButton("파랑");
	private JButton close = new JButton("닫기");
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);

		root.setLayout(new BorderLayout());
		
		root.add(label, BorderLayout.CENTER);
		root.add(bottom, BorderLayout.SOUTH);
		
		bottom.add(red);
		bottom.add(blue);
		bottom.add(close);
		
		Font font = new Font("", Font.BOLD, 50);
		label.setFont(font);		
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//설정해야할 이벤트 3개 : 처리객체(ActionListener) 3개 + 연결코드 3개
		ActionListener ac1 = e->{
			//글자를 빨강으로 변하게 하는 코드 = 라벨에 글자색을 빨강으로 설정
			//label.setForeground(Color.red);
			
			//라벨은 기본적으로 배경이 투명이므로 배경색을 아무런 조치없이 설정하면 보이질않는다
			// -> 배경을 불투명하게 바꾸는 설정을 추가적으로 해야한다.
			// -> .setOpaque(true);
			label.setOpaque(true);
			label.setBackground(Color.red);
		};
		red.addActionListener(ac1);
		
		ActionListener ac2 = e->{
			//글자를 파랑으로 변하게 하는 코드 = 라벨에 글자색을 파랑으로 설정
			//label.setForeground(Color.blue);
			label.setOpaque(true);
			label.setBackground(Color.blue);
		};
		blue.addActionListener(ac2);
		
		ActionListener ac3 = e->{
			//창을 닫는 코드
			dispose();
			//System.exit(0);//시스템을 종료하는 코드
		};
		close.addActionListener(ac3);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame15() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 15");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Test15 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame15 frame = new MyFrame15();
	}
}
