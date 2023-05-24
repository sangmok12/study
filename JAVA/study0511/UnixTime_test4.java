package study0511;

import java.util.Calendar;

public class UnixTime_test4 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		

		String aa = "1498137807001";
		
		long u1 = Long.parseLong(aa);
		long u2 = (u1/1000 + (60*60*24*60));
		cal.setTimeInMillis(u2*1000);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DATE);
		System.out.println(yy + "/" + mm +"/" + dd);
		
		
		cal.add(Calendar.DATE,-60);
		 yy = cal.get(Calendar.YEAR);
		 mm = cal.get(Calendar.MONTH) + 1;
		 dd = cal.get(Calendar.DATE);
	
		System.out.println(yy + "/" + mm +"/" + dd);
	
	}

}
