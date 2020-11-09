package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//클래스 파일을 따로 만들기 귀찮으니 여기다 클래스를 하나 더 생성(public을 붙이면 안됨)
class LoginFrame extends JFrame{//JFrame을 확장해서 로그인 화면으로 만들겠다
	
	//멤버 변수 : 이 클래스에서 사용할 필요한 데이터들을 저장
	// - 화면을 구성하기 위한 컴포넌트(Component)들을 변수로 선언
	// - JPanel 3개, JLabel 2개 , JTextField 2개, JButton 1개
	private JPanel a = new JPanel(new BorderLayout());
	private JPanel b = new JPanel(new BorderLayout());
	private JPanel c = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	private JLabel lb1 = new JLabel("아이디", JLabel.CENTER);
	private JLabel lb2 = new JLabel("비밀번호", JLabel.CENTER);
	
	private JTextField f1 = new JTextField();
	private JTextField f2 = new JTextField();
	
	private JButton bt = new JButton("Login");
	
	//멤버 메소드 : 이 클래스에 필요한 기능(코드)을 저장
	// - 컴포넌트 배치 기능 , 이벤트 설정 , 메뉴 설정
	// - 주인공(frame)은 this라고 부르면 된다
	public void place() {
		this.setLayout(new GridLayout(3, 1));
		
		this.add(a);
		this.add(b);
		this.add(c);
		
		a.add(lb1, BorderLayout.WEST);
		a.add(f1, BorderLayout.CENTER);
		
		b.add(lb2, BorderLayout.WEST);
		b.add(f2, BorderLayout.CENTER);
		
		c.add(bt);
	}
	
	//생성자 : 창을 만들 때 해야할 일을 작성
	public LoginFrame() {
		this.setTitle("로그인 화면");
		this.place();
		this.setLocation(300, 100);
		this.setSize(300, 150);
		this.setResizable(false);
		this.setVisible(true);
	}
	
}

public class Test07 {
	public static void main(String[] args) {
		//세부코드가 아니라 "로그인 화면"을 생성하도록 구현
		LoginFrame frame = new LoginFrame();
	}
}