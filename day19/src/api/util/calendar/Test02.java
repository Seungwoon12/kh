package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		//Q : Calendar는 Date와 호환이 가능한가?
		// - Date가 출력은 빠르고 편하던데...(+SimpleDateFormat)
		
		Calendar c = Calendar.getInstance();
		
//		정보 설정 : .set(항목, 값)
		
//		1.연도를 2021년으로 변경
		c.set(Calendar.YEAR, 2021);
//		2.월을 5월로 변경
		c.set(Calendar.MONTH, 4);
//		3.일을 3일로 변경
		c.set(Calendar.DATE, 3);
				
//		c.set(2021, 4, 3);
		
//		.getTime() : Calendar의 날짜정보를 Date로 옮김
		Date d = c.getTime();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(f.format(d));
	}
}