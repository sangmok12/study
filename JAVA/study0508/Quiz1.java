package study0508;

public class Quiz1 {
	int price = 10000;
	String bookName;
	
	public Quiz1() {
		
	}
	 public Quiz1(String a) {
		 bookName = a;
	 }
	 public Quiz1(String a, int b) {
		 bookName = a;
		 price = b;
	 }

	public static void main(String[] args) {
		Quiz1 java = new Quiz1("자바의 첫걸음");
		Quiz1 linux = new Quiz1("리눅스 마스터",35000 );
		System.out.println("My Book : "+ java.bookName + ", 가격 : "+java.price);
		System.out.println("Your Book : "+ linux.bookName + ", 가격 : "+linux.price);
		
	}

}
