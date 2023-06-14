
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!--  sql : 부서번호기준 역순
     글쓰기버튼
      순번 -->
    
<%
String url = "jdbc:oracle:thin:@//localhost:1521/xe";
String username = "c##java";
String userpass = "1234";

Class.forName("oracle.jdbc.OracleDriver");
Connection con = DriverManager.getConnection(url,username,userpass);
Statement stmt = con.createStatement();

String sql = "select deptno,dname,loc from dept order by deptno desc";
ResultSet rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  .container {
    width: 440px; /* 원하는 너비로 설정 */
    height: 500px; /* 원하는 높이로 설정 */
    border: 0px solid black; /* 테두리 스타일 설정 */
    justify-content: center; /* 가로 방향 가운데 정렬 */
    
  }
</style>
<body>

<div class="container">
<table border="1" width="440">
	<tr>
		<th>순번</th>
		<th>부서번호</th>
		<th>부서이름</th>
		<th>부서위치</th>
	</tr>
	<%
	int cnt = 0;
	while(rs.next()) {
		String deptno = rs.getString("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
		cnt++;
	%>
	<tr>
		<td width="50" align="center"><%=cnt %></td>
		<td width="90" align="center"><%=deptno %></td>
		<td width="150" align="center"><%=dname %></td>
		<td width="150" align="center"><%=loc %></td>
	</tr>
	
	<%
	}
	%>

</table><br>
<center><a href = "deptWrite.jsp"><input type="button" value="글쓰기"></input></a></center>
</div>
</body>
</html>