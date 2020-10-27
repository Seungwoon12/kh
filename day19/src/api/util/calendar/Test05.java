package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("연도를 입력하세요.");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요.");
		int month = sc.nextInt();
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_WEEK, 1);
		
		Date d = c.getTime();
		SimpleDateFormat f1 = new SimpleDateFormat("E");
		SimpleDateFormat f2 = new SimpleDateFormat("d");
		
		
		System.out.println(year+"년 "+month+"월");
		
		for(int i=0; i<7; i++) {
			System.out.print(f1.format(d)+"\t");
			c.add(Calendar.DAY_OF_WEEK, 1);
			d = c.getTime();
		}
		System.out.println();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, 1);
		
		int num = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.DATE, -num+1);
		d = c.getTime();
		
		for(int j=0; j<6; j++) {
			for(int i=0; i<7; i++) {
				System.out.print(f2.format(d)+"\t");
				c.add(Calendar.DATE, 1);
				d = c.getTime();
			}
			System.out.println();
		}	
		
	}
}
