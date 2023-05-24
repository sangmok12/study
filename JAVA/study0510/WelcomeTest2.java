package study0510;


// abstract 추상화클래스를 구체화하는  구체화클래스
public class WelcomeTest2 extends WelcomeTest1 {
	
	public void welcome1() {   //다형성 > 오버라이딩
		System.out.println("환영합니다.");
	}
	public String welcome2() {
		return "어서오세요.";
	}

	public static void main(String[] args) {
		
		WelcomeTest2 t2 = new WelcomeTest2();
		t2.welcome1();
		System.out.println(t2.welcome2());

	}

}
