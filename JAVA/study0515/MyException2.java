package study0515;

public class MyException2 {

	static void abc() throws MyException{
		System.out.println("haha");
	}
	public static void main(String[] args) {
		try {
			abc();   //haha 출력
			throw new MyException();
		} catch (MyException e ) {
			System.out.println(e.toTest());
		}
	}

}
