package study0515;

public class Exception_t3 {

	public static void main(String[] args) {
		String[] name = new String[2];
		try {
			name[0] = "딸기";
			System.out.println("이름 : " + name[0]);
			name[1] = "사과";
			System.out.println("이름 : " + name[0]);
			name[2] = "오렌지";
			System.out.println("이름 : " + name[0]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 참조 에러 발생");
		
		} finally {
			System.out.println("시스템 종료");
		}
	}

}
