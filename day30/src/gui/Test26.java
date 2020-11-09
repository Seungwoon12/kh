package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame26 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	//- 모든 컴포넌트를 배치할 수 있는 ContentPane을 생성(JPanel)
	//- 목표 : root라는 JPanel에 어떻게 하면 그림을 그릴 수 있는가?
	//- 가장 유사한 프로그램은 그림판
	
	//- 모든 컴포넌트는 paint() 메소드로 그림을 그리게 되어 있다.
	//- 내마음대로 그림을 그리고 싶다면 paint() 메소드를 재정의해야 한다 = 익명중첩클래스
	//- paint는 내부적으로 다음 상황에서 실행된다
	//	1.최초 실행 시 자동호출 : 사용자에게 표시될 화면을 그리기 위해
	//	2.크기 변경 시 자동호출 : 크기 변화로 인한 추가되거나 제거되는 부분을 표현하기 위해
	//	3.내가 원하는 시점에 호출 : .repaint() 명령
	private JPanel root = new JPanel() {
		@Override
		public void paint(Graphics g) {
			//System.out.println("그림 그리는 메소드가 실행되었습니다!");
			
			//root가 도화지, g가 펜의 역할을 수행
			//직선
			g.drawLine(50, 50, 150, 150);//(50,50) 에서 (150,150) 까지
			g.drawLine(50, 150, 150, 50);//(50,150) 에서 (150,50) 까지
			
			g.setColor(Color.red);//빨강으로 설정
			g.drawLine(50, 150, 150, 150);
			
			//사각형 : rect
			g.drawRect(200, 50, 100, 100);
			g.fillRect(50, 200, 100, 100);
			
			//원 : oval, 사각형과 원은 그리기 위한 정보가 동일하다
			g.setColor(Color.blue);
			g.drawOval(200, 50, 100, 100);
			g.fillOval(50, 200, 100, 100);
			
			//다각형 : polygon
			//문자열 : string
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
		
	}
	
	//멤버 메소드 : 메뉴 설정
	public void menu() {
		
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame26() {
		this.place();
		this.menu();
		this.event();
		this.setTitle("GUI 예제 26");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
}

public class Test26 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame26 frame = new MyFrame26();
	}
}