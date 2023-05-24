package study0511;

import java.util.Calendar;

public class UnixTime_test1 {

	
	// 1000/1000   -> 1
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		
		//int(21억) 로도 담을수 없어서 long  사용함.
		long unix = cal.getTimeInMillis();
		System.out.println(unix);
		
	
		long unix2 = 1183772860997L;
		
		cal.setTimeInMillis(unix2);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DATE);
		
		System.out.println(yy + "/" + mm +"/" + dd);
		
		
		
	}

}
