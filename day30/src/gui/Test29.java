package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Lion {
	private Image img = Toolkit.getDefaultToolkit().getImage("image/lion3.gif");
	private int x = -1, y = -1;
	private int width = 150, height = 150;
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}

//나만의 창 클래스 템플릿(기본폼)
class MyFrame29 extends JFrame{
	
	//라이언들이 저장될 수 있는 저장소 생성(라이언=이미지+x+y+width+height)
	private List<Lion> lions = new ArrayList<>();
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			//이미지가 애초에 여러개니까 drawImage도 여러 번 사용
			g.clearRect(0, 0, getWidth(), getHeight());
			for(Lion lion : lions) {
				g.drawImage(lion.getImg(), lion.getX() - lion.getWidth()/2, 
								lion.getY() - lion.getHeight()/2, 
								lion.getWidth(), lion.getHeight(), this);
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
		root.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Lion을 만들어서 위치를 정하고 저장소에 추가한 뒤에 repaint
				Lion lion = new Lion();
				lion.setX(e.getX());
				lion.setY(e.getY());
				lions.add(lion);
				repaint();
			}
		});
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame29() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 29");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test29 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame29 frame = new MyFrame29();
	}
}