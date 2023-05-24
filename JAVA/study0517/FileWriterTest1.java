package study0517;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterTest1 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("userID : ");
		String userID = scn.next();
		
		System.out.print("userPass : ");
		String userPass = scn.next();
		
		
		String txt = "userID : " + userID +"\nuserPass : " + userPass+ "\n";
		String filename = "c:/lsm/개발자/member_info12.txt";
		try {
			//파일 및 폴더를 인지하는 클래스
			File file = new File(filename);
			//인풋,생성 file,true  (이어쓰기)  file,false(덮어쓰기)
			FileWriter fw = new FileWriter(file,false);
			//INPUT  
			fw.write(txt);
			System.out.println("input success");
			fw.close();
		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

}
