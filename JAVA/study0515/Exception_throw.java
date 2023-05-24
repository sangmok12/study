package study0515;

public class Exception_throw {

	public static void methodTest1() {
		try {
			//일부러 Exception 발생시키는 키워드
			throw new Exception("gjf~");
			// detailMessage = "gjf~"
//			System.out.println(Integer.parseInt("aa"));
		} catch (Exception e) {
			//return detailMessage;
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		methodTest1();
	}

}
