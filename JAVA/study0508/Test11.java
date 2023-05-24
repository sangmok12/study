package study0508;

public class Test11 {
	
	
	
	/* 
	 * 생성자, 다형성(오버로딩)
	 */
	public Test11(boolean a) {	}
	public Test11(int a)     {	}
	public Test11(String a)  {	}

	public static void main(String[] args) {

		
		Test11 t1 = new Test11(true);
		Test11 t2 = new Test11(1);
		Test11 t3 = new Test11("java");
	}              

}
