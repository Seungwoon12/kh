package oop.inherit3;

//하위클래스, 자식클래스
// = 부모클래스를 상속받아 기능 확장(extend)
public class Pororo extends Doll{
	//변수2개, 메소드1개 상속완료(+@ 만 구현하면 됨)
	public void nag() {
		System.out.println("조심해 크롱!");
	}
	
	public void print() {
		//this(나), super(상위)
		System.out.println("이름 : "+super.name);
		System.out.println("가격 : "+super.price);
	}
	
	//hello가 있긴 있어야 되는데 내용이 마음에 안드니까 재정의(Override)
	// - 원본과 동일하게 구성해야함
	@Override//이거 재정의 한 메소드임!(Annotation, 어노테이션)	
	public void hello() {
		System.out.println("안녕 난 뽀로로야");
	}
	
	//부모클래스에 생성자가 있으면 나도 있어야 된다(형태를 맞춘다!)
	// - 부모클래스 생성에 필요로 데이터를 넘겨주지 않으면 절대 상속 불가!
	public Pororo(String name) {
		super(name);
	}
}