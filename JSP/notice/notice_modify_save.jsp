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
String title = request.getParameter("title");
String text = request.getParameter("text");

if ( title == null || title.equals("")) {
%>
	<script>
	alert("제목을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}
if ( text == null || text.equals("")) {
%>
	<script>
	alert("내용을 입력해주세요.");
	history.back();   //이전페이지로 GO
	</script>
<%	
	return;   //jsp  종료 
}


String sql = " update notice01 set title ='" + title +"'"
		   + " ,text = '" + text + "'"
		   + " where unq =" + unq + "";
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>

	<script>
	alert("저장완료");
	location = "notice_list.jsp";
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
