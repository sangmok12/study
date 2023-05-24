package study0429;

public class Test {

	public static void main(String[] args) {
		// byte short int long
		byte a = 127;      //  -128 ~ 127
		short b = 32767;   // -32768 ~ 32767
		int c = 2100000000;
		long d = 708000011548L;
		
		float f1 = 3.14f;
		float f2 = 2.423523452435f;  //7자리 까지만함.
		double db1 = 3.12413523451;
		System.out.println("float f1 :" + f1);
		System.out.println("float f2 :" + f2);
		System.out.println("double db1 :" + db1);

		
		
		
		// char타입은 유니코드(문자들을 숫자형식으로) 인식함.
		char c1 = 'a';            //o
		c1++;
		c1++;
		System.out.println("char c1 : " + c1);
		//char c2 = 'ab';         //x
		//char c3 = "a";            //x
		char c4 = '가';            //o
		c4++;	
		System.out.println("char c4 : " + c4);
		char c5 = 'I';
		c5++;
		System.out.println("char c5 : " + c5);
		String s1 = "a";
		//s1++;   X
		System.out.println("String s1 : " + s1);
		
		char c2 = 'a';    //97
		char c3 = 98;     //b
		System.out.println("유니코드 값 98은 " + c3);
		
	}

}
