package study0503;

public class Method_quiz3 {

	public static void main(String[] args) {
		int kor = 80;
		int eng = 50;
		test1(eng,kor);
		System.out.println
		("국어 : "+kor+", 영어 : "+eng+" 결과는 "+abc(kor,eng));

	}
	public static String abc(int a, int b) {
		String str = "";
		if(a>=60 && b>=60) 		str = "합격";
		else if (a < 60 && b < 60)	str = "불합격";
	    else		str = "재시험";
		return str;
		
	}
	public static void test1(int eng,int kor) {
		if (eng >= 60 && kor >= 60) 
			System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 합격");
		else if (eng < 60 && kor < 60)
			System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 불합격");
		else  System.out.println("영어 : "+eng+"점, 국어 : "+kor+"점으로 재시험");
	}

}
