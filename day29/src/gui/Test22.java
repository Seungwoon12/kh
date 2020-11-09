package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame22 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JPanel bottom = new JPanel(new FlowLayout());
	private JButton call = new JButton("통화");
	private JButton clear = new JButton("지우기");
	
	
	private JPanel center = new JPanel(new GridLayout(4, 3));
	private JButton[] bt = new JButton[12];
	private String[] input = new String[] {
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"
	};
	
	
	private JLabel top = new JLabel("", JLabel.CENTER);
	
	private Font font = new Font("굴림", Font.BOLD, 25);
	
	
	
	
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		root.setLayout(new BorderLayout());
		root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		root.add(bottom, BorderLayout.SOUTH);
		bottom.add(call);
		bottom.add(clear);
		call.setFont(font);
		clear.setFont(font);
		
		root.add(center, BorderLayout.CENTER);
		for(int i=0; i<bt.length; i++) {
			bt[i] = new JButton(input[i]);
			bt[i].setFont(font);
			center.add(bt[i]);
			
		}
		
		center.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
	
		
		root.add(top, BorderLayout.NORTH);
		top.setFont(font);
		top.setPreferredSize(new Dimension(0, 75));
		top.setOpaque(true);
		top.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.darkGray, 3), "전화번호 입력"));
		
		
	
		




		}
		

		
		
	
	
	public void event() {
		ActionListener action = e -> {
			String value = e.getActionCommand();
			top.setText(top.getText()+value);
			
			
		};
		
		for(int i=0; i<bt.length; i++) {
			bt[i].addActionListener(action);
		}
		
		ActionListener callAction = e -> {
			if(!top.getText().isEmpty()) {
				JOptionPane.showMessageDialog(root, top.getText()+" 전화 연결 중..."); 
			}
		
		};
		
		call.addActionListener(callAction);
		 
		ActionListener clearAction = e -> {
			top.setText("");
		};
		
		clear.addActionListener(clearAction);
		
	}
	
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame22() {
		this.place();
		this.event();
		this.menu();
		this.setTitle("GUI 예제 22");
		this.setLocation(100, 100);
		this.setSize(300, 450);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Test22 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//main에 더이상 모든 코드를 적지 않겠다
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		MyFrame22 frame = new MyFrame22();
	}
}
