package quiz0504;

class Score {
	int kor;
	int eng;
	int hap()  { return kor+eng ; }
	int avg()  { return (kor+eng)/2; }
}
public class VariableExam {

	
	public static void main(String[] args) {
		
		Score score = new Score();
		
		score.kor = 100;
		score.eng = 90;
		System.out.println("국어:"+score.kor+" 영어:"+score.eng+" 평균:"+score.avg());
		

	}

}
