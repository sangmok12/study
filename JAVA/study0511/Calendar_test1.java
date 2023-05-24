package study0511;

import java.util.Calendar;

public class Calendar_test1 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
	//	int year = cal.get(Calendar.YEAR);
		int year = cal.get(1);
	//	int month = cal.get(Calendar.MONTH);
		int month = cal.get(2) + 1;
	//	int date = cal.get(Calendar.DATE);
		int date = cal.get(5);
		
		System.out.println(year +"/"+ month +"/"+ date);
		
		
		
		
		
		cal.add(Calendar.DATE,40);
		year = cal.get(1);
		month = cal.get(2) + 1;
		date = cal.get(5);

		System.out.println(year +"/"+ month +"/"+ date);
		
		
		
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int mi = cal.get(Calendar.MINUTE);
		int se = cal.get(Calendar.SECOND);
		
		System.out.println(h +":"+ mi +":"+ se);
		
		System.out.println("am/pm : " + cal.get(Calendar.AM_PM));
		System.out.println("현재요일 : " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("올해 몇 번째 날 : " + cal.get(Calendar.DAY_OF_YEAR));
		System.out.println("올해 몇 번째 주 : " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이번 달의 몇 번째 주 : " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이번 달의 마지막 날 : " + cal.getActualMaximum(Calendar.DATE));
		
		
		
	}

}
