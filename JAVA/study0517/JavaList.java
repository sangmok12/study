package study0517;

import java.io.File;
import java.text.SimpleDateFormat;

public class JavaList {

	public static void main(String[] args) {
		//파일 및 폴더 인지하는 클래스
		File dir = new File("c://lsm/개발자");
		
		//UnixTime 을 날짜형태로 바꿔줌.
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//특정 디렉토리(폴더)의 정보들을 가져옴
		File[] names = dir.listFiles();
		//파일 갯수만큼
		for( int i=0;i<names.length;i++) {
			//폴더인지 파일인지
			if (names[i].getName().endsWith("java")) {
		
				System.out.print("<파일>\t");
			
			System.out.print(names[i].getName()+"\t");
			//length  몇 Byte인지.
			System.out.print(names[i].length()+"\t");
			System.out.println(df.format(names[i].lastModified()));
			}
		}
	}

}