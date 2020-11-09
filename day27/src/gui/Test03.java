package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test03 {
	public static void main(String[] args) {
		//Frame 생성 코드
		JFrame frame = new JFrame();//창 생성
		frame.setTitle("자바 그래픽 예제");
		frame.setLocation(300, 100);//왼쪽 위 모서리 위치(x, y) - px
		frame.setSize(400, 400);//크기(폭,높이) - px(pixel,화소)
		frame.setResizable(false);//창 크기변경 불가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x를 누르면 프로그램이 종료되도록 설정
		
		//GridLayout을 이용하여 컴포넌트를 배치하는 방법
		//GridLayout layout = new GridLayout(2, 2);//2줄 2칸(간격없음)
		GridLayout layout = new GridLayout(2, 2, 5, 5);//2줄 2칸에 수평5px, 수직5px만큼 띄운다
		frame.setLayout(layout);
		
		//컴포넌트 생성
		JButton a = new JButton("a버튼");
		JButton b = new JButton("b버튼");
		JButton c = new JButton("c버튼");
		JButton d = new JButton("d버튼");
		
		//주의 : 각각의 컴포넌트들은 단 한번만 추가가 가능(중복 불가)
		frame.add(a);
		frame.add(b);
		frame.add(c);
		frame.add(d);
		
		//Frame 표시 코드
		frame.setVisible(true);//창을 보이게 하는 명령
	}
}
