package study0429;

//ctrl + Shift + O
import java.util.Scanner;

public class Coffee2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) { //무한루프
		
			System.out.println("= 드시려는 커피번호를 입력해주세요. =");
			System.out.println("1.아메리카노");
			System.out.println("2.다방커피");
			System.out.print("* 커피번호 >> ");
			
			int n1 = scn.nextInt();
			if( n1 == 1) {
				while(true) {
				System.out.println("= 아메리카노를 선택했습니다. =");
				System.out.println("1. 설탕넣기");
				System.out.println("2. 설탕 없음");
				System.out.print("* 설탕번호 >> ");
				int n2 = scn.nextInt();
				if (n2 == 1)	
					{System.out.println("설탕 넣은 아메리카노가 나왔습니다.");
					break;}
				else if (n2 == 2) 
					{System.out.println("설탕없는 아메리카노가 나왔습니다.");
					break;}
				else System.out.println("번호를 잘못 선택하셨습니다.");
				}
				break;
			} else if (n1 == 2) {
				while(true) {
				System.out.println("= 다방커피를 선택했습니다. =");
				System.out.println("1. 프림1 + 설탕1 (연한맛)");
				System.out.println("2. 프림2 + 설탕2 (단맛)");
				System.out.println("3. 프림3 + 설탕3 (아주단맛)");
				System.out.print("* 선택번호 >> ");
				int n3 = scn.nextInt();
				if (n3 == 1)	
					{System.out.println("연한맛의 다방커피가 나왔습니다.");
					break;}
				else if (n3 == 2) 
					{System.out.println("단맛의 다방커피가 나왔습니다.");
					break;}
				else if (n3 == 3) 
					{System.out.println("아주단맛의 다방커피가 나왔습니다.");
					break;}
				else System.out.println("번호를 잘못 선택하셨습니다.");
				}
				break;
			} else {
				System.out.println("없는 번호입니다.");
			}
		}
		
	}

}