package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame20 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();
	
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		root.setLayout(new BorderLayout());
		root.add(scroll);
		
		Font font = new Font("", Font.PLAIN, 20);
		area.setFont(font);
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//목표 : F5를 누르면 시간을 불러와서 글에 첨부(오후 3:42 2020-11-06)
		KeyListener k = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_F5:
					Date d = new Date();
					Format f = new SimpleDateFormat("a h:mm yyyy-MM-dd");
					String time = f.format(d);
					//area.setText(time);//덮어쓰기 : 작성한 글자가 사라진다
//					area.append(time);//붙여쓰기 : 중간에서 넣어도 뒤에 붙는다
					area.insert(time, area.getCaretPosition());//중간삽입 : 우리가 원하는 명령
					break;
				case KeyEvent.VK_F6:
				case KeyEvent.VK_F7:
				//...
				}
			}
		};		
		area.addKeyListener(k);
		
		//목표 : 종료(x) 버튼을 누르면 글자 작성유무를 확인하고 글자가 없는 경우는 그냥 종료, 있으면 경고 후 종료
		WindowListener w = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//글자 작성유무를 아는 방법
				// = 글자를 가져와서 명령을 통한 처리 = 글자가 ""과 같습니까 = 글자가 길이가 0입니까
				String text = area.getText();
				if(text.isEmpty()) {//비어있으면(그냥종료)
					//setVisible(false);//숨김
					dispose();//소멸
					//System.exit(0);//프로그램종료
				}
				else {//비어있지않으면(창띄우고종료)
//					JOptionPane.showMessageDialog(root, "작성중인 내용이 사라집니다.. 안녕~");
					int result = JOptionPane.showConfirmDialog(root, "저장하고 종료할거에요?");
//					System.out.println("result = " + result);
					if(result == JOptionPane.YES_OPTION) {
						dispose();	
					}
					else if(result == JOptionPane.NO_OPTION){
						dispose();	
					}
					else {//취소
//						//아무것도 안함
					}
					
				}
			}
		};
		this.addWindowListener(w);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame20() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 20");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test20 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame20 frame = new MyFrame20();
	}
}
