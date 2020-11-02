package oop.extend1;

public class Student {
	private String name;
	private int java;
	private int jsp;
	
	public Student(String name, int java, int jsp) {
		this.name = name;
		this.java = java;
		this.jsp = jsp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	//합계와 평균을 구하는 getter 메소드(자동계산)
	public int getTotal() {
		return this.java + this.jsp;
	}
	public double getAverage() {
		return this.getTotal() / 2.0;
	}
	
	//출력 메소드
	public void print() {
		System.out.println("<학생 정보>");
		System.out.println("이름 : "+this.name);
		System.out.println("자바점수 : "+this.java);
		System.out.println("JSP점수 : "+this.jsp);
		System.out.println("총점 : "+this.getTotal());
		System.out.println("평균 : "+this.getAverage());
	}
}
