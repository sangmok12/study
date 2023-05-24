package study0509;

import study0428.Person10;   //경로지정

public class Student10 extends Person10 {

	
	//캡슐화 : 접근지정자
	//접근지정자는 내부 접근일 경우 의미없음. 철저히 외부 접근제한
	//	public String name;    //같은 패키지(o),다른 패키지(o), 전체허용(o)
	//	protected int height;  //같은 패키지(o),다른 패키지(x), 상속허용(o)
	//	int age;		       //같은 패키지(o),다른 패키지(x), 상속허용(x)
	//	private int weight;    //같은 패키지(x),다른 패키지(x), 상속허용(x)
	
	//protected 는 다른패키지에서 사용못하지만,
	//다른패키지에 protected를 상속으로 가져오면 사용가능함.
	
	//public  ,  private이  중요함.
	
	public static void main(String[] args) {
		Student10 ss = new Student10();
		ss.height = 170;   //원래 사용 못하는데 상속으로 가져와서 가능.
		ss.name = "홍";
		//ss.age = 25;
		//ss.weight = 240;

	}

}
