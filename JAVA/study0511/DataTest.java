package study0511;

import java.util.Calendar;
import java.util.Scanner;

public class DataTest {

	public static void main(String[] args) {

		// 랜덤 : 1 ~100 사이의 값 생성
		// 시스템이 얻은 값을 맞추는 문제
		//0 < x < 1 사이의 값을 맞춤
		
		Calendar cal = Calendar.getInstance();
		
		
		
		int r =(int)(Math.random()*20) + 1;
		Scanner scn = new Scanner(System.in);
		
		int cnt = 0;
		long u1 = cal.getTimeInMillis();
		while(true) {
			System.out.println(" 숫자입력>> ");
			int a = scn.nextInt();
			if ( r == a ) {
				System.out.println(a+"입력, 정답입니다. !");
		
				break;
			} else {
				System.out.println(a+"입력, 오답입니다. !");
			}
			cnt++;
			if ( cnt == 20 )break;
		}
		cal = Calendar.getInstance();
		long u2 = cal.getTimeInMillis();
		int result = (int)(u2 - u1);
		System.out.println("시간 : "+result/1000+"초 걸림");
	}

}
