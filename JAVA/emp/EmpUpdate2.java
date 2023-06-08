package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import comm.DbConnect;

public class EmpUpdate2 extends DbConnect {

	public static void main(String[] args) throws Exception {
		
		Map<String,String> map = new HashMap<String,String>();
		Scanner scn = new Scanner(System.in);
		
		System.out.println("[ 사원정보 변경 ]");
		System.out.print("사원번호(수정)>>");
		String empno = scn.next();
		
		map.put("empno", empno);
		map.put("ename", "뉴비");
		map.put("job", "청소");
		map.put("mgr", "9181");
		map.put("hiredate", "2022-01-01");
		map.put("sal", "330");
		map.put("comm", "0");
		map.put("deptno", "90");
		
		update(map);
	}
	public static void update(Map map) throws Exception {
		
		Statement stmt = Connection().createStatement();
		String sql1 = "select count(*) cnt from emp"
					+ " where empno='"+map.get("empno")+"' ";
		ResultSet rs1 = stmt.executeQuery(sql1);
		rs1.next();
		int cnt = rs1.getInt("cnt");
		if( cnt == 0 ) { // 사원번호가 없는경우
			System.out.println("사원번호가 없습니다.");
			return;
		}
		String sql2 = "update emp set "
				+ " ename    = '"+map.get("ename")+"' "
				+ ",job      = '"+map.get("job")+"' "
				+ ",mgr      = '"+map.get("mgr")+"' "
				+ ",hiredate = '"+map.get("hiredate")+"' "
				+ ",sal      = '"+map.get("sal")+"' "
				+ ",comm     = '"+map.get("comm")+"' "
				+ ",deptno   = '"+map.get("deptno")+"' "
				+ " where empno = '"+map.get("empno")+"' ";
		int result = stmt.executeUpdate(sql2);
		if(result > 0) {
			System.out.println("업데이트 완료");
		} else {
			System.out.println("변경 실패");
		}			
	}
}
