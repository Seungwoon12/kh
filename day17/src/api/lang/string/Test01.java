package api.lang.string;

public class Test01 {
	public static void main(String[] args) {
		String a = new String("Hello java"); 	//1번
		String b = new String("hello java");
		
		
		System.out.println(a.equals(b)); //2번
		
		if(a.compareToIgnoreCase(b) == 0) { //3번
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		
		System.out.println(a.startsWith("Hello")); //4번
		
		System.out.println(b.endsWith("java")); //5번
	
			
		
		System.out.println("a의 글자수(공백 포함) : "+a.length()); //6번
	
		a = a.replace(" ","");
		
		System.out.println("a의 글자수(공백 제외) : "+ a.length());
	
		
		
		System.out.println("b의 글자수(공백 포함) : "+ b.length());
		
		b = b.replace(" ","");
		
		System.out.println("b의 글자수(공백 제외) : "+b.length());
		
		
	}
}
