package study0518;

public class Test100 {

	public static void abc1() {
		int sum = 10+200;
		if(sum < 1000) {
			return;            //메소드 중지
		}
		int sum2 = 300+3;      // return이 if문 안에 있어서 리턴후에도 나올 수 있는것.
		
	}
	
	public static int abc2() {
		
		int sum = 10+100;
		return sum;           //메소드 중지 + 값을 던짐.
//		int sum2 = 1254+3;
	}
	
	public static void main(String[] args) {
	
		int eng = abc2();
		
		
		System.out.println(eng);
		return;
	}

}
