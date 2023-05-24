package study0515;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_Num {

	public static void main(String[] args) {
		int answer = (int)(Math.random()*100) + 1;
		int input = 0;
		int count = 0;

		Scanner scn;
		while(true) {
			try {
				count++;
				scn = new Scanner(System.in);
				System.out.println("1~100 intsert");
				
				input = scn.nextInt();
				if(answer > input) {
					System.out.println("more big");
				}else if (answer < input) {
					System.out.println("more small");
				} else {
					System.out.println("ok~~");
					System.out.println(count + "회에 맞춤");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
	}

}
