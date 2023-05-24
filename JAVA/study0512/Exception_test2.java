package study0512;

public class Exception_test2 {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2 = 0;
		int[] n3 = {11,22};
		try {
			System.out.println(n3[5]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 번호 오류");
		}
		
		
		
		
		String[] pgName = {"java","php","asp"};
		int i = 0;
		while (i < 5) {
			try {
				if(i==4) System.out.println( i/0 );
				else System.out.println( pgName[i] );
			} catch (ArrayIndexOutOfBoundsException a) {
				System.out.println("array exception");
			} catch (Exception e) {
				System.out.println("zero error");
			} finally {
				System.out.println("finally");
			}
			i++;
		}
	}

}
