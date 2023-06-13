package mysql0612;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpAdminT extends DbConnect {

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
	public static void empSelectList() throws Exception{

		//mysqlConnect() 데이터 베이스 연동 +작업공간 확보(객체화)
		System.out.println("---------");
		Statement stmt = mysqlConnect().createStatement();
		String sql = "SELECT empno as empno"
				+ "    ,rpad(ename,8,' ') as ename"
				+ "    ,rpad(sal,4,' ') as sal"
				+ "    ,deptno as deptno"
				+ " FROM emp";
		ResultSet rs = stmt.executeQuery(sql);
		int rownum = 0;
		while( rs.next() ) {
			rownum++;
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			String sal = rs.getString("sal");
			String deptno = rs.getString("deptno");
			if(rownum < 10) System.out.print(' ');
			System.out.println( rownum+") "+empno+","+ename+","+sal+","+deptno );
		}
	}   
	public static void empInsert() throws Exception {
		Statement stmt = mysqlConnect().createStatement();

		String sql = "select max(empno) as max"
				+ " from emp";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int max = rs.getInt("max");
		Scanner scn = new Scanner(System.in);
		System.out.println("-- 사원정보 입력 --");

		System.out.println("1.사원번호>> " + (max+1));

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


		String sql1 = "insert into emp "
				+ "values('"+(max+1)+"','"+ename+"','"+job+"','"+mgr+"','"+hiredate+"','"+sal+"','"+comm+"','"+deptno+"')";
		int result = stmt.executeUpdate(sql1);   // 실행한 값의 횟수마다 카운트 1 됨
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

		String sql ="select sal,hiredate from emp "
				+"where empno ='"+empno+"'";
		ResultSet rs = stmt.executeQuery(sql);
		int sal = 0;
		String hiredate = "";
		if(rs.next()) {
			sal = rs.getInt("sal");
			hiredate = rs.getString("hiredate");
		} else {
			System.out.println("없는 사원번호입니다.");
			return;
		}
		
		System.out.println("(현)급여 "+sal+" :: (현)입사일 "+hiredate);
		System.out.print("새로운 급여(종료:숫자이외값)>>");
		String n_sal = scn.next();
		boolean chk_sal = n_sal.matches("[0-9]*");
		if(chk_sal==false) {
			System.out.println("입력값은 "+n_sal+"으로 종료합니다.");
			return;
		}

		System.out.print("새로운 입사일(종료:날짜형식이아닌경우)>>");
		String n_hiredate = scn.next();
		boolean chk_hiredate = n_hiredate.matches ("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}");
		if(chk_hiredate == false) {
			System.out.println("입력값은 "+n_hiredate+"으로 종료합니다.");
			return;
		}
		String sql2 = "UPDATE emp SET "
                                        + "  sal='"+n_sal+"'"
                                        + " ,hiredate='"+n_hiredate+"' "
                           + " WHERE empno='"+empno+"' ";
		int result = stmt.executeUpdate(sql2);
		if(result == 1) {
			System.out.println("*** 변경완료 ***");
		} else {
			System.out.println("*** 변경실패 ***");
		}
	}
	public static void empDelete() throws Exception {
		System.out.println("---------");
        Statement stmt = mysqlConnect().createStatement();

        Scanner scn = new Scanner(System.in);
        System.out.print("사원번호(삭제)>>");
        String empno = scn.next();

         String sql = " select count(*) cnt from emp "
                          + "  where empno='"+empno+"' ";
         ResultSet rs = stmt.executeQuery(sql);
         rs.next();

         int cnt = rs.getInt("cnt");
         if(cnt == 0) {
                    System.out.println(empno+"는 없는 사원번호입니다. 종료합니다.");
                    return;
         }

         System.out.println(empno+"는 존재하는 사원입니다.");
         System.out.print("삭제를 원하면 1번, 아니면 그외를 입력하세요.>>");
         try {
                  int number = scn.nextInt();
                  if(number==1) {
                        System.out.println("*** 사원정보를 삭제합니다. ***");
                        String delSql = " delete from emp "
                                                   + " where empno='"+empno+"'";
                         stmt.executeUpdate(delSql);
                         System.out.println("*** 삭제완료 ***");
                 } else {
                        System.out.println("1번을 입력하지 않았습니다. 종료합니다.");
                        return;
                }

          } catch (Exception e) {
                System.out.println("숫자이외를 입력하셨습니다. 종료합니다.");
                return;
         }
	}

}
