package study0504;


class BookInfo {
	int price = 10000;
	String title = "JAVA 기초";
}
public class Object_test1 {

	int a = 10;
	int b = 20;
	
	public static void main(String[] args) {
		
		
		// 참조클래스 참조변수 = new 생성자
		Object_test1 t1 = new Object_test1();
		System.out.println(t1.a + t1.b);
		
		BookInfo info = new BookInfo(); // 인스턴스(객체)화
		System.out.println(info.title + " : " +info.price);

	}

}
