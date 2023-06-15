
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<%
String url = "jdbc:oracle:thin:@//localhost:1521/xe";
String username = "c##java";
String userpass = "1234";

Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection(url,username,userpass);
Statement stmt = con.createStatement();
%>
<% request.setCharacterEncoding("UTF-8"); %>
<% 
String colname = request.getParameter("colname");
String searchtxt = request.getParameter("searchtxt");

String str = "";
if(colname != null && !colname.equals("") &&
   searchtxt != null && !searchtxt.equals("")) 
{
	str = " and "+ colname +"= '"+searchtxt+"'";
}


String sql = " select e.empno empno" +
			 " 		 ,e.ename ename" +
			 " 		 ,d.dname dname" +
			 " 		 ,to_char(e.hiredate,'yyyy-mm-dd') hiredate " + 
			 " from emp e, dept d " +
			 " where e.deptno = d.deptno(+) " +
			 str +
			 " order by hiredate ";
ResultSet rs = stmt.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	font-size:12px;
	color:#111111;
	font-family:맑은고딕;
}
table {
	width:600px;
	border:1px solid #ccc;
	border-collapse:collapse;
}
th, td {
	border:1px solid #ccc;
	padding:5px;
	text-align:center;
}


</style>
<script>
function fn_delete(empno) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location="empDelete.jsp?empno="+empno;
	}
}
</script>

<body>
<div style="padding-bottom:10px;">

<form name="frm" method="post" action="empList.jsp">

<select name="colname">
	<option value="">-검색-</option>
	<option value="empno">사원번호</option>
	<option value="ename">사원이름</option>
	<option value="dname">부서이름</option>
	<option value="hiredate">입사일</option>	
</select>
<input type="text" name="searchtxt">
<button type="submit">검색</button>


</form>
</div>
<table>
	<colgroup>
		<col width="10%"/>
		<col width="15%"/>
		<col width="15%"/>
		<col width="25%"/>
		<col width="25%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>부서이름</th>
		<th>입사일</th>
		<th>삭제</th>
	</tr>
	<%
	int cnt = 0;
	while( rs.next() ) {
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			String dname = rs.getString("dname");
			String hiredate = rs.getString("hiredate");
			cnt++;
	%>
	<tr>
		<td><%=cnt %></td>
		<td><%=empno %></td>
		<td><%=ename %></td>
		<td><%=dname %></td>
		<td><%=hiredate %></td>
		<td><button type="button" 
			onclick="fn_delete('<%=empno %>')">삭제</button></td>
	</tr>
	<%
	}
	%>

</table>
<div style="padding-top:10px;">
<button type="button" onclick="location='empWrite.jsp'">사원등록</button>
</div>
</body>
</html>