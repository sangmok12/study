package study0518;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Member_3 {

	public static void memberjoin() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/html_test/member.txt";         



		String birthday = "";
		String phone = "";
		String id = "";

		while (true) {
			System.out.println("아이디(영문으로시작,숫자,기호포함 5~12자리) >>");
			id = scn.next();
			String pattern = "^[a-zA-Z]{1}[a-zA-Z0-9_-]{4,11}";
			if(id.matches(pattern)){
				break;
			} else {
				System.out.println("올바른 형식이 아님");
			}
		}

		while (true) {
			System.out.println("생년월일(yyyy-MM-DD) >>");
			birthday = scn.next();
			String pattern = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
			if (birthday.matches(pattern)) {
				String[] num = birthday.split("-");
				if(Integer.parseInt(num[0])<=2023 && 
					Integer.parseInt(num[0])<=12 &&
					Integer.parseInt(num[0])<=31) {
					break;
				} else { 
					System.out.println("올바른 날짜 아님");
				}
				
			} else {
				System.out.println("올바른 날짜 아님");
			}
		}
		while (true) {
			System.out.println("핸드폰('-'포함) >> ");
			phone = scn.next();
			String pattern = "01(0|1|[6-9])-[0-9]{3,4}-[0-9]{4}";
			if(phone.matches(pattern)) {
				break;
			} else {
				System.out.println("'-'포함 010-xxxx-xxxx 또는 01x-xxx-xxxx으로 입력해주세요.");
			}
		}

		String rowData = "";      
		String otherData = "";   
		String userData = "";	 	  


		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				if( (rowData = br.readLine()) != null) {
					if(rowData.indexOf(id+"/") > -1) {					
						System.out.println("이미 등록된 회원입니다.\n\n");

						return;
					} else {
						otherData += rowData+"\n";
					}
				} else {
					break; 
				}
			}
			userData = id+"/"+birthday+"/"+phone;
			File file = new File(path);
			FileWriter fw = new FileWriter(file,false);
			fw.write(otherData + userData);
			fw.close();
			System.out.println("회원등록이 완료되었습니다.\n\n");

		} catch (FileNotFoundException e) {

			userData = id+"/"+birthday+"/"+phone;
			File file = new File(path);
			FileWriter fw = new FileWriter(file,false);
			fw.write(otherData + userData);
			fw.close();
			System.out.println("축하드립니다 첫 회원등록입니다 !\n\n");
		}		

	}

	public static void memberlist() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/html_test/member.txt";      
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);


		String rowData = "";    


		System.out.println("------------------------------------");
		System.out.println("\t     [회원목록]\t");
		System.out.println("------------------------------------");
		System.out.println("아이디\t출생년도(나이)\t핸드폰\n");
		while(true) {
			if( (rowData = br.readLine()) != null) {
				String[] str = rowData.split("/");
				String[] year = str[1].split("-");
				int age = 2023-Integer.parseInt(year[0]);
				System.out.println(str[0]+"\t"+str[1]+"("+(age+1)+")\t"+str[2]);

			} else {
				break; 
			}
		}
		System.out.println();
		System.out.println();
	}

	public static void memberdata() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/html_test/member.txt";    
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		System.out.println("아이디 >> ");
		String id = scn.next();

		String rowData = "";    


		System.out.println("------------------------------------");
		System.out.println("\t     [상세정보]\t");
		System.out.println("------------------------------------");

		while(true) {
			if( (rowData = br.readLine()) != null) {
				if(rowData.indexOf(id+"/") > -1) {	
					String[] str = rowData.split("/");
					System.out.println("아이디 : "+str[0]);
					System.out.println("출생일 : "+str[1]);
					System.out.println("핸드폰 : "+str[2]+"\n\n");
					return;
				} else {

				}
			} else {
				break;  
			}
		}if (rowData.indexOf(id+"/") == -1) {
			System.out.println("회원정보가 없습니다.\n\n");
		}
	}

	public static void memberdelete() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/html_test/member.txt";        
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		System.out.println("------------------------------------");
		System.out.println("\t     [삭제화면]\t");
		System.out.println("------------------------------------");
		System.out.println("아이디 >>");
		String id = scn.next();


		String rowData = "";     
		String otherData = "";   
		String userData = "";	 	
		
		int cnt = 0;    

		while(true) {
			if( (rowData = br.readLine()) != null) {
				String[] id1 = rowData.split("/");
				if(id.equals(id1[0])) {
					userData = "";
					cnt++;
				} else {
					otherData += rowData+"\n";
				}
			} else {
				break;  
			}
		}
		if(cnt==0) 		System.out.println("등록된 회원정보가 없습니다.");
		else 		System.out.println("회원정보가 삭제처리 되었습니다.\n\n");

		File file = new File(path);
		FileWriter fw = new FileWriter(file,false);
		fw.write(otherData+userData);
		fw.close();
	}


	public static void main(String[] args) throws Exception {

		while(true) {
			Scanner scn = new Scanner(System.in);
			System.out.println("------------------------------------");
			System.out.println("\t     [회원시스템]\t");
			System.out.println("------------------------------------");
			System.out.println("1.등록 2.목록 3.상세 4.삭제");
			System.out.println("번호선택 >> ");
			int n = scn.nextInt();

			if (n==1) {
				memberjoin();
			} else if (n==2) {
				memberlist();
			} else if (n==3) {
				memberdata();
			} else if (n==4) {
				memberdelete();
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}

	}

}
