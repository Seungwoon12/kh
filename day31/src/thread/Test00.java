package thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame00 extends JFrame{
	
	int mx, my;
	
	class Star extends Thread{
		Image im = Toolkit.getDefaultToolkit().getImage("image/star.png");
		int x, y, width=30, height=30;
		Star(int x, int y){
			this.x = x;
			this.y = y;
			setDaemon(true);
			start();
		}
		@Override
		public void run() {
			try {
				while(true) {
					x+=5;
					if(x > 450) break;
					Thread.sleep(30);
				}
			}
			catch(Exception e) {}
			list.remove(this);
			System.out.println("소멸");
		}
	}
	
	class StarFactory extends Thread{
		@Override
		public void run() {
			try {
				while(true) {
					list.add(new Star(mx, my));
					System.out.println("생성 = "+list.size());
					Thread.sleep(100);
				}
			}
			catch(Exception e) {}
		}
	}
	
	class Painter extends Thread {
		@Override
		public void run() {
			try {
				while(true) {
					root.repaint();
					Thread.sleep(1000/16);
				}
			}
			catch(Exception e) {}
		}
	}
	
	private List<Star> list = new CopyOnWriteArrayList<>();
	
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			g.clearRect(0, 0, getWidth(), getHeight());
			for(Star star : list) {
				g.drawImage(star.im, star.x, star.y, star.width, star.height, this);
			}
		}
	};
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		Painter painter = new Painter();
		painter.setDaemon(true);
		painter.start();
	}
	
	//멤버 메소드 : 이벤트 설정
	private StarFactory factory;
	public void event() {
		root.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				factory = new StarFactory();
				factory.setDaemon(true);
				factory.start();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				factory.interrupt();
			}
		});
		
		root.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
			}
		});
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame00() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 00");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test00 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame00 frame = new MyFrame00();
	}
}