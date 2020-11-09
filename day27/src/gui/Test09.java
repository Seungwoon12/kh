package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame09 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	
	//제목
	private JPanel top = new JPanel(new BorderLayout());
	private JLabel title = new JLabel("남은시간 : 2분 30초", JLabel.CENTER);
	
	//가운데 영역
	private JPanel center = new JPanel(new GridLayout(5, 5));
	
	private JButton bt1 = new JButton();
	private JButton bt2 = new JButton();
	private JButton bt3 = new JButton();
	private JButton bt4 = new JButton();
	private JButton bt5 = new JButton();
	private JButton bt6 = new JButton();
	private JButton bt7 = new JButton();
	private JButton bt8 = new JButton();
	private JButton bt9 = new JButton();
	private JButton bt10 = new JButton();
	private JButton bt11 = new JButton();
	private JButton bt12 = new JButton();
	private JButton bt13 = new JButton();
	private JButton bt14 = new JButton();
	private JButton bt15 = new JButton();
	private JButton bt16 = new JButton();
	private JButton bt17 = new JButton();
	private JButton bt18 = new JButton();
	private JButton bt19 = new JButton();
	private JButton bt20 = new JButton();
	private JButton bt21 = new JButton();
	private JButton bt22 = new JButton();
	private JButton bt23 = new JButton();
	private JButton bt24 = new JButton();
	private JButton bt25 = new JButton();
	
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
		center.add(bt1);
		center.add(bt2);
		center.add(bt3);
		center.add(bt4);
		center.add(bt5);
		center.add(bt6);
		center.add(bt7);
		center.add(bt8);
		center.add(bt9);
		center.add(bt10);
		center.add(bt11);
		center.add(bt12);
		center.add(bt13);
		center.add(bt14);
		center.add(bt15);
		center.add(bt16);
		center.add(bt17);
		center.add(bt18);
		center.add(bt19);
		center.add(bt20);
		center.add(bt21);
		center.add(bt22);
		center.add(bt23);
		center.add(bt24);
		center.add(bt25);
		
		bt1.setBackground(Color.yellow);
		bt1.setForeground(Color.red);
		
		this.add(bottom, BorderLayout.SOUTH);
		bottom.add(finish);
		bottom.add(retry);
		bottom.add(close);
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame09() {
		this.place();
		this.setTitle("GUI 예제 09");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test09 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame09 frame = new MyFrame09();
	}
}
