package emp;

import java.sql.ResultSet;
import java.sql.Statement;

import comm.DbConnect;

public class EmpSelectList extends DbConnect {

	public static void main(String[] args) throws Exception{
		
		
		// 접속 내용의 객게(인스턴스)화
		Statement stmt = Connection().createStatement();
		
		
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
				+ "			 ,to_char(hiredate,'yyyy-mm-dd') hiredate"
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

}
