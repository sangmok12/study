package study0503;

import java.util.Scanner;

public class Method_quiz2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("첫번째 숫자 입력>> ");
		int a = scn.nextInt();
		
		System.out.print("두번째 숫자 입력>> ");
		int b = scn.nextInt();
		
		System.out.print("연산기호 입력 >> ");
		String c = scn.next();
		myCalc(a,b,c);
		myCalcc(a,b,c);

	}

	public static void myCalc(int a,int b,String c) {
		int result = 0;
		switch(c) {
		case "-" : result = a-b;
			break;
		case "+" : result = a+b;
			break;
		case "*" : result = a*b;
			break;
		case "/" : result = a/b;
			break;
		}
		System.out.println(a+c+b+"="+result);
	}
	public static void myCalcc(int a,int b,String c) {
		int result = 0;
		if (c == "*") 	 {result = a*b;}
		else if (c=="+") {result = a+b;}
		else if (c=="/") {result = a/b;}
		else if (c=="-") {result = a-b;}
		System.out.println(a+c+b+"="+result);
	}
	
	
}
