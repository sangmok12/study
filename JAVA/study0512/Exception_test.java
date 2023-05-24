package study0512;

public class Exception_test {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		System.out.println( a/b );    //0

		
		int c = 10;
		int d = 0;
		
		try {
		System.out.println( c/d );    //0
	} catch (Exception e) {
		System.out.println("잘못된 연산");
	}
		System.out.println("!11111");
		
		System.out.println();
		
		
		int[] array1 = {11,22,33,44,55};
		
		try {
			System.out.println(array1[10]);
		} catch (Exception e) {
			System.out.println("배열오류");
		}
		System.out.println(array1[1]);
		
		
		try {
			System.out.println(array1[0]);
			System.out.println(array1[10]);    //오류 걸리고 빠져나옴
			System.out.println(array1[1]);     //  출력안함.
		} catch (Exception e) {
			System.out.println("배열오류");
		}
		System.out.println(array1[1]);
		
		
		
		
		
	}
}
