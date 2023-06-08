package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpUpdate extends DbConnect  {

	public static void main(String[] args) throws Exception{
	
		Statement stmt = Connection().createStatement();
         
         Scanner scn= new Scanner(System.in);
         System.out.println("변경할 사원정보 입력>>");
        
         
         System.out.print("1.사원번호>>");
         String empno = scn.next();
        
         String sql2 ="select count(*) cnt from emp "
                     +"where empno ='"+empno+"'";
         ResultSet rs2 = stmt.executeQuery(sql2);
         rs2.next();
         int cnt = rs2.getInt("cnt");
         if(cnt==0) {
            System.out.println("동일한 사원번호가 없습니다.");
            System.out.println("종료합니다.");
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
         
         String sql= " update emp set ename='"+ename+"',job='"+job+"',mgr='"+mgr+"',hiredate='"+hiredate+"',sal='"+sal+"',comm='"+comm+"',deptno='"+deptno+"'"
                     +" where empno ='"+empno+"' "; //데이터 삽입
         int result = stmt.executeUpdate(sql);   //executeUpdate : 데이터 입력,업데이트,제거
         if(result>0) {
            System.out.println("변경 완료");
         }
            else {
             System.out.println("변경 실패");   
            }
	}

}
