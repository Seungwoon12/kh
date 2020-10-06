package condition;
import java.util.Scanner;
public class Test06 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		System.out.print("가는 월 : ");
		int month = sc.nextInt();
		System.out.print("여행 일수 : ");
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
		System.out.println("할인 : "+discount+"원");
		System.out.println("할인 후 : "+result+"원");
		
				
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("인원수(명) : ");
//		int num = sc.nextInt();
//		System.out.print("여행기간(월) : ");
//		int month = sc.nextInt();
//		System.out.print("여행일수(일) : ");
//		int day = sc.nextInt();
//		switch(month) {
//		case 3: case 4: case 5:
//			System.out.println("할인받기 전 금액 : "+num*10*day+"만원");
//			System.out.println("할인 금액 : "+num*10*day*0.3+"만원");
//			System.out.println("할인받은 후 금액 : "+(num*10*day-num*10*day*0.3)+"만원");
//			break;
//		case 6: case 7: case 8:
//			System.out.println("할인받기 전 금액 : "+num*10*day+"만원");
//			System.out.println("할인 금액 : "+num*10*day*0+"원");
//			System.out.println("할인받은 후 금액 : "+num*10*day+"만원");
//			break;
//		case 9: case 10: case 11:
//			System.out.println("할인받기 전 금액 : "+num*10*day+"만원");
//			System.out.println("할인 금액 : "+num*10*day*0.15+"만원");
//			System.out.println("할인받은 후 금액 : "+(num*10*day-num*10*day*0.15)+"만원");
//			break;
//		case 12: case 1: case 2:
//			System.out.println("할인받기 전 금액 : "+num*10*day+"만원");
//			System.out.println("할인 금액 : "+num*10*day*0.05+"만원");
//			System.out.println("할인받은 후 금액: "+(num*10*day-num*10*day*0.05)+"만원");
//			break;
//	
//		}
//		
//	}
//}
//		Scanner sc = new Scanner(System.in);
//		System.out.print("여행기간(월) : ");
//		int month = sc.nextInt();
//		System.out.print("여행인원(명) : ");
//		int num = sc.nextInt();
//		System.out.print("여행일수(일) : ");
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
//		System.out.printf("할인받기 전 금액 : %d만원\n", money);
//		System.out.printf("할인 금액 : %.2f만원\n", (money*sale));
//		System.out.printf("할인받은 후 금액 : %.2f만원\n", money*(1-sale));
		
		
				
	
		
		
		



//		Scanner sc = new Scanner(System.in);
//		System.out.print("인원 수를 입력하세요 : ");
//		int num = sc.nextInt();
//		System.out.print("여행일자가 몇월인지 입력하세요 : ");
//		int month = sc.nextInt();
//		System.out.print("여행 일수를 입력하세요 : ");
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
//		System.out.printf("할인받기 전 금액 : %d만원\n",money);
//		System.out.printf("할인 금액 : %.2f만원\n",(money*sale));
//		System.out.printf("할인받은 후 금액 : %.2f만원\n",(money*(1-sale)));
	}
}

