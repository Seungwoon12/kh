package oop.basic2;

public class Test01 {
	public static void main(String[] args) {
		
		Record a = new Record();
		Record b = new Record();
		Record c = new Record();
		
		
		a.name = "김연아";
		a.sports = "피겨스케이팅";
		a.goldMedal = 2;
		a.silverMedal = 0;
		a.bronzeMedal = 1;
		
		System.out.print("| "+a.name+" | ");
		System.out.print(a.sports+" | ");
		System.out.print(a.goldMedal+" | ");
		System.out.print(a.silverMedal+" | ");
		System.out.println(a.bronzeMedal+" | ");
		
	
		
		b.name = "이상화";
		b.sports = "스피드스케이팅";
		b.goldMedal = 1;
		b.silverMedal = 2;
		b.bronzeMedal = 1;
		
		System.out.print("| "+b.name+" | ");
		System.out.print(b.sports+" | ");
		System.out.print(b.goldMedal+" | ");
		System.out.print(b.silverMedal+" | ");
		System.out.println(b.bronzeMedal+" | ");
		
		
		
		c.name = "윤성빈";
		c.sports = "스켈레톤";
		c.goldMedal = 1;
		c.silverMedal = 0;
		c.bronzeMedal = 1;
		
		System.out.print("| "+c.name+" | ");
		System.out.print(c.sports+" | ");
		System.out.print(c.goldMedal+" | ");
		System.out.print(c.silverMedal+" | ");
		System.out.println(c.bronzeMedal+" | ");
		
		
		
		
	}
}
