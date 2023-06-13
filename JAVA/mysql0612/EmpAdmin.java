package mysql0612;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpAdmin extends DbConnect{

	public static void main(String[] args) throws Exception {
		
		System.out.println("1. 기본출력");
		System.out.println("2. 부서별출력");
		System.out.println("3. 페이지별출력");
		Scanner scn = new Scanner(System.in);
		System.out.println("번호입력>>");
		int num = scn.nextInt();
		switch(num) {
		case 1 : empDml();
		break;
		case 2 : 
		break;
		case 3 : 
		break;
		default : System.out.println("없는 번호입니다.");
		}
	}
	public static void empDml() throws Exception {
		System.out.println(" --------------------");
		System.out.println("1. 기본출력");
		System.out.println("2. 입력화면");
		System.out.println("3. 수정화면");
		System.out.println("4. 삭제화면");
		Scanner scn = new Scanner(System.in);
		System.out.println("번호입력>>");
		int num = scn.nextInt();
		switch(num) {
		case 1 : empSelectList();
		break;
		case 2 : empInsert();
		break;
		case 3 : empUpdate();
		break;
		case 4 : empDelete();
			break;
		default : System.out.println("없는 번호입니다.");
		}
	}
	public static void empSelectList() throws Exception {
		Statement stmt = mysqlConnect().createStatement();

		String sql1 = "select count(*) total from emp";
		//  query 적용
		ResultSet rs1 = stmt.executeQuery(sql1);
		int total = 0;
		if (rs1.next() ) {
			//  컬럼명을 통해 해당 요소에 접근
			total = rs1.getInt("total");
		} else {
			return;
		}
		String sql2 = "select empno"
				+ "		  	 ,ename"
				+ "			 ,job"
				+ "			 ,mgr"
				+ "			 ,hiredate"
				+ "			 ,sal"
				+ "			 ,comm"
				+ "			 ,deptno"
				+ " from emp"
				+ " order by empno asc";
		ResultSet rs2 = stmt.executeQuery(sql2);

		System.out.println("[ 사원목록 ] 총 : " + total+"명");
		System.out.println("------------------------------------");
		int number = 0;
		while(rs2.next()) {
			String empno      = rs2.getString("empno");
			String ename      = rs2.getString("ename");
			String job        = rs2.getString("job");
			int mgr           = rs2.getInt("mgr");
			String hiredate   = rs2.getString("hiredate");
			int sal           = rs2.getInt("sal");
			int comm          = rs2.getInt("comm");
			int deptno        = rs2.getInt("deptno");
			number++;
			System.out.println(number+", "+empno+", "+ename+", "+job+", "+mgr+", "+hiredate+", "+sal+", "+comm+", "+deptno);
		}
	}
	public static void empInsert() throws Exception {
		Statement stmt = mysqlConnect().createStatement();
	      
	      Scanner scn = new Scanner(System.in);
	      System.out.println("-- 사원정보 입력 --");
	   
	      System.out.print("1.사원이름>>");
	      String ename = scn.next();
	      
	      System.out.print("2.업무명>>");
	      String job = scn.next();
	      
	      System.out.print("3.매니저번호>>");
	      int mgr = scn.nextInt();
	      
	      System.out.print("4.입사일(0000-00-00)>>");
	      String hiredate = scn.next();
	      
	      System.out.print("5.급여>>");
	      int sal = scn.nextInt();
	      
	      System.out.print("6.보너스>>");
	      int comm = scn.nextInt();
	      
	      System.out.print("7.부서번호>>");
	      int deptno = scn.nextInt();
	      
	      String sql2 ="select max(empno) max from emp ";
         
      ResultSet rs2 = stmt.executeQuery(sql2);
      rs2.next();
      int max = rs2.getInt("max");
      
	      String sql = "insert into emp "
	      		     + "values('"+(max+1)+"','"+ename+"','"+job+"','"+mgr+"','"+hiredate+"','"+sal+"','"+comm+"','"+deptno+"')";
	      int result = stmt.executeUpdate(sql);   // 실행한 값의 횟수마다 카운트 1 됨
	      if(result > 0) {
	    	  System.out.println("저장완료");
	      }  else {
	   		  System.out.println("저장실패");
	      }
	}
	public static void empUpdate() throws Exception {
		Statement stmt = mysqlConnect().createStatement();
        
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
        
	      System.out.print("1.입사일(0000-00-00)>>");
	      String hiredate = scn.next();
	      
	      System.out.print("2.급여>>");
	      int sal = scn.nextInt();
	    
        
        String sql= " update emp set hiredate='"+hiredate+"',sal='"+sal+"'"
                    +" where empno ='"+empno+"' "; //데이터 삽입
        int result = stmt.executeUpdate(sql);   //executeUpdate : 데이터 입력,업데이트,제거
        if(result>0) {
           System.out.println("변경 완료");
        }
           else {
            System.out.println("변경 실패");   
           }
	}
	public static void empDelete() throws Exception {
		Statement stmt = mysqlConnect().createStatement();
	      
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
	      String sql = "delete from emp "
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
