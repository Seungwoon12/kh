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
	
	
}
