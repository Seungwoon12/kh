package oop.modifier3;

//집 = 지역 + 평수 + 가격
public class House {
	//멤버변수(인스턴스변수) - 반드시 잠금처리
	private String area;
	private int size;
	private int price;
	
	//멤버 메소드(인스턴스 메소드) - 공개처리

	//- 세터(setter) 메소드 : 설정 처리
	public void setArea(String area) {
		this.area = area;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//게터(getter) 메소드 : 반환 처리
	// - void : 반환값(결과물)이 없음
	// - String : 반환값이(결과물)이 String 형태
	public String getArea() {
		//내가 가진 area 변수값을 반환하며 종료하라
		return this.area;
	}
	public int getSize() {
		return this.size;
	}
	public int getPrice() {
		return this.price;
	}
}
