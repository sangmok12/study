package study0501;

import java.util.Calendar;
import java.util.Scanner;

public class For_test1 {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);
		
		
		
		for (int n=1; n<=100; n+=2) {
			System.out.print(n + " ");
		}
		
		
			System.out.println();
			
			
		for (int n=1; n<=100; n++) {
			if (n%2 == 1) {
				System.out.print(n+ " ");
			}
		}
		
		
		System.out.println();
		System.out.println();
		
		int q = 6;
		for (int n=1; n<=q; n++) {
			if (n==q) {
				System.out.println("문항 " + n +" : 오답");
			}
			else {
				System.out.println("문항 " + n + " : 정답");
			}
		}
		
		System.out.println();
		System.out.println();
		
		Calendar cal = Calendar.getInstance();
		int yy = cal.get(Calendar.YEAR);
		
		for (int n=2021; n<=2025; n++) {
			if (n==yy) {
				System.out.print("("+n + "년) ");
			}
			else {
				System.out.print(n + "년 ");
			}
		}
		
		System.out.println();
		System.out.println();
		
		
		System.out.print("구구단 단수 입력 : ");
		
		int dan = scn.nextInt();
		System.out.println();
		for (int n=1; n<=9; n++) {
			System.out.println(dan + " X " + n + " = " + (dan * n));
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("별 출력 개수 입력 : ");
		int star = scn.nextInt();
		for (int n=1; n<=star; n++) {
			System.out.print("* ");
		}
		
	}

}
