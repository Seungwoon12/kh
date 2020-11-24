package thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame10_1 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JButton start = new JButton("시작");
	private JButton stop = new JButton("정지");
	private
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
	}
	
	public void event() {
		
	}
	
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame10_1() {
		this.place();
		this.event();
		this.menu();
		this.setTitle("초시계");
		this.setLocation(100, 100);
		this.setSize(400, 150);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Test10_1 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		try {
			UIManager.setLookAndFeel(new McWinLookAndFeel());
		} catch (Exception ex) {
			System.out.println("스킨을 불러올 수 없습니다.");
		}
		MyFrame10_1 frame = new MyFrame10_1();
	}
}
