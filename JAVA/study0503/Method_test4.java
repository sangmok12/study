package study0503;

public class Method_test4 {

	public static void main(String[] args) {
		int year = 1990;
		System.out.println("나이 : " + myAge1(year) );
	}
	
	//byte(127) < shotr(3만2천) < int(21억) < long
	public static byte myAge1(int a) { //매개변수 : 외부값을 받는 변수
		
		int t_Year = 2023;
		int age = t_Year - a;
		
		
		return (byte)age;  // byte 메소드이기에 byte 리턴 해줘야함.
	}

}
