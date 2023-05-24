package study0511;

import java.util.Calendar;

public class Calendar_set {
	
	public static void calView(String date) {
		
		
		String[] d1 = date.split("-");
		int yy = Integer.parseInt(d1[0]);
		int mm = Integer.parseInt(d1[1]);
		//인스턴스(객체)화
		Calendar cal = Calendar.getInstance();
		//출력 날짜 셋팅
		cal.set(yy,mm-1,1);   //2023-03-01
		
		// 세팅 날짜의 요일을 얻음
		int week = cal.get(Calendar.DAY_OF_WEEK);  //수요일 , 4 
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);  // 세팅달의 마지막 날짜
		// 날짜 출력 시 한줄 7칸 맞추는 용도
		int ln = 0;
		
		
		System.out.println(yy+"년 "+mm+"월 달력\n\n");
		System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토\n");
		//달력의 첫날의 출력 전, 공백 발생
		for (int w=1; w<week;w++) {
			System.out.print("\t");
			ln++;
		}
		//ln = 3;
		for (int d=1; d<=lastDay; d++) {
			
			if (d<10) {
				System.out.print(" " + d + "일\t");
				ln++;
			} else {
			System.out.print(d + "일\t");
			ln++;   } // ln = w + d 

			
			if(ln == 7) {
				System.out.println();
				ln = 0;
			}
		}
	}
	
	public static void main(String[] args) {
	
	}

}
