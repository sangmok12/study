package study0508;

public class Quiz4 {
	public static void my_sum(int a,int b,int c) {
		System.out.println(a+b+c);
	}
	public static int jung(double a) {
		return (int) a;
	}
	public static String nons(String a) {
		String[] s = a.split(" "); 
		String result = "";
		for (int i=0; i<s.length;i++) {
			
			result = result + s[i];
		}
				return (String)result; 
	}
	public static void num(double a) {
		double s = Math.floor(a);
		double j = a -s ;
		System.out.println(j);
		
	}
	public static void jumin(String a) {
		String d = a.substring(7,8);
		String gender = "";
		String M = a.substring(2,4);
		String D = a.substring(4,6);
		if (d.equals("2") || d.equals("4")) {
			gender = "여성";
			System.out.println(gender);
		}
		else if (d.equals("1") || d.equals("3")) {
			gender = "남성";
			System.out.println(gender);
		}
		else {
			System.out.println(d);
		}
		
	}

	
	
	
	
	public static void main(String[] args) {
		
		//1. void 메소드 
		my_sum(10,20,30);
		
		double a = 25.55;
		System.out.println(jung(a));
		
		System.out.println(nons("우리 모두 의 백과  사 전"));
		
		num(45.245789);
		
		jumin("981225-2234567");

	}

}
