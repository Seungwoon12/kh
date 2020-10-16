package oop.inherit3;

//인형 : 뽀로로와 타요 인형의 공통점만 추려서 보관하는 클래스
// - 상위클래스, 슈퍼클래스, 부모클래스, 추상클래스

//- 변수와 메소드, 생성자를 어떤 형태로 구현하는 것이 좋을지 고민
//- 변수 : 접근제한 설정
//- 메소드 : 재정의(오버라이드, Override)를 고려하여 설정
//- 생성자 : 필수데이터에 대한 설정 여부

public class Doll {
	//변수 : 나만쓸건지(private) 아니면 내자식도 쓰게할건지(protected)
	protected String name;
	protected int price;
	
	//메소드 : 기능은 동일한데 내용이 달라야 하는 경우가 존재
	// - final : 재정의 금지
	public void hello() {
		System.out.println("안녕!");
	}
	
	//생성자를 만들면 "이 데이터는 반드시 설정해야 한다"는 뜻
	public Doll(String name) {//인형 만들려면 이름이 있어야돼!
		this.name = name;
	}
}