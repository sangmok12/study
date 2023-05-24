package study0508;

public class Car2 {

	int speed;     
	String carName;
	public void speedUp() {   
		speed++;
	}
	public void speedDown() {
		speed--;
		if(speed<0) {stop();}
	}
	public void stop() {
		speed = 0;
	}
	
	public static void main(String[] args) {
		Car2 sonata = new Car2();
		Car2 grandeur = new Car2();
		
		sonata.carName = "SONATA";
		sonata.speed = 100;
		sonata.speedUp();
		sonata.speedUp();
		System.out.println("차이름 : "+sonata.carName);
		System.out.println("속도 : "+sonata.speed);
		sonata.stop();
		System.out.println("차이름 : "+sonata.carName);
		System.out.println("속도 : "+sonata.speed);

		
		grandeur.carName = "GRANDEUR";
		grandeur.speed = 200;
		grandeur.speedUp();
		grandeur.speedUp();
		System.out.println("차이름 : "+grandeur.carName);
		System.out.println("속도 : "+grandeur.speed);
		grandeur.stop();
		System.out.println("차이름 : "+grandeur.carName);
		System.out.println("속도 : "+grandeur.speed);
		
		

	}

}
