package api.exception;

public class Test05 {
	public static void main(String[] args) {
		//Calculator를 이용하여 나누기 수행
		// - 예외는 시킨놈(Caller,호출자)쪽에 적는게 좋다
		// - 좋은거 알겠는데 안적으면 어쩔거냐?
		
		try {
			int n = Calculator.div(10, 0);
			System.out.println("n = "+n);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}