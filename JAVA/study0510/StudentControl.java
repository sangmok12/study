package study0510;

abstract class StudentService {
	abstract public int sum();
}

class StudentImpl extends StudentService {
	
	public int sum() {
		return getKor() + getEng() ;
	}
	
	private String name;
	private int eng;
	private int kor;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
}
public class StudentControl {
	public static void main(String[] args) {
		int avg = 0;
		StudentImpl s1 = new StudentImpl();
		
		s1.setName("김환");
		s1.setEng(90);
		s1.setKor(100);
		
		avg = s1.sum()/2;
		
		System.out.println("이름 : " + s1.getName());
		System.out.println("국어 : " + s1.getKor());
		System.out.println("영어 : " + s1.getEng());
		System.out.println("총점 : " + s1.sum());
		System.out.println("평균 : " + avg);
		
		

	}

}
