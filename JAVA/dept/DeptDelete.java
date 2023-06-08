package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class DeptDelete extends DbConnect  {

	public static void main(String[] args) throws Exception {
		
		Statement stmt = Connection().createStatement();
	      
	      Scanner scn = new Scanner(System.in);
	      System.out.println("-- 부서정보 입력 --");
	      System.out.print("1.부서번호>>");
	      String deptno = scn.next();
	      
	      String sql2="select count(*) cnt from dept"
	      		     + " where deptno ='"+deptno+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2);
	      rs2.next();
	      int cnt = rs2.getInt("cnt");
	      if( cnt == 0 ) {
	    	  System.out.println("없는 부서입니다.");
	    	  System.out.println("종료합니다.");
	    	  return;    //메소드의 종료
	      }
	      
	      String sql = "delete dept "
	      		     + "where deptno = '"+deptno+"'";
	      int result = stmt.executeUpdate(sql);   // 실행한 값의 횟수마다 카운트 1 됨
	      if(result > 0) {
	    	  System.out.println("삭제완료");
	      }  else {
	   		  System.out.println("삭제실패");
	      }
	}

}
