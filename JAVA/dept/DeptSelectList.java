package dept;

import java.sql.ResultSet;
import java.sql.Statement;

import comm.DbConnect;

public class DeptSelectList extends DbConnect {

	public static void main(String[] args) throws Exception {

		// 접속 내용의 객게(인스턴스)화
		Statement stmt = Connection().createStatement();
		
		
		
		String sql2 = "select count(*) cnt from dept"; // as cnt(달라도 됨) 꼭 설정해야함.
		// SQL 적용  ResultSet(결과값을 받는.) executeQuery(결과값을 가져오는)
		ResultSet rs2 = stmt.executeQuery(sql2);
		rs2.next();               // 존재유뮤 + 커서(포인트)를 아래로 내림
		int total = rs2.getInt("cnt");  //as 값을 cnt로 해놨기에(컬럼명의 결과값을 가져오는 것) 가져옴



		String sql = "select deptno,dname,loc from dept"
				+ " order by deptno asc";
		ResultSet rs = stmt.executeQuery(sql);
		

		System.out.println("[ 부서목록 ] 총 : " + total+"개");
		System.out.println("------------------------------------");
		 // 위 (cnt)처럼 단건이 아님. 전체 목록을 가져옴 그래서 와일문을 씀
		 // 한줄씩 내려가면서 결과가 없으면 false로 멈춤
		while(rs.next()) {
			String deptno = rs.getString("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.println(deptno + "," + dname+ "," +loc);
		}

	}

}