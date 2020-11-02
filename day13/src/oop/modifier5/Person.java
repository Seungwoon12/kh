package oop.modifier5;

public class Person {
	//멤버(인스턴스) 변수
	private String name;
	private int height;
	private int weight;
	
	//멤버(인스턴스) 메소드
	
	//- setter&getter
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;//반환+종료
	}
	public void setHeight(int height) {
		if(height <= 0) {
			return;//종료
		}
		this.height = height;
	}
	public int getHeight() {
		return this.height;
	}
	public void setWeight(int weight) {
		if(weight<=0) {
			return;
		}
		this.weight = weight;
	}
	public int getWeight() {
		return this.weight;
	}
	
	//키는 cm로 관리되지만.. 실제로 써보니까 m로도 많이 쓰던데
	//m를 반환하는 메소드도 하나 추가해놓으면 어떨까?
	// - 존재하는 변수만 getter메소드를 가질 수 있는 것은 아님
	public double getHeightMeter() {
		return this.height / 100.0;
	}
	public double getBmi() {
//		return this.weight / this.getHeightMeter() / this.getHeightMeter();
		return this.getWeight() / this.getHeightMeter() / this.getHeightMeter();
	}
	
	//info & print
	public void info(String name, int height, int weight) {
		this.setName(name);
		this.setHeight(height);
		this.setWeight(weight);
	}
	
	public void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("신장 : "+this.height+"cm");
		System.out.println("체중 : "+this.weight+"kg");
	}
}
