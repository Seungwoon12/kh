package thread;

public class Test02 {
	public static void main(String[] args) {
		//두 가지 작업을 동시에 진행(쓰레드 생성)
		//- 빨래돌리기 -> 빨래널기
		//- 청소 -> 요리
		
		//생성 - run 메소드를 "반드시" 재정의(규칙) - 재정의된 메소드 안에 해야할 작업을 지시
		Thread t = new Thread() {
			@Override
			public void run() {
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
			}
		};
		t.start();//구동
		
		
		//메인이 할일
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