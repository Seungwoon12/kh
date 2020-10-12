package condition;
import java.util.Scanner;
public class Test06 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수를 입력하세요 : ");
		int people = sc.nextInt();
		System.out.print("기간을 일단위로 입력하세요: ");
		int month = sc.nextInt();
		System.out.print("여행가실 월을 입력하세요 : ");
		int day = sc.nextInt();
		
		int rate;
		switch(month/3) {
		case 1:
			rate = 30;
			break;
		case 2: 
			rate = 0;
			break;
		case 3:
			rate = 15;
			break;
		default:
			rate = 5;
			break;
		}
		
		
		int total = people*day*100000;		
		int discount = total*rate/100;
		int result = total-discount;
		
		System.out.println("할인 전 : "+total+"원");
		System.out.println("할인금액: "+discount+"원");
		System.out.println("할인 후 : "+result+"원");
		
				
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("�ο���(��) : ");
//		int num = sc.nextInt();
//		System.out.print("����Ⱓ(��) : ");
//		int month = sc.nextInt();
//		System.out.print("�����ϼ�(��) : ");
//		int day = sc.nextInt();
//		switch(month) {
//		case 3: case 4: case 5:
//			System.out.println("���ιޱ� �� �ݾ� : "+num*10*day+"����");
//			System.out.println("���� �ݾ� : "+num*10*day*0.3+"����");
//			System.out.println("���ι��� �� �ݾ� : "+(num*10*day-num*10*day*0.3)+"����");
//			break;
//		case 6: case 7: case 8:
//			System.out.println("���ιޱ� �� �ݾ� : "+num*10*day+"����");
//			System.out.println("���� �ݾ� : "+num*10*day*0+"��");
//			System.out.println("���ι��� �� �ݾ� : "+num*10*day+"����");
//			break;
//		case 9: case 10: case 11:
//			System.out.println("���ιޱ� �� �ݾ� : "+num*10*day+"����");
//			System.out.println("���� �ݾ� : "+num*10*day*0.15+"����");
//			System.out.println("���ι��� �� �ݾ� : "+(num*10*day-num*10*day*0.15)+"����");
//			break;
//		case 12: case 1: case 2:
//			System.out.println("���ιޱ� �� �ݾ� : "+num*10*day+"����");
//			System.out.println("���� �ݾ� : "+num*10*day*0.05+"����");
//			System.out.println("���ι��� �� �ݾ�: "+(num*10*day-num*10*day*0.05)+"����");
//			break;
//	
//		}
//		
//	}
//}
//		Scanner sc = new Scanner(System.in);
//		System.out.print("����Ⱓ(��) : ");
//		int month = sc.nextInt();
//		System.out.print("�����ο�(��) : ");
//		int num = sc.nextInt();
//		System.out.print("�����ϼ�(��) : ");
//		int day = sc.nextInt();
//		int money = num*day*10;
//		double sale = 0;
//		switch(month) {
//		case 3: case 4: case 5:
//			sale = 0.3;
//			break;
//		case 6: case 7: case 8:
//			sale = 0;
//			break;
//		case 9: case 10: case 11:
//			sale = 0.15;
//			break;
//		case 12: case 1: case 2:
//			sale = 0.05;
//			break;
//		}
//		System.out.printf("���ιޱ� �� �ݾ� : %d����\n", money);
//		System.out.printf("���� �ݾ� : %.2f����\n", (money*sale));
//		System.out.printf("���ι��� �� �ݾ� : %.2f����\n", money*(1-sale));
		
		
				
	
		
		
		



//		Scanner sc = new Scanner(System.in);
//		System.out.print("�ο� ���� �Է��ϼ��� : ");
//		int num = sc.nextInt();
//		System.out.print("�������ڰ� ������� �Է��ϼ��� : ");
//		int month = sc.nextInt();
//		System.out.print("���� �ϼ��� �Է��ϼ��� : ");
//		int day = sc.nextInt();
//		int money = num*day*10;
//		double sale=0;
//		switch (month) {
//		case 3 : case 4 : case 5 :
//			sale = 0.3;
//			break;
//		case 6 : case 7 : case 8 :
//			sale = 0.0;
//			break;
//		case 9 : case 10 : case 11 :
//			sale = 0.15;
//			break;
//		case 12 : case 1 : case 2 :
//			sale = 0.05;
//			break;
//		}
//		System.out.printf("���ιޱ� �� �ݾ� : %d����\n",money);
//		System.out.printf("���� �ݾ� : %.2f����\n",(money*sale));
//		System.out.printf("���ι��� �� �ݾ� : %.2f����\n",(money*(1-sale)));
	}
}

