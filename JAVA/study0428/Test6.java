package study0428;

public class Test6 {

	public static void main(String[] args) {
		int number = 1;
		System.out.println(number);
		number = number+1;
		System.out.println(number);
		number = number+1;
		System.out.println(number);
		number = number+1;
		System.out.println(number);
		System.out.println("----------------");
		
		/* 1. 내 돈 1000원 있음.
		 * 2. 용돈 100원 받음
		 * 3. 용돈 50원 받음
		 * 4. 학용품 30원 삼
		 * 5. 친구 돈 500원 있음
		 * 6. 친구 돈을 가져옴.
		 */
		
		int myMoney = 1000;
		
		myMoney = myMoney + 100;
		System.out.println("내 돈 현황 :" + myMoney);
		
		myMoney = myMoney + 50;
		System.out.println("내 돈 현황 :" + myMoney);
		
		myMoney = myMoney - 30;
		System.out.println("내 돈 현황 :" + myMoney);
		
		int yourMoney = 500;
		myMoney = myMoney + yourMoney;
		
		System.out.println("내 돈 현황 :" + myMoney);
		System.out.println("----------------");
		
		/* 상인 Tom의 원금은 100만원이다.
		 * 첫째 날은 20만원 수입
		 * 둘째 날은 30만원 수입
		 * 셋째 날은 10만원 적자.
		 */
		
		int TomsMoney = 100;
		int day1 = 20;
		TomsMoney = TomsMoney + day1;
		int day2 = 30;
		TomsMoney = TomsMoney + day2;
		int day3 = -10;
		TomsMoney = TomsMoney + day3;
		int sum = day1 + day2 + day3;
		int avg = sum/3;
		System.out.println("Tom의 총 금액은 " + TomsMoney + "만원입니다.");
		System.out.println("평균수입은 " + avg + "만원입니다.");
	}

}
