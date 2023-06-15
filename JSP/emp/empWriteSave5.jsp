<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8");%>
    
<%
String url = "jdbc:oracle:thin:@//localhost:1521/xe";
String username = "c##java";
String userpass = "1234";

Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection(url,username,userpass);
Statement stmt = con.createStatement();
%>

<%
String empno = request.getParameter("empno");
String ename = request.getParameter("ename");
String mgr_name = request.getParameter("mgr_name");
String dname= request.getParameter("dname");
String job= request.getParameter("job");
String sal= request.getParameter("sal");
String hiredate= request.getParameter("hiredate");
String comm= request.getParameter("comm");

if ( empno == null || empno.equals("")) {
%>
	<script>
	alert("사원번호를 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( ename == null || ename.equals("")) {
%>
	<script>
	alert("사원이름을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( mgr_name == null || mgr_name.equals("")) {
%>
	<script>
	alert("매니저이름을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( dname == null || dname.equals("")) {
%>
	<script>
	alert("부서를 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( job == null || job.equals("")) {
%>
	<script>
	alert("업무를 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( sal == null || sal.equals("")) {
%>
	<script>
	alert("부서번호를 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( hiredate == null || hiredate.equals("")) {
%>
	<script>
	alert("입사일을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}

if ( comm == null || comm.equals("")) {
%>
	<script>
	alert("수당을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
String sql = " select empno from emp where ename = '"+mgr_name+"'";
ResultSet rs = stmt.executeQuery(sql);
rs.next();
String mgr = rs.getString("empno");
rs.close();

String sql1 = " select deptno from dept where dname = '"+dname+"'";
ResultSet rs1 = stmt.executeQuery(sql1);
rs1.next();
String deptno = rs1.getString("deptno");
rs1.close();

String sql5 = " insert into emp(empno,ename,mgr,deptno,job,sal,hiredate,comm) "
   			+" values('"+empno
   				  +"','"+ename
   				  +"','"+mgr
   				  +"','"+deptno
   				  +"','"+job
   				  +"','"+sal
   				  +"','"+hiredate
   				  +"','"+comm+"')";
int result = stmt.executeUpdate(sql5);

if(result == 1) {
%>

	<script>
	alert("저장완료");
	location = "empList.jsp";
	</script>
<%		
} else {
%>
	<script>
	alert("저장실패!");
	history.back;
	</script>
<%
}
%>

