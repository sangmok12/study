package study0509;


//접근지정자 = public,private  등  클래스에는 적용 못함, 
//public class 에 public은 별 의미없음

class AppleInfo {
	// 멤버변수, 인스턴스변수
	String name = "사과";
	int price = 3000;
	void discount() {
		price = price - (price/10);
	}
}


class CherryInfo {
	// 멤버변수, 클래스변수
	static String name = "체리";
	static int price = 5000;
	static void discount() {
		price = price - (price/10);
	}
}
public class MyFruit extends AppleInfo {
	public static void main(String[] args) {
//		System.out.println(name + " : "+price);
//		discount();
//		System.out.println(name + " : "+price);
		
		MyFruit info = new MyFruit();
		System.out.println(info.price);
		info.discount();
		System.out.println(info.price);

	}

}
