package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test05 {
	public static void main(String[] args) {
		//Frame 생성 코드
		JFrame frame = new JFrame();//창 생성
		frame.setTitle("자바 그래픽 예제");
		frame.setLocation(300, 100);//왼쪽 위 모서리 위치(x, y) - px
		frame.setSize(400, 400);//크기(폭,높이) - px(pixel,화소)
		frame.setResizable(false);//창 크기변경 불가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x를 누르면 프로그램이 종료되도록 설정
		
		//1층 : JFrame - BorderLayout
		//2층 : JPanel - GridLayout
		JPanel panel = new JPanel();
		GridLayout g = new GridLayout(1, 2);
		panel.setLayout(g);
		
		JButton yes = new JButton("예");
		JButton no = new JButton("아니오");
		
		panel.add(yes);//panel에 yes를 추가
		panel.add(no);//panel에 no를 추가

		//1층은 BorderLayout으로 설정(안해도 기본값이 BorderLayout)
		BorderLayout b = new BorderLayout();
		frame.setLayout(b);
		
		//2층을 1층의 south에 배치
		frame.add(panel, BorderLayout.SOUTH);
		
		//1층의 center에는 JLabel을 배치
		JLabel label = new JLabel("종료하시겠어요?");
		frame.add(label, BorderLayout.CENTER);
				
		//Frame 표시 코드
		frame.setVisible(true);//창을 보이게 하는 명령
	}
}
