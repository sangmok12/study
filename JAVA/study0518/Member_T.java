package study0518;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Member_T {
	
	static String path = "c:/html_test/member.txt";
	
	public static boolean errorCheck(String value,int n) {
		
		String pattern = "";
		if (n==1) {
			pattern = "^[0-9a-zA-Z]{4,12}";
		} else if (n==2) {
			pattern = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
		} else if (n==3) {
			pattern = "01(0|1|5)-[0-9]{3,4}-[0-9]{4}";
		}
		return value.matches(pattern);  //matches 자체가 t,f를 던져니까 이렇게놓음.
	}
	
	
	
	public static boolean memberCheck(String id) throws Exception {


		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String rowData = "";
		while (true) {
			rowData = br.readLine();
			if( rowData != null) {
				// 작업
				if (rowData.indexOf(id+"/") > -1) {
					return false; // 중복된 아이디가 있음. return으로 바로 실행정지하고 false던짐.
				}
			} else {
				break;
			}
		}
		return true;   // 중복된 아이디 없이(if 문 지나서) 내려옴. true 던짐.
	}


	public static void memberRegist() throws Exception {
		Scanner scn = new Scanner(System.in);
		System.out.println("------------");
		System.out.println("[등록화면]");
		System.out.println("------------");

		String id = "";
		String birthday = "";
		String phone = "";


		while (true) {
			System.out.print("아이디 >>");
			id = scn.next();
			if (errorCheck(id,1) == false) {
				System.out.println("아이디는 4~12사이로 해주세요(영어,숫자만).");
				continue;  //while 처음으로 다시올라가서 실행.
			}
			
			if (memberCheck(id) == false) {
				System.out.println("이미 사용중인 아이디입니다.");
				continue;  
			} break;
		}
		while (true) {
			System.out.print("출생일 >>");
			birthday = scn.next();
			if (errorCheck(birthday,2) == false) {
				System.out.println("유효한 형식이 아닙니다.");
				continue; 
			} break;
		}
		while (true) {
			System.out.print("핸드폰 >>");
			phone = scn.next();
			if (errorCheck(phone,3) == false) {
				System.out.println("유효한 형식이 아닙니다.");
				continue; 
			}
			break;
		}

		String info = id+"/"+birthday+"/"+phone;


		File file = new File(path);
		FileWriter fw = new FileWriter(file,true);   //생성, 등록
		fw.write(info+"\n");
		fw.close();
		System.out.println("회원등록이 완료되었습니다.");




	}
	public static void memberList() throws Exception {

	}
	public static void memberDetail() throws Exception {

	}
	public static void memberDelete() throws Exception {

	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		System.out.println("1.등록 \n2.목록 \n3.상세 \n4.삭제");
		System.out.println("번호선택 >> ");
		int number = scn.nextInt();
		if (number == 1) {
			memberRegist();
		} else if (number == 2) {
			memberList();
		} else if (number == 3) {
			memberDetail();
		} else if (number == 4) {
			memberDelete();
		} else {
			System.out.println("번호를 잘못 입력하였습니다.");
		}

	}

}
