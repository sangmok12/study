package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class DeptInsert extends DbConnect {

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
	      if( cnt > 0 ) {
	    	  System.out.println("이미 사용중인 번호입니다.");
	    	  System.out.println("종료합니다.");
	    	  return;    //메소드의 종료
	      }
	      
	      System.out.print("2.부서이름>>");
	      String dname = scn.next();
	      
	      System.out.print("3.부서위치>>");
	      String loc = scn.next();
	      
	      String sql = "insert into dept(deptno,dname,loc) "
	      		     + "values('"+deptno+"','"+dname+"','"+loc+"')";
	      int result = stmt.executeUpdate(sql);   // 실행한 값의 횟수마다 카운트 1 됨
	      if(result > 0) {
	    	  System.out.println("저장완료");
	      }  else {
	   		  System.out.println("저장실패");
	      }
	}
}
