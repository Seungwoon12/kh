package gui;

import javax.swing.JFrame;

class MyFrame08 extends JFrame {
	
	
	public void place() {
		
	}
	
	public MyFrame08() {
		this.setTitle("GUI 예제 08");
		this.place();
		this.setLocation(100, 100);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}

public class Test08 {
	public static void main(String[] args) {
		MyFrame08 frame = new MyFrame08();
		
	}
}
