package extratest1;

public class Score {
	private String name;
	private int java;
	private int jsp;
	
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
	
	public Score(String name, int java, int jsp) {
		this.setName(name);
		this.setJava(java);
		this.setJsp(jsp);
	}
	
	public int getTotal() {
		return this.java + this.jsp;
	}
	
	public double getAverage() {
		return this.getTotal() / 2.0;
	}
	
	public void print() {
		System.out.println("<학생 정보>");
		System.out.println("이름 : "+this.name);
		System.out.println("자바점수 : "+this.java);
		System.out.println("JSP점수 : "+this.jsp);
		System.out.println("총점 : "+this.getTotal());
		System.out.println("평균 : "+this.getAverage());
	}
	
	
}
