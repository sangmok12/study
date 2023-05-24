package study0508;

public class Car1 {

	static int speed;     // 클래스변수
	static String carName;
	public static void speedUp() {   //클래스메소드
		speed++;
	}
	public static void speedDown() {
		speed--;
		if(speed<0) {stop();}
	}
	public static void stop() {
		speed = 0;
	}
	
	public static void main(String[] args) {
		carName = "SONATA";
		speed = 100;
		speedUp();
		speedUp();
		System.out.println("차이름 : " +carName);
		System.out.println("속도 : " +speed);
		stop();
		System.out.println("차이름 : " +carName);
		System.out.println("속도 : " +speed);
		
		//  static이고  객체화 하지 않았기에 소유하지못하고 변경이 됨.
		carName = "GRANDEUR";
		speed = 100;
		speedUp();
		speedUp();
		System.out.println("차이름 : " +carName  );
		System.out.println("속도 : " +speed  );
		stop();
		System.out.println("차이름 : " +carName  );
		System.out.println("속도 : " +speed  );
		

	}

}
