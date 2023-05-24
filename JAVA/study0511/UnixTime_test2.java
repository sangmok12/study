package study0511;

import java.util.Calendar;

public class UnixTime_test2 {
	
	
	// 모든클래스에서 접근할 수 있고 클래스명으로 접근하는 메소드
	public static int doomDay(String date) {
		
		Calendar cal = Calendar.getInstance();
		long unix = cal.getTimeInMillis()/1000;
		
		
		String[] d1 = date.split("-");
		int yy = Integer.parseInt(d1[0]);
		int mm = Integer.parseInt(d1[1]);
		int dd = Integer.parseInt(d1[2]);
		cal.set(yy,mm-1,dd);
		long unix2 = cal.getTimeInMillis()/1000;
		
		int dday = (int)((unix2-unix)/(60*60*24));
		return dday;
	}
	
public static int diffDay(String date, String date2) {
		
		Calendar cal = Calendar.getInstance();
		
		String[] d1 = date.split("-");
		int yy = Integer.parseInt(d1[0]);
		int mm = Integer.parseInt(d1[1]);
		int dd = Integer.parseInt(d1[2]);
		cal.set(yy,mm-1,dd);
		long unix = cal.getTimeInMillis()/1000;
		
		String[] d2 = date2.split("-");
		yy = Integer.parseInt(d2[0]);
		mm = Integer.parseInt(d2[1]);
		dd = Integer.parseInt(d2[2]);
		cal.set(yy,mm-1,dd);
		long unix2 = cal.getTimeInMillis()/1000;
		
		int dday = (int)((unix2-unix)/(60*60*24));
		return dday;
	}

	public static void main(String[] args) {
		/*1.  크리스마스 D-day
		 * 
		 * a = 지금 시점의 유닉스 시간/1000
		 * b = 크리스마스 시점의 유닉스 시간/1000
		 * 
		 *  b-a / 60*60*24  = > 답
		 */
		
		
		Calendar cal = Calendar.getInstance();
		long unix = cal.getTimeInMillis()/1000;
		System.out.println(unix);
		
		cal.set(2023,11,25);
		long unix2 = cal.getTimeInMillis()/1000;
		System.out.println(unix2);
		
		int Ch_day = (int)((unix2-unix)/(60*60*24)); 
		System.out.println("크리스마스까지 D-Day : " +Ch_day+ "일");
		
		
		cal.set(2021,05,11);
		long unix3 = cal.getTimeInMillis()/1000;
		cal.set(2021,10,2);
		long unix4 = cal.getTimeInMillis()/1000;
		
		int r = (int)((unix4-unix3)/(60*60*24));
		System.out.println(r);
		
		
		System.out.println("크리스마스까지 D-Day : " +doomDay("2023-12-25")+ "일");
		
		
	}

}
