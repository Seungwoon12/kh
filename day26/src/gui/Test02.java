package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

//목표 : 앞에서 배운 창에 버튼과 같은 컴포넌트(Component)를 배치
// - 버튼 : JButton, 누를 수 있는 도구
public class Test02 {
	public static void main(String[] args) {
		//창 배치
		JFrame frame = new JFrame();//창 생성
		frame.setTitle("자바 그래픽 예제");
		frame.setLocation(300, 100);//왼쪽 위 모서리 위치(x, y) - px
		frame.setSize(400, 400);//크기(폭,높이) - px(pixel,화소)
		frame.setResizable(false);//창 크기변경 불가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x를 누르면 프로그램이 종료되도록 설정
	
		
		//버튼 생성
		JButton bt = new JButton("눌러봐!");
		JButton bt2 = new JButton("2번째버튼");
		
		//frame에 bt을 배치(아무런 설정이 없을 경우 덮어쓰기 처리)
		frame.add(bt);
		frame.add(bt2);
		
		frame.setVisible(true);//창을 보이게 하는 명령
		
	}
}