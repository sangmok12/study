package study0429;

public class Array2 {

	public static void main(String[] args) {
		
		//배열 구조형성  (세팅개수)
		int[] jumsu = new int[2];   //2 개 0~1,  적게세팅 가능 오버세팅 안됨.
		jumsu[0] = 88;
		jumsu[1] = 80;   
		//jumsu[2] = 60;     // 값 세팅 안한곳은 기본 0 세팅임.
		
		
		System.out.println( jumsu.length);
		System.out.println( "0번 " + jumsu[0]);
		System.out.println( "1번 " + jumsu[1]);
		
		
		//2차원 배열  
		int[][] jumsu11 = { {85,95,90} , {65,70,85} };
		int[][] jumsu22 = new int[2][3];
		
		jumsu22[0][0] = 85;
		jumsu22[0][1] = 95;
		jumsu22[0][2] = 90;
		
		jumsu22[1][0] = 65;
		jumsu22[1][1] = 70;
		jumsu22[1][2] = 85;

		System.out.println(jumsu11.length); // 큰그룹에서 봤을때 배열갯수2
		System.out.println(jumsu11[0].length); //0배열 안에서 배열갯수3
		System.out.println(jumsu11[1].length); //1배열 안에서 배열갯수3
		
		
		
		
		
	}

}
