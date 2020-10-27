package api.lang.etc;

public class Test02 {
	public static void main(String[] args) {
		//java.lang.System 클래스
		//- 생성자가 없음(편하게 사용하도록 미리 등록)
		
		//표준 출력 : System.out
		System.out.println("안녕");
		
		//표준 에러 : System.err
		System.err.println("안녕");
		
		//표준 입력 : System.in + Scanner
	
		//운영체제의 시간 정보 불러오기
		// - 프로그래밍에서는 기준시라 불리는 시간이 있다(1970년 1월 1일 0시 0분 0초)
		// - currentTimeMillis() 는 기준시로부터 흐른 총 밀리초를 반환한다
		// - 1970년 1월 1일부터 1603436104489밀리초가 지난 상태이다 <--- currentTimeMillis()
		// - 1970년 1월 1일부터 1603436104초가 지난 상태이다.
		// - 1970년 1월 1일부터 26723935분이 지난 상태이다.
		// - 1970년 1월 1일부터 445398시간이 지난 상태이다.
		// - 1970년 1월 1일부터 18558일이 지난 상태이다.
		// - 1970년 1월 1일부터 50년이 지난 상태이다.
		long time = System.currentTimeMillis();
		System.out.println("time = " + time);
		
		//프로그램 종료
		//System.exit(0);
		//System.out.println("hello");//절대 출력될 수 없는 메시지(바로 위에서 종료됨)
		
		//운영체제의 각종 상태 불러오기
		//getProperty()
		System.out.println(System.getProperties());
		System.out.println(System.getProperty("os.name"));//os.name에 연결된 value를 불러와라
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("java.specification.version"));//자바버전
		System.out.println(System.getProperty("user.language"));
	}
}


