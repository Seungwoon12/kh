package api.lang.integer;

public class Test02 {
	public static void main(String[] args) {
		//Integer 같은 클래스를 Wrapper 클래스라 부른다(=하이브리드 자료형)
		// - int가 좋은점이있고 Integer가 좋은점이 있으며, 둘은 호환이 가능하다.
		// - int는 연산자를 사용하여 계산할 수 있으며, 단순계산에 특화
		// - Integer는 제공되는 메소드를 사용할 수 있으며, 복잡한 계산에 특화
		
		//int가 좋은 상황
		// - 10+20을 계산
		int a = 10;
		int b = 20;			// >> 원시형 코드
		int c = a + b;
		System.out.println(c);
		
		Integer d = new Integer(10);
		Integer e = new Integer(20);		// >> 참조형 코드
		Integer f = Integer.sum(d, e);
		System.out.println(f.toString());
		
		//Integer가 좋은 상황
		// - 30을 2진수로 변환  = 16 + 8 + 4 + 2 + 0 = 11110
		
		int n = 30;
		String str = "";
		for(int i=n; i > 0; i /= 2) {
			str = i%2 + str;
		}
		System.out.println(str);
		
		String str2 = Integer.toBinaryString(30);
		System.out.println(str2);
		
		System.out.println(Integer.toOctalString(30)); //8진수
		System.out.println(Integer.toHexString(30)); //16진수
		
		//둘은 서로 호환이 가능하다
		Integer v1 = 10; // int가 Integer로 보관(값이 포장된다), auto-boxing(int가 Integer로 변환)
		int v2 = new Integer(10); //Integer가 int로 보관(값의 포장이 벗겨진다), auto-unboxing
		
		//하이브리드 자료형(Wrapper class(이게 공식명칭))
		// - boolean	<---> 	Boolean
		// - byte		<--->	 Byte
		// - short		<--->	 Short
		// - char		<---> 	Character
		// - int		<---> 	Integer
		// - long		<---> 	Long
		// - float		<---> 	Float
		// - double		<---> 	Double
		

		//Long p = 1;//error 대각선은 안됨
		//long q = 1;//ok
	
	}
}
