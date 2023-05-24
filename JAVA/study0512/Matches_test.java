package study0512;

public class Matches_test {

	public static void main(String[] args) {
		
		//ex1
		
		String title = "a";
		String pattern = ".+";
		System.out.println(title.matches(pattern));  //true
		System.out.println();
		
		//ex2
		String color1 = "red";
		String color2 = "ared";
		String color3 = "redabc";
		String color4 = "readabc";
		pattern = "^red.*";
		System.out.println(color1.matches(pattern));  //true
		System.out.println(color2.matches(pattern));  //false
		System.out.println(color3.matches(pattern));  //true
		System.out.println(color4.matches(pattern));  //false
		System.out.println();
		
		//ex3
		String color5 = "yellow";
		String color6 = "green";
		pattern = "^(r|y|b).*";   // r,y,b 로 시작해야함
		System.out.println(color5.matches(pattern));  //true
		System.out.println(color6.matches(pattern));  //false
		System.out.println();
		
		//ex4
		String gender = "M";
		pattern = "^(M|F)";
		System.out.println(gender.matches(pattern));  //true
		System.out.println();
		
		//ex5(숫자만)   공백도 안됨. 
		String date = "51854813";   
		//숫자로 시작하고 , 숫자 1개이상, 숫자로 끝나야함.
		pattern = "^[0-9]+$";
		System.out.println(date.matches(pattern));   //true
		System.out.println();
		
		//ex6 (영문만)
		String str = "youngmoonman";
		pattern = "^[a-zA-Z]+$";
		System.out.println(str.matches(pattern));
		
		
		
		
		
	}

}
