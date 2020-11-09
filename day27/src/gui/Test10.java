package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame10 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	private JLabel title = new JLabel("지뢰찾기", JLabel.CENTER);
	
	private JPanel center = new JPanel(new GridLayout(20, 24));//20줄 24칸
	
	private JButton[] bt = new JButton[20*24];
//	private JButton[][] bt = new JButton[20][24];
	
	//멤버 메소드 : 배치기능
	public void place() {
		this.setLayout(new BorderLayout());
		
		this.add(title, BorderLayout.NORTH);
		
		this.add(center, BorderLayout.CENTER);
		
		Color color = new Color(71, 200, 62);
		for(int i=0; i < bt.length; i++) {
			bt[i] = new JButton();
			bt[i].setBackground(color);
			center.add(bt[i]);
		}
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame10() {
		this.place();
		this.setTitle("GUI 예제 10");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test10 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame10 frame = new MyFrame10();
	}
}