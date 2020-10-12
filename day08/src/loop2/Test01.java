package loop2;

public class Test01 {
	public static void main(String[] args) {
		//while 구문
		// - for와 유사하지만 용도가 약간 다르다
		
		//비교를 위해 for와 while로 각각 1부터 10까지 출력
		//for(선언부; 조건부; 증감부) {코드} 
		
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(i);
		}
		
		int n=1; //...............선언부(외부)
		while(n <= 10) { //..................조건부
			System.out.println(n);
			n++;//...................증감부(내부)
		}	
	
	}
}
