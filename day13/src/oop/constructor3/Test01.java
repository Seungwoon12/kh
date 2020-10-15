package oop.constructor3;

public class Test01 {
	public static void main(String[] args) {
		Character c1 = new Character("뽀로로", "전사", 15, 300);
		Character c2 = new Character("피카츄", "마법사");
		Character c3 = new Character("타요", "전사", 10, 250);
		
		c1.print();
		c2.print();
		c3.print();
	}
}

