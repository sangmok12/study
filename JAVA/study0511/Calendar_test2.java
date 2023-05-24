package study0511;

import java.util.Calendar;

public class Calendar_test2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		//시스템은 0월부터라서 -1달 해야함 안그러면 +1 달로 인식함.
		cal.set(2021,11,25);
		
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;
		int dd = cal.get(Calendar.DATE);
		
		
		int ww = cal.get(Calendar.DAY_OF_WEEK);
		String str = "";
		switch(ww) {
			case 1 : str = "일";
			break;
			case 2 : str = "월";
			break;
			case 3 : str = "화";
			break;
			case 4 : str = "수";
			break;
			case 5 : str = "목";
			break;
			case 6 : str = "금";
			break;
			case 7 : str = "토";
			break;
		}
		System.out.println(yy + "/" + mm +"/"+ dd);
		System.out.println(str);
		
		
	}

}
