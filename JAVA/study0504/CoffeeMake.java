package study0504;


class CoffeeInfo{
	// 멤버변수  (메소드 외에 있는 변수)
	// ↓멤버변수, 인스턴스 변수
	String name = "";
	int price = 0;
	// ↓멤버변수, 클래스 변수
	static String maker = "";
	public void abc( String a ) {  //매개변수
		String aa = "aaaa";   //지역변수
	}
}
public class CoffeeMake {
	
	

	public static void main(String[] args) {
		CoffeeInfo coffee1 = new CoffeeInfo();
		coffee1.name = "아메리카노";
		coffee1.price = 3000;
		coffee1.maker = "가나";
		
		CoffeeInfo coffee2 = new CoffeeInfo();
		coffee2.name = "바닐라라테";
		coffee2.price = 4500;
		coffee2.maker = "홍콩";
		
		//maker 는 static 영역이라서 "" -> 가나 -> 홍콩순으로 덮어씌워짐
		System.out.println("커피1 이름 : " + coffee1.name);
		System.out.println("커피1 가격 : " + coffee1.price);
		System.out.println("커피1 원산지 : " + coffee1.maker);
		
		System.out.println("커피2 이름 : " + coffee2.name);
		System.out.println("커피2 가격 : " + coffee2.price);
		System.out.println("커피2 원산지 : " + coffee2.maker);

	}

}
