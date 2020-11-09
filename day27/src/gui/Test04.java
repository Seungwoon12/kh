package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test04 {
	public static void main(String[] args) {
		//Frame 생성 코드
		JFrame frame = new JFrame();//창 생성
		frame.setTitle("자바 그래픽 예제");
		frame.setLocation(300, 100);//왼쪽 위 모서리 위치(x, y) - px
		frame.setSize(400, 400);//크기(폭,높이) - px(pixel,화소)
		frame.setResizable(false);//창 크기변경 불가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x를 누르면 프로그램이 종료되도록 설정
				
		//BorderLayout을 이용해서 Component를 배치하는 방법
		//- 방향을 기준으로 배치
		BorderLayout layout = new BorderLayout();
		frame.setLayout(layout);
		
		//배치를 위한 컴포넌트 생성
		JButton bt1 = new JButton("bt1");
		JButton bt2 = new JButton("bt2");
		JButton bt3 = new JButton("bt3");
		JButton bt4 = new JButton("bt4");
		JButton bt5 = new JButton("bt5");
		
		frame.add(bt1, BorderLayout.NORTH);//북쪽 방향에 bt1 배치
		frame.add(bt2, BorderLayout.WEST);//서쪽
//		frame.add(bt3, BorderLayout.EAST);//동쪽
//		frame.add(bt4, BorderLayout.SOUTH);//남쪽
		frame.add(bt5, BorderLayout.CENTER);//가운데
				
		//Frame 표시 코드
		frame.setVisible(true);//창을 보이게 하는 명령
	}
}