package study0504;


class MySubject1 {
	// 클래스변수 (전역변수)
	
	//static 은 공유라서  독립적으로 st1 st2이 사용하도록 생성못함
	static String title;
	int price = 0;    //각자 고유의 메모리 공간을 차지
	//인스턴스(객체)변수
}
public class Myshool1 {

	
	public static void main(String[] args) {
		MySubject1 st1 = new MySubject1();
		MySubject1 st2 = new MySubject1();
		
		st1.title = "java";
		st2.title = "oracle";
		st1.price = 100;
		st2.price = 200;
		System.out.println("st1 : " + st1.title);
		System.out.println("st2 : " + st2.title);
		st1 = st2;
		System.out.println("st1 : "+ st1.price);
		System.out.println("st2 : "+ st2.price);

	}

}
