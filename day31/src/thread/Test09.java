package thread;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame09 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();

	private int time = 0;
	
	//private JLabel lcd = new JLabel("", JLabel.CENTER);
	private JLabel lcd = new JLabel("", JLabel.CENTER);
	
	private JButton start = new JButton("시작");
	private JButton stop = new JButton("정지");
	private JButton reset = new JButton("초기화");
	
	private Runnable r = ()->{
		try {
			while(true) {
				display(time + 1);//시간 1증가
				Thread.sleep(10L);
			}
		}
		catch(Exception ex) {}
	};
	private Thread t;
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		//layout을 null로 설정하면 모든 컴포넌트에 좌표를 부여해서 배치가 가능
		// - 복잡한 화면에 유리함
		root.setLayout(null);
		
		root.add(lcd);
		root.add(start);
		root.add(stop);
		root.add(reset);
		
		lcd.setBounds(10, 10, 280, 100);
		Font font = new Font("굴림", Font.BOLD, 40);
		lcd.setFont(font);
		display(0);//lcd를 0으로 설정
		
		start.setBounds(300, 10, 80, 30);
		stop.setBounds(300, 45, 80, 30);
		reset.setBounds(300, 80, 80, 30);
		
		stop.setEnabled(false);//처음에 정지버튼은 비활성화
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//시작버튼 : 누르면 시간이 증가하도록 구현(time이 10ms당 1씩 증가)
		start.addActionListener(e->{
			start.setEnabled(false);//시작버튼 비활성화
			stop.setEnabled(true);//정지버튼 활성화
			
			t = new Thread(r);//스레드는 1회용이기 때문에 같은 작업을 계속 해야한다면 신규로 생성해야한다
			t.setDaemon(true);
			t.start();
		});
		
		//정지버튼 : 시작버튼을 눌러서 구동중인 스레드를 정지(interrupt)
		stop.addActionListener(e->{
			start.setEnabled(true);//시작버튼 활성화
			stop.setEnabled(false);//정지버튼 비활성화
			
			t.interrupt();
		});
		
		//초기화버튼 : 스레드와 무관하게 시간을 0으로 바꾸는 역할
		reset.addActionListener(e->{
			display(0);
		});
	}
	
	
	public void display(int time) {
		this.time = time;
	
		//시간 계산
		int minute = this.time / 100 / 60;
		int second = this.time / 100 % 60;
		int millis = this.time % 100;
		
		//숫자는 DecimalFormat으로 형식을 제어할 수 있다.
		//- 0을 배치하면 해당 자리가 비었을 때 0으로 출력
		Format f = new DecimalFormat("00");
		
		String text = f.format(minute) + "분 "+ f.format(second) + "초 " + f.format(millis);
		
		lcd.setText(text);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame09() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("초시계");
		this.setLocation(100, 100);
		this.setSize(400, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test09 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		try {
			UIManager.setLookAndFeel(new McWinLookAndFeel());
		}
		catch(Exception e) {
			System.err.println("스킨을 불러올 수 없습니다");
		}
		MyFrame09 frame = new MyFrame09();
	}
}