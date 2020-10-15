package oop.modifier3;

public class House {
	
	private String area;
	private int size;
	private int price;
	
	public void setArea(String area) {
		this.area = area;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	
	//게터(getter) 메소드 : 반환처리
	// - void : 반환값(결과물)이 없음
	// - String : 반환값(결과물)이 String 형태
	public String getArea() {
		//내가 가진 area 변수값을 반환하며 종료하라	
		return this.area;		
	}
	public int getPrice() {
		return this.price;
	}
	public int getSize() {
		return this.size;
	}
}
