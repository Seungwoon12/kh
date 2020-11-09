package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame30 extends JFrame{
	
	private Image img = Toolkit.getDefaultToolkit().getImage("image/lion.png");
	private int x = 30, y = 30, width = 150, height = 150;
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			g.drawImage(img, x, y, width, height, this);
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
		//목표 : root에 마우스를 클릭하면 그림이 움직이게 처리해본다
		// - 움직이는 속도는 1px , 프레임은 24fps
		// - x가 250px이 될때까지 이동
		
		root.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = x; i <= 250; i++) {
					x = i;//x를 i로 바꿔라
					root.repaint();
					
					System.out.println("i = " + i);
					
					//1000분의 60초 만큼 휴식(60fps)
					try {
						Thread.sleep(1000/60);
					}
					catch(Exception ex) {}
				}
			}
		});
		
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame30() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 30");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test30 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame30 frame = new MyFrame30();
	}
}