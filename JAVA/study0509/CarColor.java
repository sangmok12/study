package study0509;


class CarInfo {
	String carName;
	int velocity;
	String carColor;
}
public class CarColor extends CarInfo {
	public CarColor(String color, String name,int speed) {
		carName = name;
		velocity = speed;
		carColor = color;
	}

	public static void main(String[] args) {
		CarColor cc = new CarColor("White","Sonata",100);
		System.out.println("차이름 : "+cc.carName + 
						   "\n속도 : "+cc.velocity+
						   "\n차색상 : "+cc.carColor);
		

	}

}
