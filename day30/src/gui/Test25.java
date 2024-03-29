package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.jtattoo.plaf.texture.TextureLookAndFeel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame25 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JButton bt = new JButton("버튼");
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		root.add(bt);
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame25() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 25");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test25 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		//- 창 생성 전에 스킨을 적용시키는 설정을 수행
		//- 스킨을 LookAndFeel이라고 부른다
		//- 자체적으로 제공되는 LookAndFeel도 있고 외부에서 제공하는 LookAndFeel(ex : JTattoo)
		//UIManager.setLookAndFeel("적용시킬 클래스명");
		
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			//UIManager.setLookAndFeel(new McWinLookAndFeel());
			UIManager.setLookAndFeel(new TextureLookAndFeel());
		}
		catch(Exception e) {
			System.err.println("스킨을 불러올 수 없습니다");
		}
		
		MyFrame25 frame = new MyFrame25();
	}
}