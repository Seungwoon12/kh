package oop.modifier5;

public class Bmi {
	private String name;
	private int height;
	private int weight;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setHeight(int height) {
		if(height <= 0) {
			return;
		}
		this.height = height;
	}
	public int getHeight() {
		return this.height;
	}
	
	public void setWeight(int weight) {
		if(weight <= 0) {
			return;
		}
		this.weight = weight;
	}
	public int getWeight() {
		return this.weight;
	}
	
	public double getHeightmeter() {
		return this.height / 100.0;
	}
	
	public double getBmi() {
		return this.getWeight() / this.getHeightmeter() / this.getHeightmeter();
	}
	
	
	
	
	public void info(String name, int height, int weight) {
		this.setName(name);
		this.setHeight(height);
		this.setWeight(weight);
	}
	
	
	public void print() {
		System.out.println("이름 : "+this.name);
		System.out.println("키(cm) : "+this.height+"cm");
		System.out.println("몸무게(kg) : "+this.weight+"kg");
	}
	

	
	
	
}
