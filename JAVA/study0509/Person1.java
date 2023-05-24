package study0509;

// 접근지정자 : public > protected > (생략) > private
public class Person1 {
	
	
	//멤버변수,   인스턴스(객체) 변수
	private int age;                    // int age = 0;
	public String name;         // String name = null;
	private int height;	
	private int weight;
	
	//멤버변수, 클래스변수
	static int score;
	
	
	
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {  //매개변수
		// weight = -70
		if (weight<0 || weight >300) {
			weight =0;
		}
		this.weight=weight;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) { 
		this.age=age;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) { 
		this.height=height;
	}

}
