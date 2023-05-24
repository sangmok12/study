package quiz0509;


class StudentVO {
	private String name;
	private int year;
	private int eng;
	private int kor;
	
	//마우스 오른쪽 -> source -> Generate getters and setters -> 선택후 Generate
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
public class StudentInfo extends StudentVO{
	
	public int sum() {
		return getKor() + getEng();
	}
	public int avg() {
		return sum()/2;
	}

	public static void main(String[] args) {
		StudentInfo s = new StudentInfo();
		s.setName("김철수");
		s.setYear(1);
		s.setEng(90);
		s.setKor(80);
		
		System.out.println("이름 : "+s.getName());
		System.out.println("학년 : "+s.getYear());
		System.out.println("총합 : "+s.sum());
		System.out.println("이름 : "+s.avg());

	}

}
