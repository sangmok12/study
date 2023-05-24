package bogang;

import java.util.Scanner;

public class TTest1 {

	public static void main(String[] args) {
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간 " + minute + "분");

		int totalMinute = (hour*60) + minute;

		System.out.println(totalMinute);


		//55page
		int v1 = 15;
		int v2 = 0;
		if (v1>10) {
			v2 = v1 - 10;
		}
		int v3 = v1 + v2 +5;
		// if 문 안에  int 는 외부에서 인식 못함.
		System.out.println(v3);
		
		
		//58page
		int sum;
		int score1 = 0;
		int score2;           //  score2 = null; (무존재,재정의 가능)
		//System.out.println(score2);
		//sum = score1+score2;  null값이라 연산에 참여 X
		
		
		//66page
		System.out.println("번호\t이름\t직업");        // \t = tap
		System.out.print("행 단위 출력\n\n");         // \n = 개행
		System.out.print("행 단위 출력\n");     
		//  \ 네스케이프 문자
		System.out.println("우리는 \"개발자\" 입니다.");    //  \는 뒤의 의미있는 기호, 뜻을 의미를 없앰.
		System.out.println("봄\\여름\\가을\\겨울");
		
		
		//98page
		String name = "감자바";
		int age = 25;
		String tel1 ="010", tel2="123", tel3="4567";  //타입이 같으면 ,로 여럿 선언 가능
		
		
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("전화번호 : " + tel1 + "-" + tel2 + "-" + tel3);
		
		System.out.print("이름 : " + name +"\n나이 : "+age+"\n전화번호 : "+tel1 + "-" + tel2 + "-" + tel3);
		
		System.out.println();
		System.out.println();
		
		//99page
//		Scanner scn = new Scanner(System.in);
//		System.out.print("이름 : ");
//		String name1 = scn.next();
//		
//		System.out.print("나이 : ");
//		int age1 = scn.nextInt();
//		System.out.println("이름 : " +name1);
//		System.out.println("나이 : " +age1);
		
		//121page
		int s2 = 1;
		double s3 = 1.0;
		System.out.println(s2==s3);
		if (s2 == (int)s3) {              //true,    혹시 불안하니 int로 형변형 하는게좋음.
			//
		}
		double s4 = 0.1;
		float s5 = 0.1f;
		System.out.println(s4==s5);               // false  
		System.out.println((float)s4 == s5);      // true
		
		System.out.println("\n");
		
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = new String("홍길동");
		

		
		System.out.println(str1 == str2);        //true      
		System.out.println(str1.equals(str2));   //true
		//   == 는  위치가 같은가  아예 같은 놈인가.
		//equals : 실 데이터값의 비교 
		System.out.println(str2 == str3);        //false    놓인 위치가 달라서 다르다고 봄.
		System.out.println(str2.equals(str3));   //true
		
		//126page
		int score = 85;
		//char grade = 'A'; // A or B or C
		char grade  = (score>90) ? 'A':'B';
		char grade2 = (score>90) ? 'A' :(score>80)?'B':'C' ;
		System.out.println(score + " : " + grade2);
		
	
		
		
		
		
	}
}
