package study0502;

public class StringQuiz {

	public static void main(String[] args) {
		
		
		String subject = "Html,mysql,java     ";
		System.out.println(subject);
		System.out.println(subject.replace("mysql","oracle"));
		System.out.println(subject.length());
		
		String subject2 = subject.trim();
		System.out.println(subject2);
		System.out.println(subject2.substring(11,15));
		System.out.println(subject2.indexOf(","));
		
		int com = subject2.indexOf(",");
		System.out.println(subject2.substring(com+1,com+2));
		System.out.println(subject2.contains("javascript"));
		
		String[] array = subject2.split(",");
		System.out.println(array[1]);
		
		System.out.println("------풀어보기2------");
		
		String title = "자바프로그래밍 입문";
		String content = "자바를 이용하여 기초부터 중급까지 완성한다.";
		
		if (title.indexOf("자바") >-1 && content.indexOf("자바") > -1)
			System.out.println("둘다존재");
		else if (title.indexOf("자바") >-1 || content.indexOf("자바") > -1)
			System.out.println("하나만 존재");
		else System.out.println("존재하지않음");
		
		
		
		
		/*if (title.contains("자바") == true && content.contains("자바") == true) 
			System.out.println("자바라는 단어가 모두 포함되어 있습니다.");
		else if(title.contains("자바") != true && content.contains("자바") != true)
			System.out.println("자바라는 단어가 모두 포함되지 않았습니다.");
		else System.out.println("자바라는 단어가 한쪽만 포함 되었습니다.");*/
		
		System.out.println("------풀어보기3------");
		
		String jumsu = "eng:70,kor:90,math:88";
		String[] Jarray = jumsu.split(",");
		for (int i=0; i<Jarray.length; i++) {
			System.out.println(Jarray[i]);
		}
		
		
		System.out.println("------풀어보기4------");
		
		for (int i=0; i<Jarray.length; i++) {
			/*int JA = Jarray[i].indexOf(":");
			System.out.print(Jarray[i].substring(JA+1) + " ");*/
			System.out.print(Jarray[i].split(":")[1] + " ");
		}
		
		
		System.out.println();
		System.out.println("------풀어보기5------");
		
		String birthday = "1990/05/27";
		String[] bb = birthday.split("/");
		
		
		
		String yy = bb[0].substring(2);
		String mm = bb[1].substring(1);
		//String mm1 = bb[1].charAt(1)+"";    
		//char 타입에 +""를 넣으면 문자(String)으로 변환, 없이는 char;String달라서 안됨
		String dd = bb[2];
		
		System.out.println(yy + "년 " + mm + "월 " + dd + "일 생");
		
		System.out.println("------풀어보기6------");
		
		
		
		
		String str = "java";
		for (int i=0; i<str.length(); i++) {
		  //for (int s=str.length()-i; s<str.length(); s++)
			for (int s=0; s<i; s++) {
				System.out.print(" ");
			}
			System.out.println(str.charAt(i));
		}
		
	}

}
