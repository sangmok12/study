package study0503;

import java.util.Scanner;

public class Method_quiz {

	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);
		
		
		roomSize(115);
		System.out.println("115평방미터는 "+roomSize2(115)+"평 입니다.");
		System.out.println("115평방미터는 "+roomSize3(115)+"평 입니다.");
	
		
		System.out.println("----문제2----");
		
		int a = 100;
		int b = 20;
		
		System.out.print("연산기호 *,+,-,/ 를 입력 >>");
		
		String c = scn.next();
		myCalc(a,b,c);
		System.out.println(c);
		System.out.println("----문제3----");
		
		int eng = 60;
		int kor = 58;
		test1(eng,kor);
		
		System.out.println("----문제4----");
		
		int[] score = {60,70,80,68,78};
		int avg = arraySum(score)/score.length;
		System.out.println("점수의 합 : "+arraySum(score)+ ",평균 : "+avg);
	}
	
	
	
	
	
	
	
	
	
	
	public static int roomSize3(int a) {
		double py = a*0.3025;
		return (int)py;
	}
	public static double roomSize2(int a) {
		double py = a * 0.3025;
		return py;
	}
	public static void roomSize(int a)  {
		//rint 는 30.0 실수,  round는 30 정수로 나옴.
		
		double py = a*0.3025;
		
		//System.out.println("입력하신 "+a+"평방미터는 "+Math.round(py)+" 평입니다.");
		System.out.println("입력하신 "+a+"평방미터는 "+Math.rint(py)+" 평입니다.");
	}
	public static void myCalc(int a,int b,String c) {
		int result = 0;
		if (c == "*") 	 {result = a*b;}
		else if (c=="+") {result = a+b;}
		else if (c=="/") {result = a/b;}
		else if (c=="-") {result = a-b;}
		System.out.println(a+c+b+"="+result);
	}
	public static void test1(int eng,int kor) {
		if (eng >= 60 && kor >= 60) 
			System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 합격");
		else if (eng < 60 && kor < 60)
			System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 불합격");
		else  System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 재시험");
	}
	public static int arraySum(int[] a) {
		int sum = 0;
		for (int i=0;i<a.length;i++) {
			sum += a[i];
		}
		return (int)sum;
	}

}
