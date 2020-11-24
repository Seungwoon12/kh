package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame12 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JLabel title = new JLabel("설문조사", JLabel.CENTER);
	private JLabel question = new JLabel("내가 가장 좋아하는 분야는?", JLabel.LEFT);
	
	//JCheckBox는 체크 형태로 선택되는 도구
	//JRadioButton은 동그란 모양으로 선택되는 도구
	//private JCheckBox choice1 = new JCheckBox("상속 단원");
	//private JCheckBox choice2 = new JCheckBox("다형성 단원");
	//private JCheckBox choice3 = new JCheckBox("파일입출력");
	private JRadioButton choice1 = new JRadioButton("상속 단원");
	private JRadioButton choice2 = new JRadioButton("다형성 단원");
	private JRadioButton choice3 = new JRadioButton("파일입출력");
	
	private JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JButton confirm = new JButton("제출");
	
	private Font titleFont = new Font("궁서", Font.BOLD, 35);
	private Font questionFont = new Font("궁서", Font.PLAIN, 20);
	
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		root.setLayout(new GridLayout(6, 1));//6줄 1칸
		
		root.add(title);
		title.setFont(titleFont);
		
		root.add(question);
		question.setFont(questionFont);
		
		//목표 : choice1, choice2, choice3 중에서 한 개만 선택 가능하도록 묶어주고 싶다.
		// - 그룹 도구(ButtonGroup) 사용
		// - ButtonGroup을 만들고 묶어주고 싶은 대상을 추가
		ButtonGroup group = new ButtonGroup();
		group.add(choice1);
		group.add(choice2);
		group.add(choice3);
		
		//choice1을 체크(선택)되어있도록 설정
		choice1.setSelected(true);
		
		root.add(choice1);
		root.add(choice2);
		root.add(choice3);
		root.add(bottom);
		bottom.add(confirm);
		
		//목표 : LineBorder를 만들어서 프레임(this)에 설정
		// - 프레임(this)은 테두리 설정이 안되기 때문에 패널(JPanel)로 교체해서 사용
		//Border border = new LineBorder(Color.red);
//		Border border = new LineBorder(Color.red, 10); 
		//Border line = new LineBorder(Color.red, 10, false);
		//Border border = new TitledBorder("설문지");
		//Border empty = new EmptyBorder(10, 10, 10, 10);
//		Border border = new CompoundBorder(empty, line);
		
		//BorderFactory 사용
		Border line = BorderFactory.createLineBorder(Color.red, 10, false);
		Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border border = BorderFactory.createCompoundBorder(line, empty);
		root.setBorder(border);
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame12() {
		this.place();
		this.setTitle("GUI 예제 12");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test12 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame12 frame = new MyFrame12();
	}
}
