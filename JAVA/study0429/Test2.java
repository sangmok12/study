package study0429;

public class Test2 {

	public static void main(String[] args) {
		//논리타입
		boolean a1 = true;       //o
		boolean a2 = false;      //o
		//boolean a3 = "true";   //x
		//boolean a4 = 3542;     //x
		boolean a5 = 10<20;      //o
		System.out.println(a5);
		//String s1 = 10 < 20;   //x
		
		
		final String color = "blue";
		//color = "red";       //x
		System.out.println(color);

	}

}
