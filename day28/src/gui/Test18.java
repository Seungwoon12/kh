package gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame18 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	//JTextField는 한 줄만 입력이 가능하다.
	// -> 여러 줄 입력이 필요한 경우 JTextArea를 사용
	// -> JTextArea는 스크롤 기능을 지원하지 않는다
	// -> 스크롤 지원 공간인 JScrollPane과 조합하여 사용한다
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);//area에 양이 늘어나면 스크롤을 생성
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		root.setLayout(new BorderLayout());
		
		root.add(scroll);
	}
	
	//멤버 메소드 : 이벤트 설정
	// - keyPress / keyRelease : ASCII 감지 + 특수키 감지
	// - keyTyped : Unicode 감지
	public void event() {
		KeyListener k = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//여기서 궁금한건 뭘까?
				//- 사용자가 입력한 키보드 데이터 : e.getKeyCode()
				System.out.println(e.getKeyCode());
				
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					//setVisible(false);//숨김
					dispose();//창 소멸
					//System.exit(0);//시스템 종료
				}
			}
		};
		area.addKeyListener(k);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame18() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 18");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test18 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame18 frame = new MyFrame18();
	}
}
