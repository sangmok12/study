package study0508;

import java.util.Calendar;

public class Quiz4_T {
	
	public static void my_sum(int a, int b, int c) {
		System.out.println("합계 : " + (a+b+c));
	}
	public static int my_sum2(int a,int b,int c) {
		return (a+b+c);
	}
	public static String remove_space(String str) {
		String result = str.replace(" ","");
		return result;
	}
	public static void split_number(double a) {
		// a = 97.123
		String b = a + "";  //숫자 -> 문자 형변환
		String[] ar1 = b.split("\\."); // . 스플릿 할땐 \\해야함
		System.out.println("정수 : "+ar1[0]+" 실수 : 0."+ar1[1]);
	}
	public static void split_jumin(String str) {
		// str = "981225-1234567";
		String a1 = str.substring(0,2);  // 98
		String a2 = str.substring(2,4);  // 12
		String a3 = str.substring(4,6);  // 25
		String a4 = str.substring(7,8);  // 성별
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int age = year - Integer.parseInt("19"+a1);   //문자 -> 숫자  형변환
		
		
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+(  (a4.equals("1") || a4.equals("3"))?"남성":
									   (a4.equals("2") || a4.equals("4"))?"여성":"오류"));
		System.out.println("생일 : "+a2+"월"+a3+"일");   //문자일때 .equals 하는게 좋음 
	}

	
	
	
	public static void main(String[] args) {

		my_sum(10,20,30);
		
		System.out.println("합계 2 : "+my_sum2(10,20,30));
		
		String str1 = "   우  리 모두의 백 과사전 ";
		String str2 = remove_space(str1);
		System.out.println("공백제거 : "+ str2);
		
		split_number(97.153);
		
		
		split_jumin("981225-1234567");
		
		
	}

}
