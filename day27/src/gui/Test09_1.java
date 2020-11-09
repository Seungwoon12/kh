package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame09_1 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	
	//제목
	private JPanel top = new JPanel(new BorderLayout());
	private JLabel title = new JLabel("남은시간 : 2분 30초", JLabel.CENTER);
	
	//가운데 영역
	private JPanel center = new JPanel(new GridLayout(5, 5));
	
	//버튼이 아니라 버튼이 25개 들어갈 "자리"를 만든 것!
	//초기화는 메소드에서 가능
	private JButton[] bt = new JButton[25];
	
	//아래 영역
	private JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	private JButton finish = new JButton("완료");
	private JButton retry = new JButton("다시");
	private JButton close = new JButton("닫기");
	
	//멤버 메소드 : 배치기능
	public void place() {
		this.setLayout(new BorderLayout());
		this.add(top, BorderLayout.NORTH);
		top.add(title);
		
		this.add(center, BorderLayout.CENTER);
		
		List<Integer> numbers = new ArrayList<>();
		for(int i=1; i<=25; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		for(int i=0; i < bt.length; i++) {
			bt[i] = new JButton(""+ numbers.get(i));//i번 자리에 버튼 추가
			bt[i].setBackground(new Color(255, 217, 250));
//			bt[i].setBackground(Color.red);//new Color(255, 0, 0)과 같은 의미의 상수
			bt[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
//			bt[i].setText(""+ numbers.get(i));
			center.add(bt[i]);
		}
		
		this.add(bottom, BorderLayout.SOUTH);
		bottom.add(finish);
		bottom.add(retry);
		bottom.add(close);
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame09_1() {
		this.place();
		this.setTitle("GUI 예제 09");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test09_1 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame09_1 frame = new MyFrame09_1();
	}
}
