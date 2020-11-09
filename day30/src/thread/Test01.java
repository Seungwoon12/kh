package thread;

public class Test01 {
	public static void main(String[] args) {
		//동기화된 처리 방식
		System.out.println("빨래 돌리기 시작!");
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		
		System.out.println("빨래 돌리기 끝!");
		System.out.println("빨래 널기 시작!");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		
		System.out.println("빨래 널기 끝!");
		System.out.println("청소 시작!");
		
		try {
			Thread.sleep(500);
		}catch(Exception e) {}
		
		System.out.println("청소 끝!");
		System.out.println("요리 시작!");
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		
		System.out.println("요리 끝!");
		
	}
}
