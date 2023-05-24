package study0511;

import study0508.Test1;

interface Test2 {     //추상화
	public int hap();     //메소드의 명세화
}
class Test3 implements Test2 {     //상속
	
	//멤버변수, 인스턴스(객체)변수
	private String name;       //캡슐화
	private int eng;
	private int kor;
	//멤버변수, 클래스변수(전역)변수
	static String title;
	
	public int hap() {     //다형성 (오버라이딩) : 상속과 같은
		return eng+kor;
	}
	public int hap(int a,int b) {   //다형성 (오버로딩) : 이름같고 매개변수 다름
		return a+b;
	}
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
public class OOP extends Test3{
	public static void main(String[] args) {
	//참조클래스 참조변수 = new 생성자
		OOP oop = new OOP();
		oop.setName("홍길동");
		oop.setEng(60);
		oop.setKor(100);
		
		System.out.println("이름 : " + oop.getName());
		System.out.println("합계 : " + oop.hap() + ", 평균 : "+oop.hap()/2);
		
		
	}

}
