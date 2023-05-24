package study0502;

import java.util.Scanner;

public class Array_test {

	public static void main(String[] args) {
		 
		
		Scanner scn = new Scanner(System.in);
		
		
		System.out.println("-------풀어보기 (1)-------");
		
		for (int a=1; a<=17; a++) {
			/* if (a%5==0) {
				 System.out.print(a + "** ");
			 }
			 else if (a%5 != 0) {
				 System.out.print(a + " ");
			 } */
			 
			 System.out.print( a%5==0 ? a+"** " : a+" ");
		 }
		System.out.println();
		System.out.println();
		System.out.println("-------풀어보기 (2)-------");
		
		
		int[] months= {1,3,6,8,10,12};
		String season = "";
		for (int i=0; i<months.length; i++) {
			int m = months[i];
			if      (11<=m || m < 3) { season = "겨울";}
			else if (9 <=m && m< 11) { season = "가을";}
			else if (6 <=m && m < 9) { season = "여름";}
			else if (3 <=m && m < 6) { season = "봄"; }
			System.out.println(((m<10)?"0":"")+ m + "월 : " + season);	
		}
		
		System.out.println();
		System.out.println("-------풀어보기 (3)-------");
		
		for (int i=2; i<=4; i++) {
			for (int a=1; a<=3; a++) {
				System.out.println(i +"*" + a + " = " + i*a);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------풀어보기 (4)-------");
		System.out.println("-------별 예제 1-------");
		
		
		for (int a=1;a<=5;a++) {
			for (int b=1;b<=a;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------별 예제 2-------");
		
		for (int a=5;a>=1;a--) {
			for (int b=1;b<=a;b++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------풀어보기 (5)-------");
		
		String[] coffee = {"아메리카노","카푸치노","카페라떼","오늘의 커피"};
		int[] price = {3500,4500,4300,3500};
			while(true) {
				System.out.println("커피 번호를 선택해주세요.");
				System.out.println("1. 아메리카노 2. 카푸치노 3. 카페라떼 4. 오늘의 커피 5. 주문취소");
				System.out.print("번호 >> ");
				int c = scn.nextInt();
					if (c == 5) {
						System.out.println(">>주문을 취소했습니다.(종료)");
					}
					else {
						System.out.println(">>" + coffee[c-1] + "를 선택하셨습니다.");
						System.out.println(">>" + price[c-1] + "원 결제를 부탁드립니다.");
					}
					break;
			}
		
		
			
	
		
		
	}

}
