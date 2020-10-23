package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) {
//		날짜 계산 기능
//		- 열흘 뒤가 몇일이지?
//		- 현재 날짜를 구한다 → 10일을 더한다 → 출력한다
		
		Calendar c = Calendar.getInstance();
		
//		날짜가 넘어가는 것을 신경쓰지 않아도 알아서 변환해준다
		c.add(Calendar.DATE, 10);//날짜를 +10
		
//		출력
		Date d = c.getTime();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(f.format(d));
	}
}