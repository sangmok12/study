package study0509;




/*  오버라이딩(다형성).
 * 상위클래스를 상속받을때 같은이름의 메소드 있어도 상관없음.
 * 하지만 상속받게 되면 상위클래스 메소드를 덮어버림.
 * 상위클래스를 객체화해서 사용하면 사용할 수 있음.
 */
class JavaView {
	public void viewName() {
		System.out.println("자바 프로젝트");
	}
	String viewSeoul() {
		return "강남";
	}
}

class OracleView extends JavaView {
	public void viewName() {   //상위 클래스의 메소드를 덮어씀
		System.out.println("오라클 프로젝트");;
	}
	//오버로딩(다형성) : 같은 이름의 메소드를 매개변수를 달리하여 작성하는 기법
	public void viewName(String a) {
		System.out.println("오라클 프로젝트");;
	}
	String viewBusan() {
		return "부산";
	}
}
public class OverWriteTest {

	public static void main(String[] args) {
		
		OracleView oracle = new OracleView();
		oracle.viewName();
		System.out.println(oracle.viewSeoul());
		System.out.println(oracle.viewBusan());
		

	}

}
