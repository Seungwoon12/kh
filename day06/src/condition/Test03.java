package condition;

public class Test03 {
	public static void main(String[] args) {
		int user = 6;
		switch(user) {
		case 1:
			System.out.println("가위!");
			break; // 이거만 실행하고 그만 실행해라
				
		case 2:
			System.out.println("바위!");
			
		case 3:	
			System.out.println("보!");
			
		default: //else랑 같은 기능
			System.out.println("잘못 입력했어요!");
			break;	
		}
	}
}
