package dept;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class DeptAdmin extends DbConnect{

	public static void main(String[] args) throws Exception{
		System.out.println("[ 부서정보관리 시스템]");
		System.out.println(" 1.부서목록\n 2.부서입력\n 3.부서변경\n 4.부서삭제");
		Scanner scn = new Scanner(System.in);
		System.out.print("메뉴번호 입력 >>");
		int menu = scn.nextInt();
		System.out.println("");
		switch(menu) {
			case 1 : deptList();
			break;
			case 2 : deptInsert();
			break;
			case 3 : deptUpdate();
			break;
			case 4 : deptDelete();
			break;
			default : System.out.println("없는 번호입니다.");
		}
	}
	public static void deptList() throws Exception {

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
	public static void deptInsert() throws Exception {
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
	public static void deptUpdate() throws Exception {
		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.println("변경 부서 정보 입력>>");


		System.out.println("1.수정 부서번호>>");
		String deptno = scn.next();

		String sql2 ="select count(*) cnt from dept "
				+"where deptno ='"+deptno+"'";
		ResultSet rs2 = stmt.executeQuery(sql2);
		rs2.next();
		int cnt = rs2.getInt("cnt");
		if(cnt==0) {
			System.out.println("동일한 부서번호가 없습니다.");
			System.out.println("종료합니다.");
			return;
		}

		System.out.println("2.부서이름>>");
		String dname = scn.next();


		System.out.println("3.부서위치>>");
		String loc = scn.next();

		String sql= " update dept set dname='"+dname+"',loc='"+loc+"' "
				+" where deptno ='"+deptno+"' "; //데이터 삽입
		int result = stmt.executeUpdate(sql);   //executeUpdate : 데이터 입력,업데이트,제거
		if(result>0) {
			System.out.println("변경 완료");
		}
		else {
			System.out.println("변경 실패");   
		}
	}
	public static void deptDelete() throws Exception {
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
