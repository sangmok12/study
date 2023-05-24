package study0512;

public class Matches_test2 {

	public static void main(String[] args) {
		//ex1
		
		String birthday = "1980-02-22";
		String pattern = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
		if (birthday.matches(pattern)) {
			System.out.println("올바른 날짜");
		} else {
			System.out.println("올바른 날짜 아님");
		}
		
		//ex2
		String str = "공지사항 게시판 이미지";
		if (str.matches(".*게시판.*")) {
			System.out.println("문자열 있음!");
		} else {
			System.out.println("문자열 없음!");
		}
		
		//ex3
		String txt1 = "234652";
		if (txt1.matches(".*[0-9].*")) {
			System.out.println("숫자 있음!");
		} else {
			System.out.println("숫자 없음 !");
		}
		
		//ex4
		String phone = "010-3542-2345";
		pattern = "01(0|1|[6-9])-[0-9]{3,4}-[0-9]{4}";
		if(phone.matches(pattern)) {
			System.out.println("올바른 핸드폰 번호");
		} else {
			System.out.println("핸드폰번호를 다시 확인해주세요.");
		}
		
		//ex5
		String name = "홍기자둘";
		pattern = "[가-힣]+";
		boolean result = name.matches(pattern);
		System.out.println("이름 체크 : "+result);
		
		//ex6
		// 영문, 숫자, -,_ @영문,숫자 . 영문, 숫자
		//영문으로 시작다음(영,숫,_,-)1개이상 @ 영문,숫자 . 영문,숫자
		String email1 = "abc12@naver.com";
		String email2 = "#abc@korean.co.kr";
		String email3 = "abc@korea";
		pattern = "^[a-zA-Z]+[a-zA-Z0-9_-]*@[a-zA-Z0-9]+\\.[a-zA-Z]+";
		System.out.println(email1.matches(pattern));
		System.out.println(email2.matches(pattern));
		System.out.println(email3.matches(pattern));
		
		
		//회원 아이디체크 (영문,숫자,특수문자(_,-,$)를 포함한 6~12자)
		String userid = "test123";
		pattern = "^[a-zA-Z]{1}[a-zA-Z0-9_-]{5,11}";
		System.out.println("아이디 : "+userid.matches(pattern));
		System.out.println();
		
		//회원명 체크
		String name1 = "Tom";
		pattern = "[^a-zA-Z가-힣]{2,50}";
		System.out.println("이름 : " + name1.matches(pattern));
	
		//학점 체크
		
		String hakjum = "A+";
		pattern = "(A|B|C|E|F){1}(+|-)?";
		System.out.println("학점 : "+ hakjum);
		
		//공백여부 체크
		String content = " ".trim();
		pattern = " .+";
		System.out.println("content");
	}

}
