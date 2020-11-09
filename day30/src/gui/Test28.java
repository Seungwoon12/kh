package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame28 extends JFrame{
	
	//이미지,x,y,width,height
	private Image img = Toolkit.getDefaultToolkit().getImage("image/lion.gif");
	private int x = -1, y = -1;
	private int width = 150, height = 150;
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			//System.out.println("x = " + x + ", y = " + y);
			if(x != -1 && y != -1) {
				//모서리
				//g.drawImage(img, x, y, width, height, this);
				
				//가운데
				g.drawImage(img, x - width/2, y - height/2, width, height, this);
			}
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
//		root에 MouseEvent를 설정
//		root.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.out.println(e.getX()+", "+e.getY());
//				x = e.getX();
//				y = e.getY();
//				root.repaint();
//			}
//		});
		
//		root에 MouseMotionEvent를 설정(move, drag)
		root.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				root.repaint();
			}
		});
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame28() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 28");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test28 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame28 frame = new MyFrame28();
	}
}