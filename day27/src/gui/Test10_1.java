package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//나만의 창 클래스 템플릿(기본폼)
class MyFrame10_1 extends JFrame{
	
	//멤버 변수 : 필요한 컴포넌트를 정의
	private JLabel title = new JLabel("지뢰찾기", JLabel.CENTER);
	
	private int row = 20;
	private int col = 24;
	
	private JPanel center = new JPanel(new GridLayout(row, col));//20줄 24칸
	private JButton[][] bt = new JButton[row][col];
	
	//멤버 메소드 : 배치기능
	public void place() {
		this.setLayout(new BorderLayout());
		
		this.add(title, BorderLayout.NORTH);
		
		//title에 글꼴 설정
		Font font = new Font("맑은 고딕", Font.BOLD, 24);
		title.setFont(font);
		
		this.add(center, BorderLayout.CENTER);
		
		Color color1 = new Color(212, 244, 250);//연한색
		Color color2 = new Color(92, 209, 229);//진한색
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				bt[i][j] = new JButton();
				bt[i][j].setCursor(cursor);
				//지그재그 
				//- 홀수줄일 때는 홀수칸을 진하게 하고 짝수칸을 연하게
				//- 짝수줄일 때는 짝수칸을 진하게 하고 홀수칸을 연하게
				if(i % 2 != 0) {
					if(j % 2 != 0) {
						bt[i][j].setBackground(color2);
					}
					else {
						bt[i][j].setBackground(color1);
					}
				}
				else {
					if(j % 2 != 0) {
						bt[i][j].setBackground(color1);
					}
					else {
						bt[i][j].setBackground(color2);
					}
				}
				center.add(bt[i][j]);
			}
		}
	}
	
	//생성자 : 창에 대한 설정
	public MyFrame10_1() {
		this.place();
		this.setTitle("GUI 예제 10_1");
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test10_1 {
	public static void main(String[] args) {
		//main에 더이상 모든 코드를 적지 않겠다
		MyFrame10_1 frame = new MyFrame10_1();
	}
}