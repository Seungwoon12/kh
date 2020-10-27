package api.util.calendar;

import java.util.Calendar;

public class Test01 {
	public static void main(String[] args) {
//		java.util.Calendar 클래스
//		- 추상 클래스
//		- 객체 생성 불가
//		- 별도의 생성명령이 존재
		
//		Calendar c = new Calendar();
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
//		1. 설정 : .set(항목, 값);
//		2. 반환 : .get(항목)
//		- YEAR : 연도
//		- MONTH : 월(Calendar에서 월은 0부터 11까지로 설정한다) - 꺼낼 때 +1 ,설정할 때 -1
//		- DATE/DAY_OF_MONTH : 일
//		- HOUR/HOUR_OF_DAY : 시간
//		- MINUTE : 분
//		- SECOND : 초
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = c.get(Calendar.MONTH) + 1;
		System.out.println(month);
		
//		int day = c.get(Calendar.DATE);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		int hour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		int minute = c.get(Calendar.MINUTE);
		System.out.println(minute);
		
		int second = c.get(Calendar.SECOND);
		System.out.println(second);
	}
}