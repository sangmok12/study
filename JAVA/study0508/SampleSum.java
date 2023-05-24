package study0508;

public class SampleSum {

	
	/* 다형성 > 오버로딩 : 같은 이름의 메소드를 매개변수를 달리하여 생성하는 기법
	 * 매개변수의 타입과 개수가 같은 메소드는 생성할 수 없다.
	 */
	public void sum() {
		System.out.println(10+10);
	}
	public void sum(int a) {
		System.out.println(a+10);
	}
	// 변수명 같아도 됨. 변수타입이 다르면 됨.
	public void sum(String a) {
		System.out.println(a+10);
	}
	/*public void sum(int b) {
		System.out.println(b+10);
	}  타입이 같아서 안됨. */
	public void sum(int a,int b) {
		System.out.println(a + b);
	}
	public void sum(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	public void sum(int a, int b, double c) {
		System.out.println(a+b+c);
	}
	public void sum(String str, int a, int b) {
		System.out.println(str);
		System.out.println(a+b);
	}
	public static void main(String[] args) {
		
		SampleSum s = new SampleSum();
		s.sum();
		s.sum(44);
		s.sum("55");
		s.sum(10,20);
		s.sum(35,25,44);
		s.sum(10,20,30.2424);
		s.sum(456);
		s.sum("잼",25,33);

	}

}
