package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame11 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	private JLabel title = new JLabel("설문조사", JLabel.CENTER);
	private JLabel question = new JLabel("내가 가장 좋아하는 분야는?", JLabel.LEFT);
	
	private JCheckBox choice1 = new JCheckBox("상속 단원");
	private JCheckBox choice2 = new JCheckBox("다형성 단원");
	private JCheckBox choice3 = new JCheckBox("파일입출력");
	
	private JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JButton confirm = new JButton("제출");
	
	private Font titleFont = new Font("궁서", Font.BOLD, 35);
	private Font questionFont = new Font("궁서", Font.PLAIN, 20);
	
	
	//멤버 메소드 : 배치기능
	public void place() {
		this.setLayout(new GridLayout(6, 1));//6줄 1칸
		
		this.add(title);
		title.setFont(titleFont);
		
		this.add(question);
		question.setFont(questionFont);
		
		this.add(choice1);
		this.add(choice2);
		this.add(choice3);
		
		
		this.add(bottom);
		bottom.add(confirm);
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame11() {
		this.place();
		this.setTitle("GUI 예제 11");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test11 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame11 frame = new MyFrame11();
	}
}