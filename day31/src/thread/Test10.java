package thread;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame10 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	private JPanel root = new JPanel();

	private int time = 0;
	
	//private JLabel lcd = new JLabel("", JLabel.CENTER);
	private JLabel lcd = new JLabel("", JLabel.CENTER);
	
	private JPanel east = new JPanel(new GridLayout(3, 1));
	private JButton start = new JButton("시작");
	private JButton stop = new JButton("정지");
	private JButton reset = new JButton("초기화");
	
	
	//애초에 클래스를 만들고 쓰레드를 상속받아서 편하게 쓰도록 구성
	//- 바깥에 만들면 멤버변수 사용을 못하니까 안에다가 만든다
	//- 일반중첩클래스
	//- 클래스가 필요하긴 한데 내부적으로만 사용할 예정!
	class StopWatch extends Thread {
		public StopWatch() {
			this.setDaemon(true);
		}
		@Override
		public void run() {
			try {
				while(true) {
					display(time + 1);//시간 1증가
					Thread.sleep(10L);
				}
			}
			catch(Exception ex) {}
		}
	}
	
	//Thread 대신에 Stopwatch를 사용
	private StopWatch t;
	
	//멤버 메소드 : 배치기능
	public void place() {
		//root를 Frame의 ContentPane으로 설정
		// - 이제부터는 모든 컴포넌트는 this가 아니라 root에 추가
		this.setContentPane(root);
		
		//layout을 null로 설정하면 모든 컴포넌트에 좌표를 부여해서 배치가 가능
		// - 복잡한 화면에 유리함
		root.setLayout(new BorderLayout());
		
		root.add(lcd, BorderLayout.CENTER);
		root.add(east, BorderLayout.EAST);
		east.add(start);
		east.add(stop);
		east.add(reset);
		
		Font font = new Font("굴림", Font.BOLD, 40);
		lcd.setFont(font);
		display(0);//lcd를 0으로 설정
		
		stop.setEnabled(false);//처음에 정지버튼은 비활성화
	}
	
	//멤버 메소드 : 이벤트 설정
	public void event() {
		//시작버튼 : 누르면 시간이 증가하도록 구현(time이 10ms당 1씩 증가)
		start.addActionListener(e->{
			start.setEnabled(false);//시작버튼 비활성화
			stop.setEnabled(true);//정지버튼 활성화
			
			t = new StopWatch();
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
	
	
	//이 기능은 메인 스레드와 t 라는 스레드가 동시에 접근하는 기능
	//- 혹시 순서가 꼬여서 오류가 발생할까 두렵다면 성능을 조금 포기하고 줄서서 들어오게 만들 수 있다.
	//- 자바에서는 synchronized 라는 키워드를 통해 자동으로 줄을 서서 이용할 수 있도록 처리를 해준다.
	//- synchronized 키워드를 사용하려면 스레드가 여러 개 있어야 한다.
	public synchronized void display(int time) {
		this.time = time;
	
		//시간 계산
		int minute = this.time / 100 / 60;
		int second = this.time / 100 % 60;
		int millis = this.time % 100;
		
		//숫자는 DecimalFormat으로 형식을 제어할 수 있다.
		//- 0을 배치하면 해당 자리가 비었을 때 0으로 출력
		Format f = new DecimalFormat("00");
		
		String text = f.format(minute) + "분 " + f.format(second) + "초 " + f.format(millis);
		
		lcd.setText(text);
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame10() {
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

public class Test10 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		try {
			UIManager.setLookAndFeel(new McWinLookAndFeel());
		}
		catch(Exception e) {
			System.err.println("스킨을 불러올 수 없습니다");
		}
		MyFrame10 frame = new MyFrame10();
	}
}