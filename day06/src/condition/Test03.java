package condition;

public class Test03 {
	public static void main(String[] args) {
		int user = 6;
		switch(user) {
		case 1:
			System.out.println("����!");
			break; // �̰Ÿ� �����ϰ� �׸� �����ض�
				
		case 2:
			System.out.println("����!");
			
		case 3:	
			System.out.println("��!");
			
		default: //else�� ���� ���
			System.out.println("�߸� �Է��߾��!");
			break;	
		}
	}
}
