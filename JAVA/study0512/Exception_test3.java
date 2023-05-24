package study0512;

public class Exception_test3 {

	public static void main(String[] args) {
		
		//  1. zero error   -  나누기
		//  2. index number  error   -   배열
		//  3. 형변환 error 
		
		
		
		String a1 = "abc";
		String a2 = "123";
		int a3 = 0;
		int a4 = 0;
		try {
			System.out.println(a1.charAt(3));
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("문자열 자리번호 오류");
		}
		try {
			a3 = Integer.parseInt(a1);			  
			a4 = Integer.parseInt(a2);
		} catch(NumberFormatException e) {
			System.out.println("형변환 오류 ");
		} catch(Exception e) {
			System.out.println("오류 ! ");
		}
		
		System.out.println(a3);   //위에서 오류나서 변경사항이 안내려옴 .
		System.out.println(a4);   //위에서 오류나서 변경사항이 안내려옴 .
		
		
	}

}
