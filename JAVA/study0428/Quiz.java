package study0428;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("영어점수 입력 >> ");
		int eng = scn.nextInt();
		
		
		System.out.println((eng>=80)?eng+"점은 80점 이상으로 우수":
									 eng+"점은 80점 미만으로 양호");
		
		/*switch( eng >= 80 ) {     //이클립스에서 switch 문은 true냐 false냐 형태로 사용안됨.
			case true : System.out.println("우수");
			break;
			case false : System.out.println("양호");
			break;
			default : System.out.println("답 없음");
		}*/
		System.out.println("-------------------");
		
		System.out.println("사과의 당도 입력 >> ");
		int apple = scn.nextInt();
		String result = (apple>=80) ? "A등급": 
						(apple>=60) ? "B등급":"C등급";
		System.out.println("당도 80이상(A등급), 60이상(B등급), 60미만(C등급)");
		System.out.println("사과의 당도는 " + apple + "으로" + result + "입니다.");
		
		System.out.println("-------------------");
		
		System.out.println("성별입력 (남성 1, 여성 2) >>");
		int gender = scn.nextInt();
		String gender1 = (gender==1)? "남자" : "여자";
		System.out.println("성별은 " + gender1 + "입니다.");
		
		System.out.println("-------------------");
		
		//양수 (또는 음수, 또는 0)입니다. 출력
		
		System.out.println("숫자 입력 >>");
		int number = scn.nextInt();
		
		System.out.print(number+"은(는) ");
		System.out.print((number>0)?"양수":(number<0)?"음수":"0");
		System.out.println("입니다.");
		
		System.out.println("-------------------");
		
		//변수 값을 이용한 학점 출력
		
		
		
		System.out.print("점수입력");
		int score = scn.nextInt();
		String level = (score>=90)?"A학점":
					   (score>=80)?"B학점":
					   (score>=70)?"C학점":
					   (score>=60)?"D학점":"F학점";
		System.out.println(score + "점은 " + level + "입니다.");
		scn.close();
	}

}
