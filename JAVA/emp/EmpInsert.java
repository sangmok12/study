package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpInsert extends DbConnect {

	public static void main(String[] args) throws Exception{
		  
		Statement stmt = Connection().createStatement();
	      
	      Scanner scn = new Scanner(System.in);
	      System.out.println("-- 사원정보 입력 --");
	      System.out.print("1.사원번호>>");
	      String empno = scn.next();
	      
	      // 셀렉트로 출력값을 뽑고  그것을 ResultSet으로 받음
	      String sql2="select count(*) cnt from emp"
	      		     + " where empno ='"+empno+"'";
	      ResultSet rs2 = stmt.executeQuery(sql2);
	     
	      int cnt = 0;
	      if(  rs2.next() ) {
	    	  cnt = rs2.getInt("cnt");
	      } else {    //sql 적용오류
	    	  return;   //메소드종료
	      }
	      if( cnt > 0 ) {
	    	  System.out.println("이미 사용중인 사원번호입니다.");
	    	  return;
	      } 
	      System.out.print("2.사원이름>>");
	      String ename = scn.next();
	      
	      System.out.print("3.업무명>>");
	      String job = scn.next();
	      
	      System.out.print("4.매니저번호>>");
	      int mgr = scn.nextInt();
	      
	      System.out.print("5.입사일(0000-00-00)>>");
	      String hiredate = scn.next();
	      
	      System.out.print("6.급여>>");
	      int sal = scn.nextInt();
	      
	      System.out.print("7.보너스>>");
	      int comm = scn.nextInt();
	      
	      System.out.print("8.부서번호>>");
	      int deptno = scn.nextInt();
	      
	      // insert로 입력을 하고 int result는 실행이 된 횟수를 받음. select ->ResultSet 과 다름 
	      String sql = "insert into emp "
	      		     + "values('"+empno+"','"+ename+"','"+job+"','"+mgr+"','"+hiredate+"','"+sal+"','"+comm+"','"+deptno+"')";
	      int result = stmt.executeUpdate(sql);   // 실행한 값의 횟수마다 카운트 1 됨
	      if(result > 0) {
	    	  System.out.println("저장완료");
	      }  else {
	   		  System.out.println("저장실패");
	      }
	}

}
