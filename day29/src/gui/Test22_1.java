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
class MyFrame22_1 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	//표시용 액정 라벨
	private JLabel lcd = new JLabel("", JLabel.RIGHT);
	
	//버튼 배치 공간
	private JPanel center = new JPanel(new GridLayout(4, 3));
	private JButton[] btn = new JButton[12];
	private String[] title = new String[] {//1234라고 숫자가 아니다(*0#은 규칙이 없음)
		"1","2","3","4","5","6","7","8","9","*","0","#"
	};
	
	//통화 및 지우기
	private JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JButton call = new JButton("통화");
	private JButton clear = new JButton("지우기");
	
	private Font font = new Font("굴림", Font.BOLD, 30);
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		root.setLayout(new BorderLayout());
		root.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		root.add(lcd, BorderLayout.NORTH);
		
		lcd.setFont(font);
		lcd.setPreferredSize(new Dimension(0, 80));
		lcd.setOpaque(true);
		lcd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 3), "전화번호 입력"));

		root.add(center, BorderLayout.CENTER);
		for(int i=0; i < btn.length; i++) {
			btn[i] = new JButton(title[i]);
			btn[i].setFont(font);
			center.add(btn[i]);
		}
		center.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		root.add(bottom, BorderLayout.SOUTH);
		bottom.add(call);
		bottom.add(clear);
		call.setFont(font);
		clear.setFont(font);
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//이벤트는 한번에!
		//- 구분은 e.getActionCommand()나 e.getSource()로 처리!
		ActionListener listener = e->{
			String value = e.getActionCommand();
			lcd.setText(lcd.getText() + value);
		};
		for(int i=0; i < btn.length; i++) {
			btn[i].addActionListener(listener);
		}
		
		//통화버튼 이벤트
		call.addActionListener(e->{
			JOptionPane.showMessageDialog(root, lcd.getText()+" 연결중");
		});
		
		//지우기버튼 이벤트
		clear.addActionListener(e->{
			lcd.setText("");
		});
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame22_1() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("휴대폰 문제");
		this.setLocation(100, 100);
		this.setSize(300, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test22_1 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//main에 더이상 모든 코드를 적지 않겠다
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		MyFrame22_1 frame = new MyFrame22_1();
	}
}