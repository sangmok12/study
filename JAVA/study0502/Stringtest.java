package study0502;

public class Stringtest {

	public static void main(String[] args) {
		
		
		String str = "  javascript  ";
		
		//length()  메소드
		System.out.println( str.length()); //16
		
		//replace("old","new")  메소드 - 치환
		System.out.println(str.replace("java","oracle"));
		System.out.println(str.replace(" ",""));

		//trim() : 앞뒤 공백 제거
		str = str.trim();
		System.out.println(str);
		
		//substring(시작번호(<=부터),끝번호(>앞까지)); 범위설정 메소드
		System.out.println(str.substring(0,4));
		System.out.println(str.substring(4,10)); //script  
		System.out.println(str.substring(4)); //script 끝번호 생략가능.  
		
		//charAt() 자리번호 글자 가져오기
		System.out.println(str.charAt(3));   //a
		System.out.println(str.charAt(5));   //c
		
		//indexOf() 찾기 기능
		System.out.println(str.indexOf("script"));   //4
		System.out.println(str.indexOf("oracle"));   //-1
		
		//contains() 찾기 기능
		System.out.println(str.contains("script"));   //true
		System.out.println(str.contains("oracle"));   //false
		
		//startsWith(), 특정단어로 시작하느냐 
		System.out.println(str.startsWith("java"));   //true
		System.out.println(str.startsWith("oracle"));   //false
		
		//endsWith()   특정단어로 끝나느냐
		System.out.println(str.endsWith("java"));   //false
		System.out.println(str.endsWith("script"));   //true
		
		//split()
		str = "java,html";
		String[] array = str.split(",");   //문자열 분리
		System.out.println(array[0]);
		System.out.println(array[1]);
		
		//toUpperCase() toLowerCase()
		System.out.println("ScRipT".toUpperCase());
		System.out.println("ScRipT".toLowerCase());
		
		
		//equals()
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		System.out.println( s1 == s2 );        //true
		System.out.println( s1 == s3 );        //false
		System.out.println( s1.equals(s2));    //true
		System.out.println( s1.equals(s3));    //true

	}

}
