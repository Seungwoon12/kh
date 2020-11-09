package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame21 extends JFrame{
	
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
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		exit.addActionListener(e->{
			System.exit(0);
		});
		newWindow.addActionListener(e->{
			MyFrame21 frame = new MyFrame21();
		});
		
		//JFileChoose : 파일 선택창
		//- .showOpenDialog() : 파일 열기창. 실제로 불러오지는 않음(우리가 작성해야함)
		//- .showSaveDialog() : 파일 저장창. 실제로 저장하지는 않음(우리가 작성해야함)
		open.addActionListener(e->{
			JFileChooser chooser = new JFileChooser();
			int choice = chooser.showOpenDialog(root);
			//System.out.println("choice = " + choice);
			
			if(choice == JFileChooser.APPROVE_OPTION) {
				//System.out.println("열어라");
				
				//문자열 입력
				try {
					StringBuffer buffer = new StringBuffer();
					
					File target = chooser.getSelectedFile();//불러올 파일 정보를 가져와라!
					FileReader fr = new FileReader(target);
					BufferedReader br = new BufferedReader(fr);
					while(true) {
						String line = br.readLine();
						if(line == null) break;
						buffer.append(line);
						buffer.append("\n");
					}
					br.close();
					
					//다 읽은 내용(buffer)을 area에 설정
					area.setText(buffer.toString());
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		save.addActionListener(e->{
			JFileChooser chooser = new JFileChooser();
			int choice = chooser.showSaveDialog(root);
			
			if(choice == JFileChooser.APPROVE_OPTION) {
				//System.out.println("저장해라");
				
				try {
					File target = chooser.getSelectedFile();//저장할 파일 정보를 가져와라!
					FileWriter fw = new FileWriter(target);
					BufferedWriter bw = new BufferedWriter(fw, 8192);
					PrintWriter pw = new PrintWriter(bw);
					pw.print(area.getText());
					pw.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		red.addActionListener(e->{
			area.setForeground(Color.red);
		});
		
		blue.addActionListener(e->{
			area.setForeground(Color.blue);
		});
		
		//목표 : 사용자가 색상을 고르고 해당 색상으로 설정 : JColorChooser
		choice.addActionListener(e->{
			Color c = JColorChooser.showDialog(root, "골라골라", Color.black);
			//System.out.println("c = " + c);
			
			if(c != null) {
				area.setForeground(c);
			}
		});
	}
	
	//메뉴 : 창 상단에 부착시키는 도구 모음
	// - JMenuBar : 메뉴와 메뉴아이템을 배치할 수 있는 공간
	// - JMenu : 하위 요소를 가질 수 있는 메뉴
	// - JMenuItem : 선택으로 실행할 수 있는 메뉴
	private JMenuBar bar = new JMenuBar();
	
	private JMenu file = new JMenu("파일");
	private JMenu edit = new JMenu("편집");
	
	private JMenuItem newFile = new JMenuItem("새로 만들기");
	private JMenuItem newWindow = new JMenuItem("새창 열기");
	private JMenuItem save = new JMenuItem("저장하기");
	private JMenuItem open = new JMenuItem("불러오기");
	private JMenuItem exit = new JMenuItem("종료하기");
	
	private JMenu color = new JMenu("색상");
	
	//택1을 해야되는 경우라면 JRadioButtonMenuItem을 사용한다
	private JRadioButtonMenuItem red = new JRadioButtonMenuItem("빨강");
	private JRadioButtonMenuItem blue = new JRadioButtonMenuItem("파랑");
	private JRadioButtonMenuItem choice = new JRadioButtonMenuItem("사용자 정의");
	
	//멤버 메소드 : 메뉴 설정
	//- set은 1개만 설정
	//- add는 계속 추가
	public void menu() {
		this.setJMenuBar(bar);
		
		bar.add(file);
		bar.add(edit);
		
		file.add(newFile);
		file.add(newWindow);
		file.add(save);
		file.add(open);
		file.add(exit);
		
		edit.add(color);
		color.add(red);
		color.add(blue);
		color.add(choice);
		
		ButtonGroup group = new ButtonGroup();
		group.add(red);
		group.add(blue);
		group.add(choice);
		
		//메뉴는 단축키 설정이 가능하다
		// - 단축키를 누르면 해당하는 컴포넌트에 이벤트가 발생한다
		// - 상태값은 보조키를 이야기하는 것(0이면 보조키가 없는것)
		// - 같은 ESC여도 Ctrl+ESC, Alt+ESC, 그냥 ESC 등 다양하기 때문에 보조키를 설정해주는 공간이 존재
		// - 보조키 : KeyEvent.CTRL_DOWN_MASK, KeyEvent.ALT_DOWN_MASK, KeyEvent.SHIFT_DOWN_MASK
		//KeyStroke esc = KeyStroke.getKeyStroke(키code, 상태값);
		//KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		//KeyStroke shiftEsc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, KeyEvent.SHIFT_DOWN_MASK);
		KeyStroke comb = KeyStroke.getKeyStroke(
				KeyEvent.VK_1, KeyEvent.ALT_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
		exit.setAccelerator(comb);
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame21() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 21");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test21 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame21 frame = new MyFrame21();
	}
}
