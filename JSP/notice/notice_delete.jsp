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




String sql = " delete from notice01 where unq = '"+unq+"'";
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>

	<script>
	alert("삭제완료");
	location = "notice_list.jsp";
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

