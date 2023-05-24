package study0515;

public class Exception_t1 {

	public static void main(String[] args) {

		
		//정규표현식 (핸드폰번호체크)
		//010,011,015 - 숫자3,4 - 숫자 4
		String phone = "010-3443-3443";
		String pattern = "01(0|1|5)-[0-9]{3,4}-[0-9]{4}";
		if  (phone.matches(pattern)) {  //true of false
			System.out.println("맞음");
		} else {
			System.out.println("아님");
		}
		
		
		//예외처리 : 문법 오류 이외의 사항이 발생하여 프로그램 중단을 방지한다.
		//       ex) DB연결, I/O연결 시 필수적으로 예외처리를 함
		int a = 100;
		int b = 0;
		int[] c = {10,20,30};
		String d = "abc";
		
		System.out.println( c[1] );  //정상출력
		//ArithmeticException
		//ArrayIndexOutOfBoundsException
		//NumberFormatException
		//StringIndexOutOfBoundsException
		
		
		//오류가 있는것을 걸러내고 try catch 를 벗어남 
		try {
			System.out.println( c[0]);  // 정상출력 OK
			System.out.println(  Integer.parseInt(d)  ); //형변환 error
			System.out.println( c[1]);  // 위에서 에러 걸려서 출력XX
		
//			
//			System.out.println( a/b );  // zero error
//			System.out.println( c[7]);  // 자리번호 error
//			System.out.println( d.charAt(5) );  //자리번호 error
		}   
		
		
		
		
		catch (ArithmeticException e) {
			System.out.println("zero 오류가 발생했습니다.");
		}   catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열자리 오류가 발생했습니다.");
		}   catch (NumberFormatException e) {
			System.out.println("형변환 오류가 발생했습니다.");
		}   catch (StringIndexOutOfBoundsException e) {
			System.out.println("문자열 오류가 발생했습니다.");
		}   catch (Exception e) {
			System.out.println("오류가 발생했습니다.");
		}
		System.out.println( d.charAt(0) );  //정상출력
		
		
		
		
		
		
	}

}
