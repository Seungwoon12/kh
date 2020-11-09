package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame17 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	//버튼 1개
	private JButton btn = new JButton("0");
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		root.setLayout(new GridLayout());
		root.add(btn);
		Font font = new Font("", Font.BOLD, 100);
		btn.setFont(font);
		btn.setFocusPainted(false); // 버튼 테투리 없애기
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		MouseListener m = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//1.버튼에 써있는 글자를 가져온다
				String text = btn.getText();
				
				int number = Integer.parseInt(text);
//				String convert = Integer.toString(number + 1);
				String convert = String.valueOf(number + 1);
				
				//3.버튼에 글자 + 1을 설정한다
				btn.setText(convert);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//버튼의 배경을 제거 또는 흰색
//				btn.setBackground(Color.white);
				btn.setBackground(null);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//버튼의 배경을 노랑으로 설정
				btn.setBackground(Color.yellow);
			}
		};
		btn.addMouseListener(m);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame17() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 17");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test17 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame17 frame = new MyFrame17();
	}
}
