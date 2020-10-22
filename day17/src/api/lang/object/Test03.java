package api.lang.object;

public class Test03 {
	public static void main(String[] args) {
		Student st = new Student();
		
		//이론상 st에는 아무 기능도 없어야 한다.
		int v = st.hashCode();
		String s = st.toString();
		System.out.println(v);
		System.out.println(s);
	}
}
