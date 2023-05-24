package study0508;

public class Quiz3 {
	int maxSpeed;
	String carName;
	String carColor;
	
	public Quiz3(String carName, int maxSpeed) {
		this.carName = carName;
		this.maxSpeed = maxSpeed;
	
	}
	public Quiz3(String carName, int maxSpeed,String carColor) {
		this.carName = carName;
		this.maxSpeed = maxSpeed;
		this.carColor = carColor;
	}
	
	public void maxSpeedUpdate(int a) {   
		maxSpeed = maxSpeed + a;
	}

	public static void main(String[] args) {
		Quiz3 car1 = new Quiz3("소나타",230);
		Quiz3 car2 = new Quiz3("그랜저",230,"white");
		System.out.println(car1.carName + ":" + car1.maxSpeed );
		System.out.println(car2.carName + ":" + car2.maxSpeed );
		car1.maxSpeedUpdate(-20);
		System.out.println(car1.carName + ":" + car1.maxSpeed );

		
	}

}
