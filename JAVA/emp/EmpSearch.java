package emp;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import comm.DbConnect;

public class EmpSearch extends DbConnect {

	public static void main(String[] args) throws Exception {
		System.out.println(" [ 사원검색 프로그램 ] ");
		System.out.println(" 1.사원명검색\n 2.부서별 검색\n 3.업무별 검색\n 4.매니저별 검색\n 5.급여별 검색");
		System.out.print(" 번호 >> ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();

		switch(num) {
		case 1 : nameSearch();
		break;
		case 2 : deptSearch();
		break;
		case 3 : jobSearch();
		break;
		case 4 : mgrSearch();
		break;
		case 5 : salSearch();
		break;
		default : System.out.println("없는 번호입니다.");
		}
	}

	public static void nameSearch() throws Exception {

		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.print("1.사원명검색>>");
		String ename = scn.next();

		String sql ="select e1.empno 	as empno"
				+ "		   ,e1.job 		as job"
				+ "		   ,e1.sal 		as sal"
				+ "		   ,e1.mgr 		as mgr"
				+ "		   ,e1.deptno	as deptno"
				+ "		   ,e2.ename 	as mname "
				+ "		   ,d.dname 	as dname"
				+ " from   emp e1, emp e2, dept d "
				+ " where  e1.mgr = e2.empno "
				+ " and    e1.deptno = d.deptno "
				+ " and    e1.ename ='"+ename.toUpperCase()+"'";

		//	         String sql = " select empno"
		//	         			+ "       ,job"
		//	         			+ "       ,sal"
		//	         			+ "       ,mgr"
		//	         			+ "       ,deptno"
		//	         			+ "       ,(select ename from emp where empno=e.mgr) mname"
		//	         			+ "       ,(select dname from dept where deptno=e.deptno) dname"
		//	         			+ " from emp e"
		//	         			+ " where ename = upper('"+ename+"')";
		
		// System.out.println(sql);  프린트해서 확인해보는용( SQL디벨로퍼에 가져간다던지)

		ResultSet rs = stmt.executeQuery(sql);
		int cnt = 0;
		while( rs.next() ) {
			cnt++;
			String empno = rs.getString("empno");
			String job = rs.getString("job");
			String sal = rs.getString("sal");
			String mgr = rs.getString("mgr");
			String deptno = rs.getString("deptno");
			String mname = rs.getString("mname");
			String dname = rs.getString("dname");

			System.out.println("1. 사원명 : "+ename.toUpperCase()+"("+empno+")");
			System.out.println("2. 업무 : " +job);
			System.out.println("3. 급여 : " +sal);
			System.out.println("4. 매니저명 : " +mname);
			System.out.println("5. 부서명 : " +dname);
		}
		if ( cnt == 0 ) {
			System.out.println("없는 사원입니다.");
		}

	}

	public static void deptSearch() throws Exception {
		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.print("부서명검색>>");
		String dname = scn.next();

		String sql2 ="select count(*) cnt from dept "
				+"where dname ='"+dname.toUpperCase()+"'";
		ResultSet rs2 = stmt.executeQuery(sql2);
		rs2.next();
		int cnt = rs2.getInt("cnt");
		if(cnt==0) {
			System.out.println("없는 부서입니다.");
			System.out.println("종료합니다.");
			return;
		}

		String sql ="select e.empno"
				+ "		   ,e.ename"
				+ "		   ,e.job"
				+ "		   ,d.dname "
				+ " from emp e, dept d "
				+ " where e.deptno = d.deptno"
				+ " and d.dname ='"+dname.toUpperCase()+"'";


		ResultSet rs = stmt.executeQuery(sql);
		int num = 0;
		System.out.println("번호\t 사원명(사원번호)\t 업무\t 부서명\t");
		while( rs.next() ) {

			String empno = rs.getString("empno");
			String job = rs.getString("job");
			String ename = rs.getString("ename");
			num++;

			System.out.println(num+"\t"+ename+"("+empno+")\t"+ job + "\t" + dname.toUpperCase());
		}
	}
	public static void jobSearch() throws Exception {
		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.print("업무명검색>>");
		String job = scn.next();

		String sql2 ="select count(*) cnt from emp "
				+"where job ='"+job.toUpperCase()+"'";
		ResultSet rs2 = stmt.executeQuery(sql2);
		rs2.next();
		int cnt = rs2.getInt("cnt");
		if(cnt==0) {
			System.out.println("존재하지않는 업무입니다.");
			System.out.println("종료합니다.");
			return;
		}

		String sql ="select e.empno"
				+ "		   ,e.ename"
				+ "		   ,e.job"
				+ "		   ,d.dname "
				+ " from emp e, dept d "
				+ " where e.deptno = d.deptno"
				+ " and e.job ='"+job.toUpperCase()+"'";


		ResultSet rs = stmt.executeQuery(sql);
		int num = 0;
		System.out.println("번호\t 사원명(사원번호)\t 업무\t 부서명\t");
		while( rs.next() ) {

			String empno = rs.getString("empno");
			String dname = rs.getString("dname");
			String ename = rs.getString("ename");
			num++;

			System.out.println(num+"\t"+ename+"("+empno+")\t"+ job.toUpperCase() + "\t" + dname);
		}
	}

	public static void mgrSearch() throws Exception {
		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.print("매니저명검색>>");
		String mname = scn.next();

		String sql2 = " select count(*) cnt "
				+ " from emp e1, emp e2"
				+ " where e1.mgr = e2.empno"
				+ " and e2.ename ='"+mname.toUpperCase()+"'";
		ResultSet rs2 = stmt.executeQuery(sql2);
		rs2.next();
		int cnt = rs2.getInt("cnt");
		if(cnt==0) {
			System.out.println("존재하지않는 매니저입니다.");
			System.out.println("종료합니다.");
			return;
		}

		String sql ="select e1.empno"
				+ "		   ,e1.ename"
				+ "		   ,e1.job"
				+ " from emp e1, emp e2 "
				+ " where e1.mgr = e2.empno"
				+ " and e2.ename ='"+mname.toUpperCase()+"'";


		ResultSet rs = stmt.executeQuery(sql);
		int num = 0;
		System.out.println("번호\t 사원명(사원번호)\t 매니저\t 업무\t");
		while( rs.next() ) {

			String empno = rs.getString("empno");
			String job = rs.getString("job");
			String ename = rs.getString("ename");
			num++;

			System.out.println(num+"\t"+ename+"("+empno+")\t"+ mname.toUpperCase() + "\t" + job);
		}
	}
	public static void salSearch() throws Exception {
		Statement stmt = Connection().createStatement();

		Scanner scn= new Scanner(System.in);
		System.out.print("급여등급검색>> (1,2,3,4,5)");
		String grade = scn.next();


		String sql ="select e.empno"
				+ "		   ,e.ename"
				+ "		   ,e.job"
				+ "	       ,e.sal"
				+ " from emp e, salgrade s "
				+ " where e.sal <= s.hisal"
				+ " and e.sal >= s.losal"
				+ " and s.grade ='"+grade+"'"
				+ " order by sal desc";


		ResultSet rs = stmt.executeQuery(sql);
		int num = 0;
		System.out.println("번호\t 사원명(사원번호)\t 급여\t 업무\t");
		while( rs.next() ) {

			String empno = rs.getString("empno");
			String job = rs.getString("job");
			String ename = rs.getString("ename");
			int sal = rs.getInt("sal");
			num++;

			System.out.println(num+"\t"+ename+"("+empno+")\t"+ sal + "\t" + job);
		}
	}
}

