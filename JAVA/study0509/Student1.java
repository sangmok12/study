package study0509;

public class Student1 {

	public static void main(String[] args) {
		
		
	 //참조클래스 참조변수 = new 생성자
		Person1 s1 = new Person1();   //인스턴스 처리
		s1.name = "홍길동";
		
		//s1.weight = 70;    private 입력불가.
		s1.setWeight(70);
		s1.setAge(30);
		s1.setHeight(170);
		System.out.println(s1.name);
		
		//System.out.println(s1.weight);     private 호출불가
		System.out.println(s1.getWeight());
		System.out.println(s1.getAge());
		System.out.println(s1.getHeight());

	}

}
