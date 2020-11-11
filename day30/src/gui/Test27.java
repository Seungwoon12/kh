package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame27 extends JFrame{
	
	//이미지 불러오기 : Toolkit 사용
	//private Image image = Toolkit.getDefaultToolkit().getImage("image/lion2.jpg");
	private Image image = Toolkit.getDefaultToolkit().getImage("image/lion.gif");
	private int x = 10;
	private int y = 10;
	private int width = 100;
	private int height = 100;
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());//전체 청소
			//g.fillRect(x, y, width, height);
			g.drawImage(image, x, y, width, height, this);//this == root
		}
	};
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		small.addActionListener(e->{
			//뭐라고 써야 그려진 사각형이 작아질까?
			// = 축소해라!
			// = 폭과 높이를 -20씩 변경하고 다시 그려라
			width -= 20;
			height -= 20;
			root.repaint();//root를 다시 그려라
			//System.out.println("width = " + width+", height = " + height);
		});
		
		big.addActionListener(e->{
			width += 20;
			height += 20;
			root.repaint();
		});
		
		up.addActionListener(e->{
			y -= 20;
			root.repaint();
		});
		
		down.addActionListener(e->{
			y += 20;
			root.repaint();
		});
		
		right.addActionListener(e->{
			x += 20;
			root.repaint();
		});
		
		left.addActionListener(e->{
			x -= 20;
			root.repaint();
		});
	}
	
	private JMenuBar bar = new JMenuBar();
	
	private JMenu menu = new JMenu("메뉴");
	private JMenuItem small = new JMenuItem("작게");
	private JMenuItem big = new JMenuItem("크게");
	private JMenuItem up = new JMenuItem("위로");
	private JMenuItem down = new JMenuItem("아래로");
	private JMenuItem left = new JMenuItem("왼쪽으로");
	private JMenuItem right = new JMenuItem("오른쪽으로");
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		this.setJMenuBar(bar);
		bar.add(menu);
		menu.add(small);
		menu.add(big);
		menu.add(up);
		menu.add(down);
		menu.add(left);
		menu.add(right);
		
		small.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0));
		big.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0));
		up.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0));
		down.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0));
		right.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0));
		left.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0));
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame27() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 27");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test27 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame27 frame = new MyFrame27();
	}
}