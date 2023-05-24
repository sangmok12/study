package study0429;

public class Graduation {

	public static void main(String[] args) {
		

		int[][] engs = {{30,80,90},{60,70,90}};
		System.out.println( engs[0][0] );  //30
		System.out.println( engs[0][1] );  //80
		System.out.println( engs[0][2] );  //90
		
		System.out.println( engs[1][0] );  //60
		System.out.println( engs[1][1] );  //70
		System.out.println( engs[1][2] );  //90
		
		System.out.println("-------------------");
		
		// 1차원 배열
		int[] jumsu = {90,70,60};
		
		// 2차원 배열
		int[][] kors = {{30,80,90},{60,70,90},{50,20,70,50}};
		
		
		
		/* 3차원 배열
		 * 예) 전교  ->  1학년 2개반,    2학년 3개반
		 *      {    { {},{} }   ,   { {},{},{}}      }
		 */ 
		int[][][] school = { { {75,65,90},{30,20,70} },
							 { {70,90,50},{80,90,70},{20,90,30} } };
		//2학년 2반 1번 학생점수.
		System.out.println(school[1][1][0]);  // 80
		//1학년 1반 3번
		System.out.println(school[0][0][2]);  // 90
		//2학년 3반 2번
		System.out.println(school[1][2][1]);  // 90
	
	
	
	}	

}
