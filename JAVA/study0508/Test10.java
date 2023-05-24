package study0508;

public class Test10 {

	int a = 10;   //멤버변수, 인스턴스변수
	/*
	 * 생성자 : 이름의 첫글자는 반드시 대문자.
	 *        호출불가(일반 메소드처럼 사용 불가)
	 */
	public Test10() {   //생성자의 기본
		System.out.println("- Test10 클래스의 객체화 -");
	}
	//생성자의 다형성 > 오버로딩
	public Test10(String a) {   //생성자의 기본
		System.out.println("- Test10 클래스의 인스턴스화 -");
	}
	public static void main(String[] args) {

		Test10 t1 = new Test10();
		Test10 t2 = new Test10("abc");
		
	}

}
