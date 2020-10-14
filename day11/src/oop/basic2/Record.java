package oop.basic2;

public class Record {
	
	String name;
	String sports;
	int goldMedal;
	int silverMedal;
	int bronzeMedal;
	
	void print() {
		
		System.out.print("| "+this.name+" | ");
		System.out.print(this.sports+" | ");
		System.out.print(this.goldMedal+" | ");
		System.out.print(this.silverMedal+" | ");
		System.out.println(this.bronzeMedal+" | ");
		
	}
	
	void info(String a, String b, int c, int d, int e) {
		this.name = a;
		this.sports = b;
		this.goldMedal = c;
		this.silverMedal = d;
		this.bronzeMedal = e;
	}
}
