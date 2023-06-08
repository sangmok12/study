package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpDelete2 extends DbConnect {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("[ 사원정보삭제 ]");
		System.out.println("사원번호 (삭제)>>");
		int empno = scn.nextInt();
		try {
			delete(empno);
		} catch(Exception e) {	}
	}
	public static void delete(int empno) throws Exception{
		Statement stmt = Connection().createStatement();
		String sql1 = "select count(*) cnt from emp "
					+ " where empno = '"+empno+"' ";
		ResultSet rs1 = stmt.executeQuery(sql1);
		rs1.next();
		int cnt = rs1.getInt("cnt");
		if ( cnt == 0 ) {
			System.out.println("존재하지 않는 번호입니다.");
			return;
		}
		// delete from emp where empno in ('9001','9002');
		String sql2="delete from emp where empno = '"+empno+"' ";
		int result = stmt.executeUpdate(sql2);
		if (result >= 1) {   // 위의 주석처럼 두건이상의 삭제 일수도 있으니.
			System.out.println("삭제를 완료 했습니다.");
		} else {
			
		}
	}	 		
}
