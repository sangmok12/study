package study0428;

import study0509.BoardVO;
import study0509.Person1;

public class Student1 {

	public static void main(String[] args) {
		Person1 s1 = new Person1();   //인스턴스 처리
		s1.name = "홍길동";          //public
		//s1.age = 30;               //(생략)
		//s1.height = 170;           //protect
		//s1.weight = 70;          //private 
		s1.setWeight(70);
		System.out.println(s1.name);
		
		
		BoardVO s2 = new BoardVO();
		s2.setTitle(" 제 목업 음");
		s2.setPass("  33 5   235     ");
		s2.setName("홍길동");
		s2.setContent("  2nwn  352");
		s2.setEmail("423@3525");
		
		System.out.println(s2.getTitle());
		System.out.println(s2.getPass());
		System.out.println(s2.getName());
		System.out.println(s2.getContent());
		System.out.println(s2.getEmail());
	}

}
