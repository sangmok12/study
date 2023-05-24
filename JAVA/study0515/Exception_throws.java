package study0515;

public class Exception_throws {

	
	//메소드 이름 뒤의 throws Exception은 호출한 곳에 강제 의무를 건냄
	
	static void methodTest1() throws Exception {
		System.out.println(100/0);
	}
	public static void main(String[] args) {

			
		
		// methodTest1(); 만 있을때 빨간줄클릭하면 try catch 만들어줌.
				try {
					methodTest1();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		
	}

}
