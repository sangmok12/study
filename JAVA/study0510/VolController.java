package study0510;

public class VolController {

	public static void main(String[] args) {
		
		//volMake 클래스를 객체화 하면서 volMake생성자를 통해 vol이 1이 됨.
		VolMake tv = new VolMake();      
		VolMake radio = new VolMake();  
		
		System.out.println("TV볼륨 : " +tv.getVolLevel());	
		System.out.println("Radio볼륨 : " +radio.getVolLevel());
		
		tv.volUp(10);
		radio.volUp(30);
		tv.volDown(5);
		radio.volDown(20);
		
		System.out.println("TV볼륨 : " +tv.getVolLevel());	
		System.out.println("Radio볼륨 : " +radio.getVolLevel());

	}

}
