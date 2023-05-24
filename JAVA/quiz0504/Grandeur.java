package quiz0504;

class Car1 {
	static int speed;
	static String carName;
	public static void speedUp() {
		speed++;
	}
	public static void speedDown() {
		speed--;
		if(speed<0) {
			stop();
		}
	}
	public static void stop() {
		speed = 0;
	}
}


public class Grandeur {

	public static void main(String[] args) {
		Car1 car1 = new Car1();
		Car1 car2 = new Car1();
		
		car1.carName = "SONATA";
		car1.speed = 100;
		Car1.speedUp();
		Car1.speedUp();
		
		System.out.println("차종 : "+car1.carName);
		System.out.println("속도 : "+car1.speed);
		
		Car1.stop();
		System.out.println("차종 : "+car1.carName);
		System.out.println("속도 : "+car1.speed);
		
		System.out.println("-------------");
		System.out.println("-------------");
		
		car2.carName = "Grandeur";
		car2.speed = 170;
		Car1.speedUp();
		Car1.speedUp();
		Car1.speedUp();
		Car1.speedUp();
		
		System.out.println("차종 : "+car2.carName);
		System.out.println("속도 : "+car2.speed);
		
		Car1.stop();
		System.out.println("차종 : "+car2.carName);
		System.out.println("속도 : "+car2.speed);
		

	}

}
