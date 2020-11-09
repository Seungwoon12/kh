package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test06 {
	public static void main(String[] args) {
		//Frame 생성 코드
		JFrame frame = new JFrame();//창 생성
		frame.setTitle("로그인");
		frame.setLocation(300, 100);//왼쪽 위 모서리 위치(x, y) - px
		frame.setSize(300, 150);//크기(폭,높이) - px(pixel,화소)
		frame.setResizable(false);//창 크기변경 불가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x를 누르면 프로그램이 종료되도록 설정

		//화면 구성
		//2층 1번째 패널
		JPanel a = new JPanel(new BorderLayout());
		
		JLabel lb1 = new JLabel("아이디", JLabel.CENTER);
		JTextField f1 = new JTextField();
		
		a.add(lb1, BorderLayout.WEST);
		a.add(f1, BorderLayout.CENTER);
		
		//2층 2번째 패널
		JPanel b = new JPanel(new BorderLayout());
		
		JLabel lb2 = new JLabel("비밀번호", JLabel.CENTER);
		JTextField f2 = new JTextField();
		
		b.add(lb2, BorderLayout.WEST);
		b.add(f2, BorderLayout.CENTER);
		
		//2층 3번째 패널
		JPanel c = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JButton bt = new JButton("Login");
		c.add(bt);
				
		//1층에 2층 패널들을 배치
		frame.setLayout(new GridLayout(3, 1, 0, 10));
		frame.add(a);
		frame.add(b);
		frame.add(c);
		
		//폭 설정 - 레이아웃이 있으면 setSize()로 설정이안되고 setPrefferedSize()로 설정해야 한다(강제)
		// - Dimension : 폭+높이를 합쳐서 관리하는 클래스
		lb1.setPreferredSize(new Dimension(100, 50));
		lb2.setPreferredSize(new Dimension(100, 50));
				
		//Frame 표시 코드
		frame.setVisible(true);//창을 보이게 하는 명령
	}
}
