package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpDelete extends DbConnect {

	public static void main(String[] args) throws Exception{
		 
		Statement stmt = Connection().createStatement();
	      
	      Scanner scn = new Scanner(System.in);
	      System.out.println("-- 사원정보 입력 --");
	      System.out.print("1.사원번호>>");
	      int empno = scn.nextInt();
	      
	      String sql2="select count(*) cnt from emp"
	      		     + " where empno ='"+empno+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2);
	      rs2.next();
	      int cnt = rs2.getInt("cnt");
	      if( cnt == 0 ) {
	    	  System.out.println("없는 사원입니다.");
	    	  System.out.println("종료합니다.");
	    	  return;    //메소드의 종료
	      }
	      
	      System.out.print("정말 삭제하시겠습니까? (1.예 , 2.아니오) >>");
	      int yes = scn.nextInt();
	      if (yes == 1) {
	      String sql = "delete emp "
	      		     + "where empno = '"+empno+"'";
	      int result = stmt.executeUpdate(sql);   // 실행한 값의 횟수마다 카운트 1 됨
	      if(result > 0) {
	    	  System.out.println("삭제완료");
	      }  else {
	   		  System.out.println("삭제실패");
	      }
	      }
	      else if(yes==2) {
	    	  System.out.println("삭제취소");
	      }else {
	    	  System.out.println("잘못입력하셨습니다.");
	      }
	}

}
