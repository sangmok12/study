package study0502;

import java.util.Scanner;

public class While_test {

	public static void main(String[] args) {
		int a = 1;
		while(a<=5 ) {
			System.out.print(a + " ");
			++a;
		}
		System.out.println();
		System.out.println("-------------");
		
		
		
		int b = 10;
		while(b>=1) {
			System.out.print(b + " ");
			--b;
		}
		
		System.out.println();
		System.out.println("-------------");
		
		
		
		int[] months = {1,3,5,10,12};
		int idx = 0;
		while(idx < months.length) {
			System.out.println(months[idx] + "월 ");
			idx++;
		}
		
		for (int i=0; i<months.length; i++) {
			System.out.println(months[i] + "월 ");
		}
		//배열관련 심플한 설정
		//for ( 변수명 : 배열명 ) { }
		for ( int c : months) {
			System.out.println(c + "월 ");
		}
		
		String[] str = {"aa","bb","cc"};
		for (String d : str) {
			System.out.println(d);
		}
		
		
		
		
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("양수를 입력 : ");
			int y = scn.nextInt();
			
			if (y <=                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             0) {
				System.out.println("양수가 아니므로 반복문을 종료합니다.");
				break;
			}
			else if (y >=0) {
					System.out.println(y + "를 입력했습니다.");
			}
			}
		
	}

}
