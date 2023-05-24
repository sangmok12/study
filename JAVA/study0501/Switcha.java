package study0501;

import java.util.Scanner;

public class Switcha {

	public static void main(String[] args) {
		
		//Ctrl + Shift + O
		Scanner scn = new Scanner(System.in);
		System.out.print("연산자(+,-,*,/)를 입력 : ");
		String math = scn.next();
		
		
		int n1 = 94;
		int n2 = 15;
		int result = 0;
		
		switch (math) {
			case "+" : result = n1 + n2;
				break;
			case "-" : result = n1 - n2;
				break;
			case "*" : result = n1 * n2;
				break;
			case "/" : result = n1 / n2;
				break;
			default : 
		}
			System.out.println(n1+math+n2 + "=" + result);

		
		
	}

}
