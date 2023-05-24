package study0517;

public class Test101 {
	int a;
	int b;

	public static void main(String[] args) {
		//참조클래스 참조변수 = new 생성자;
		Test101 t1 = new Test101();
		Test101 t2 = new Test101();
		t1.a = 100;
		t2.a = 200;
		t2 = t1;
		System.out.println(t1.a);
		System.out.println(t2.a); // t2해도 t1으로 됨
	}

}
