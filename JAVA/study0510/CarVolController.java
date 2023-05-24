package study0510;

public class CarVolController {
	public static void main(String[] args) {
		
		
		CarVolMake carAudio = new CarVolMake();
				
		
		System.out.println(carAudio.getVolLevel());
		carAudio.volUp(30);
		carAudio.volDown(5);
		System.out.println(carAudio.getVolLevel());
		carAudio.volPause();
		System.out.println(carAudio.getVolLevel());
		carAudio.volResume();
		System.out.println(carAudio.getVolLevel());
		carAudio.volOff();
		System.out.println(carAudio.getVolLevel());

	}

}
