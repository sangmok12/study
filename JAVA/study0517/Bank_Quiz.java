package study0517;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Bank_Quiz {

	public static void bankPlus() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/lsm/bank.txt";          //저장파일

		//물리적인 위치로의 전환(인식) 관련 클래스
		FileReader fr = new FileReader(path);
		//물리적인 파일 내용 확인 클래스
		BufferedReader br = new BufferedReader(fr);

		System.out.println("\n\n[ 입금화면 ] \n" );
		System.out.println("아이디 >>");
		String id = scn.next();
		System.out.println("입금액 >>");
		int money = scn.nextInt();

		String rowData = "";      //읽어들인 한줄을 저장
		String otherData = "";    //나머지 데이터들 저장
		String myData = "";	 	  //사용자가 입력한 ID와 money의 세팅
		int sumMoney = 0;         //기존 금액과 입금액의 합계

		while(true) {
			if( (rowData = br.readLine()) != null) {
				if(rowData.indexOf(id+":") > -1) {
					String[] str = rowData.split(":");
					sumMoney = money + Integer.parseInt(str[1]);
					myData = id + ":" + sumMoney;
				} else {
					otherData += rowData+"\n";

				}
			} else {
				break;   //while문 종료
			}
		}
		if(myData.equals("")) {   // 기존거래가 없어 myData가 생성되지 않으면.
			myData = id+":"+money;
			sumMoney = money;
		}
		File file = new File(path);
		//덮어쓰기 용도로 클래스를 사용가능 상태로 만듦
		FileWriter fw = new FileWriter(file,false);
		fw.write(otherData+myData);
		fw.close();

		System.out.println(id+"님의 계좌로 "+money+"원이 입금되어 잔액은 "+sumMoney+"원 입니다.\n\n");
	}

	
	public static void bankMinus() throws Exception {
		Scanner scn = new Scanner(System.in);
		String path = "C:/lsm/bank.txt";          //저장파일
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		String rowData = "";      //읽어들인 한줄을 저장
		String otherData = "";    //나머지 데이터들 저장
		String myData = "";	 	  //사용자가 입력한 ID와 money의 세팅
		int sumMoney = 0;         //기존 금액과 입금액의 합계


		System.out.println("\n\n[ 출금화면 ] \n" );
		System.out.println("아이디 >>");
		String id = scn.next();
		while(true) {
			if( (rowData = br.readLine()) != null) {
				if(rowData.indexOf(id+":") > -1) {
					System.out.println("출금액 >>");
					int money = scn.nextInt();
					String[] str = rowData.split(":");
					
					if (Integer.parseInt(str[1]) >= money) {
						sumMoney = Integer.parseInt(str[1]) - money;
						myData = id + ":" + sumMoney;
						System.out.println(id+"님의 계좌에서 "+money+"원이 출금되어 잔액은 "+sumMoney+"원 입니다.\n\n");
					} else {
						myData = id + ":" + Integer.parseInt(str[1]);
						System.out.println("출금불가 (계좌잔액이 출금액보다 부족합니다.)");
						System.out.println("계좌잔액 : "+Integer.parseInt(str[1]) +"원, 출금액 : "+money+"원\n\n");
						return;
					}

				} else {
					System.out.println("계좌가 없습니다.\n\n");
					return;
				}
			} else {
				break;   //while문 종료
			}
		}
		
		File file = new File(path);
		//덮어쓰기 용도로 클래스를 사용가능 상태로 만듦
		FileWriter fw = new FileWriter(file,false);
		fw.write(otherData+myData);
		fw.close();
	}

	
	public static void bankMoney() throws Exception {

		Scanner scn = new Scanner(System.in);
		String path = "C:/lsm/bank.txt";          //저장파일
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		System.out.println("\n\n[ 잔액조회 ] \n" );
		System.out.println("아이디 >>");
		String id = scn.next();


		String rowData = "";      //읽어들인 한줄을 저장
		int cnt = 0;

		while(true) {
			if( (rowData = br.readLine()) != null) {
				if(rowData.indexOf(id+":") > -1) {
					String[] str = rowData.split(":");
					System.out.println(id+"님의 계좌잔액은 "+str[1]+"원 입니다.\n\n");
					cnt++;
				}
			} else {
				break;   //while문 종료
			}
		}
		if (cnt == 0) {
			System.out.println("계좌가 없습니다.\n\n");
		}

	}

	public static void main(String[] args) throws Exception {

		while(true) {
			Scanner scn = new Scanner(System.in);
			System.out.print("1.입금 2.출금 3.잔액조회 4.프로그램 종료");
			int n = scn.nextInt();

			if (n==1) {
				bankPlus();
			} else if (n==2) {
				bankMinus();
			} else if (n==3) {
				bankMoney();
			} else if (n==4) {
				System.out.println("은행프로그램 종료");
				break;
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");

			}
		}

	}
}

/*간단한 은행 입출력 프로그램 작성
 * ( 1. 입금 2. 출금 3. 잔액 )
 * 번호 >>
 * 
 * 1. 입금
 * 아이디 >> test1
 * 입금액 >> 1000
 * test1님의 계좌에 1000원이 입금되었습니다.
 * 
 * 2. 출금
 * 아이디 >> test1
 * 출금액 >> 500
 * test1님의 계좌에서 500원이 출금되었습니다.
 * 
 * 3. 잔액
 * 아이디 >> test1
 * test1님의 잔액은 500원입니다.
 * 
 * 
 * test1:1000
 * test107:3000
 * abc77:77000
 * hong12:0
 * 
 * (1)아이디와 입금액을 입력받는다.
 * (2)저장파일을 읽어들여 해당 아이디를 찾아서 가져온다.
 *    ex)test1 : 1000
 * (3)찾아온 내용에 금액을 추출하여 입금액과 합친다.
 * (4)저장내용을 만든다. 
 *    ex)test1 : 2000
 * (5)만들어진 내용을 파일에 입력한다.
 */


