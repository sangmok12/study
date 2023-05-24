package study0515;

public class Exception_t2 {
	
	int hap; // int hap = 0; (O)
	public void myRun(int a) {
		System.out.println("연산 결과 : " + a);
	}
	public static void main(String[] args) {
		
		Exception_t2 t = new Exception_t2();
		
		int result;   // int result = 0; (X)
		for (int i=4;i>=0;i--) {
			try {
				result = 100 / i;
				t.myRun(result);
			} catch (ArithmeticException e) {
				t.myRun(-1);
			}
		}
	}

}
