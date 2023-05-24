package study0501;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		//둘 다 60이상이면 합격, 둘중하나라도 미만이면 재시험
		//둘 다 60미만이면 불합격
		
		int kor = 45;
		int eng = 70;
		
		if (kor >= 60 && eng >= 60) {
			System.out.println("합격");
		}
		else if ( (kor >=60 && eng< 60 ) ||
				  (kor < 60 && eng>=60 ) ) {
			System.out.println("재시험");
		}
		else {
			System.out.println("불합격");
		}
		
		System.out.println("-----------------");
		
		/* math 점수 A,B,C,D,F 학점으로 분류
		 * F~A 순서로 세팅하기
		 */
		
		int math = 77;
		String hakjum = "";
		if (math < 60) { hakjum="F"; }
		else if (math < 70) { hakjum="D"; }
		else if (math < 80) { hakjum="C"; }
		else if (math < 90) { hakjum="B"; }
		else { hakjum = "A";}
		System.out.println(math + "점은 " + hakjum + "학점입니다.");
		
		System.out.println("-----------------");
		
		int n1 = 189;
		int page = ((n1-1)/10) + 1;   // int는 정수여서 가능.
		System.out.println("입력된 값은 " + n1 + "로 " +page+ "페이지입니다.");
		
		System.out.println("-----------------");
		
		System.out.print("숫자 입력 : ");
		int num = scn.nextInt();
		
		
		if (num%2 == 0 && num%10 == 0) {
			System.out.println(num + "은 짝수이고, 10의 배수입니다.");
		}
		else if (num%2==0 && num%10 != 0) {
			System.out.println(num + "은 짝수이고, 10의 배수는 아닙니다.");
		}
		else {
			System.out.println(num + "은 홀수입니다.");
		}
		
		
		
		
		

	}

}
