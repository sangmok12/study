package study0503;

public class Math_test {

	public static void main(String[] args) {
		
		//ceil()   : 올림메소드(소수점 아래)      실수타입
		System.out.println(Math.ceil(98.2));  //99.0
		System.out.println(Math.ceil(98.7));  //99.0
		System.out.println("---------------------");
		
		//floor()  : 내림메소드(소수점 아래)      실수타입
		System.out.println(Math.floor(98.2)); //98.0
		System.out.println(Math.floor(98.7)); //98.0
		System.out.println("---------------------");
		
		//round()  : 소수점 아래 반올림  (5아래내림, 5부터올림)       정수타입
		System.out.println(Math.round(98.2)); //98
		System.out.println(Math.round(98.4)); //98
		System.out.println(Math.round(98.5)); //99
		System.out.println(Math.round(98.9)); //99
		System.out.println("---------------------");
		
		//rint()   : 소수점 아래 반올림   (5까지내림, 5초과 올림)    실수타입
		System.out.println(Math.rint(98.2)); //98.0
		System.out.println(Math.rint(98.5)); //98.0
		System.out.println(Math.rint(98.50001)); //99.0
		System.out.println(Math.rint(98.6)); //99.0
		System.out.println("---------------------");
		
		//abs()    : 절대값
		System.out.println(Math.abs(-98.2)); //98.0
		System.out.println(Math.abs(-98.4)); //98.0
		System.out.println(Math.abs(-98.50001)); //98.0
		System.out.println("---------------------");
		
		//pow()    :  제곱(승)수  (밑,지수)        실수타입
		System.out.println(Math.pow(10,2));   //100.0 
		System.out.println(Math.pow(10,3));   //1000.0
		System.out.println(Math.pow(4,0));    //1.0
		System.out.println(Math.pow(4,-1));   //0.25
		System.out.println("---------------------");
		
		//sqrt()   : 제곱근 변환  (루트)
		System.out.println(Math.sqrt(100));    //10
		System.out.println(Math.sqrt(25));     //5
		System.out.println("---------------------");
		
		//max() / min()   최대값, 최소값 반환   
		//System.out.println(Math.min(10,20,50,40));   두개만 놓을 수 있음 쓸데없음.
		System.out.println(Math.max(10,
						   Math.max(30,
						   Math.max(55,40))));   //이런식으로 가능.
		System.out.println(Math.max(10.2,20.3));  
		System.out.println(Math.max(10,Math.abs(-20)));
		System.out.println(Math.min(10,-20));
		System.out.println("---------------------");
		
		
		//Math.random()  :  난수발생 0(초과) ~ 1(미만) 값 0.000000000001~0.099999999999
		System.out.println(Math.random());
		System.out.println((int)(Math.random()*100));
		
		//int n1 = Math.random()*100;    // 정수타입 변수 = 실수타입 값  (X)
		int n1 = (int)(Math.random()*100);        // 0~99 나옴
		int n2 = (int)(Math.random()*100) +1;     //1~100
		int n3 = (int)(Math.random()*45) +1;      //1~45
		System.out.println(n3);
		
		
		
		
		

	}

}
