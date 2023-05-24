package study0428;

import study0508.Test1004;

public class Private_test {

	public static void main(String[] args) {

		
		Test1004 t1 = new Test1004();
		System.out.println(t1.title); //public 이어서 됨.
		System.out.println(t1.kor); //public 이어서 됨.
		//System.out.println(t1.eng); //protect여서 안됨  
		

		
		/*
		 * public    다른패키지까지
		 * protect   자식클래스(상속)까지
		 * default   같은패키지까지
		 * private   클래스 내부만
		 */
	}

}
