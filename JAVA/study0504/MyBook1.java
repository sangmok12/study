package study0504;

public class MyBook1 {

	public static void main(String[] args) {
		
		StudentInfo st = new StudentInfo();  // 인스턴스 작업
		
		st.eng = 90;
		st.kor = 80;
		st.name = "홍길동";
		System.out.println(st.eng +""+ st.kor +""+ st.name);

	}

}
