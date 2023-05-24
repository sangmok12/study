package study0428;

public class Test7 {

	public static void main(String[] args) {
		
		int a = 1;
		a++;
		a++;
		++a;
		System.out.println( a );
		System.out.println("-----------------");
		int b = 1;
		++b;
		
		int c = ++b;    // int c = 3  ++b; 마지막도 3이 된거임.
		System.out.println( "b = " + b);
		System.out.println( "c = " + c);
		
		//int c = b++;   // b++; 은 b를 먼저 c에게 넘기고 증가함.
		System.out.println( "b = " + b);
		System.out.println( "c = " + c);

		System.out.println("-----------------");
		System.out.println("-----------------");
		
		int num = 1;
		
		// 1증가
		num++;
		++num;
		num = num+1;
		num += 1;
		// 2증가
		num = num+2;
		num += 2;
		// 2곱셈
		num = num*2;
		num *= 2;
		// 2나누기
		num = num/2;
		num /= 2;
		
		System.out.println("-----------------");
		
		System.out.println( (100>100)? "참" : "거짓");
		System.out.println("-----------------");
		
		String result = (10%2==0) ? "참" : "거짓";
		System.out.println(result);
		System.out.println("-----------------");
		
		int apple = 88;
		
		
		//int result2 = (apple>80) ? 1 : 0 ; 숫자로 나오려면 int
		String result2 = (apple>80) ? "A등급" : "B등급";
		System.out.println("사과의 당도는 " + apple + "으로 " + result2 + "입니다.");
	}

}
