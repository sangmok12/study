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

String sql1 = " select  max(empno) max	 from emp";
ResultSet rs1 = stmt.executeQuery(sql1);
rs1.next();
int max = Integer.parseInt(rs1.getString("MAX"));






%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서등록</title>
</head>
<body>
<form name="frm" method="post" action="empWriteSave5.jsp">
<table border="1" width="400">
	<tr>
		<th>사원번호</th>
		<td><input type="text" name="empno" value="<%=max+1%>"></td>
	</tr>
	<tr>
		<th>사원이름</th>
		<td><input type="text" name="ename"></td>
	</tr>
	<tr>
		<th>매니저이름</th>
		<td><select name="mgr_name">
		<option value="">-검색-</option>
		<% 
		String sql2 = " select  distinct  e2.ename mgr_name "+
					  "	from emp e1, emp e2 " +
		  			  " where e1.mgr=e2.empno";
		ResultSet rs2 = stmt.executeQuery(sql2);
		while (rs2.next()) {
			String mgr_name = rs2.getString("mgr_name");
		%>
		<option value="mgr_name"><%= mgr_name %></option>
		<%
		}
		%>
		</select></td>
	</tr>
	<tr>
		<th>부서선택</th>
		<td><select name="dname">
		<option value="">-검색-</option>
		<% 
		String sql3 = " select  distinct  dname dname	 from dept";
		ResultSet rs3 = stmt.executeQuery(sql3);
		while (rs3.next()) {
			String dname = rs3.getString("dname");
		%>
		<option value="dname"><%= dname %></option>
		<%
		}
		%>
		</select></td>
	</tr>
	<tr>
		<th>업무선택</th>
		<td><select name="job">
		<option value="">-검색-</option>
		<% 
		String sql4 = " select  distinct   job  job  from emp";
		ResultSet rs4 = stmt.executeQuery(sql4);
		while (rs4.next()) {
			String job = rs4.getString("job");
		%>
		<option value="job"><%= job %></option>
		<%
		}
		%>
		</select></td>
	</tr>
	<tr>
		<th>급여</th>
		<td><input type="text" name="sal"></td>
	</tr>
	<tr>
		<th>입사일</th>
		<td><input type="text" name="hiredate"></td>
	</tr>
	<tr>
		<th>수당</th>
		<td><input type="text" name="comm"></td>
	</tr>
	<tr>
		<th colspan = "2" >
			<button type="submit">저장</button>
		    <button type="reset">취소</button>
		    <button type="button" onclick="location='empList.jsp'">목록</button>
		</th>
	</tr>

</table>
</form>
</body>
</html>