package study0429;

import java.util.Scanner;

public class If {

	public static void main(String[] args) {
		
		// 콘솔창에 입력상태를 제공
		Scanner scn = new Scanner(System.in);
		System.out.print("연차 입력 : ");
		int emp_A_year = scn.nextInt();    //nextInt() 메소드
		
		if (emp_A_year >=15 ) {
			String grade = "특급";
			System.out.println("A 사원의 년차는 " + emp_A_year +"년으로 " + grade + "입니다.");
		} else if (emp_A_year >= 10 && emp_A_year < 15) {
			String grade = "고급";
			System.out.println("A 사원의 년차는 " + emp_A_year +"년으로 " + grade + "입니다.");
		} else if (emp_A_year >=6 && emp_A_year < 10){
			String grade = "중급";
			System.out.println("A 사원의 년차는 " + emp_A_year +"년으로 " + grade + "입니다.");
		} else {
			String grade = "초급";
			System.out.println("A 사원의 년차는 " + emp_A_year +"년으로 " + grade + "입니다.");
		} 

			System.out.println("-------------------------");
			
			
			
			String gender = "F";
			
			if (gender == "F") {
				System.out.println("A씨의 성별 코드는 " + gender + "로 여성입니다.");
			} else if (gender == "M") {
				System.out.println("A씨의 성별 코드는 " + gender + "로 남성입니다.");
			} else {
				System.out.println("잘못된 코드");
			}
			
			
			
			
			
			
	}

}
