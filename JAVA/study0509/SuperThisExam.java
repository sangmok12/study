package study0509;


class Program1 {
	void pgName() {
		System.out.println("JAVA");
	}
}
class Program2 extends Program1 {
	void pgName() {
		System.out.println("JSP");
	}
	void programAll() {
		//상속 관계일때 부모클래스를 지명
		super.pgName();
		//this.pgName();
	}
}
public class SuperThisExam {
	public static void main(String[] args) {

		Program2 b = new Program2();
		b.pgName();        //JSP
		b.programAll();    //JAVA
	}

}
