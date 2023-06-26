<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8");%>
    
<%@ include file="../include/oracleCon.jsp" %>      
<%
Statement stmt = con.createStatement();
%>

<%
String unq = request.getParameter("unq");
String pass = request.getParameter("pass");

String sql0 = " select pass from board1 where unq = '"+unq+"'";
Statement stmt0 = con.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
String pass1 = rs0.getString("pass");

if (pass.equals(pass1)) {
	

	String sql = " delete from board1 where unq = '"+unq+"'";
	int result = stmt.executeUpdate(sql);
	if(result == 1) {
%>
		<script>
		alert("삭제완료");
		location = "board1List.jsp";
		</script>
<%		
	} else {
%>
		<script>
		alert("삭제실패!");
		history.back();
		</script>
<%
}
} else {
%>
	<script>
		alert("비밀번호가 맞지 않습니다!");
		history.back();
	</script>

<%

}
%>

