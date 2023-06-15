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




String sql = " delete from emp where empno = '"+empno+"'";
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>

	<script>
	alert("삭제완료");
	location = "empList.jsp";
	</script>
<%		
} else {
%>
	<script>
	alert("삭제실패!");
	history.back;
	</script>
<%
}
%>

