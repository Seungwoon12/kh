package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test04 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 25);
		
		Date d = c.getTime();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(f.format(d));
		
		c.add(Calendar.DATE, -100);
		
		d = c.getTime();
		
		System.out.println(f.format(d));
				
	}
}
