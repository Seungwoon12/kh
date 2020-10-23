package api.exception;

//계산기
public class Calculator {
	//나누기 기능
	// - 여태까지 파악해본 결과 나누기 기능은 오류가 발생할 가능성이 있다
	// - 불완전한 메소드(100% 실행된다고 보장할 수 없음)
	// - 저는 불완전한 메소드에요 라고 표시
	// - 예외 전가(예외 몰아주기) : throws 
	public static int div(int a, int b) throws Exception {
		return a / b;
	}
}