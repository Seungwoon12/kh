package api.exception;

public class Test06 {
	public static void main(String[] args)  {
//		실제로 예외전가를 마주하는 상황들
//		- Unhandled exception type OOOOException 메세지가 나온다
		
		for(int i=10; i>=0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000L);//1000밀리초(1초) 정지
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}