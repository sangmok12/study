<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>
<%
String id = request.getParameter("userid");

String sql = " select count(*) cnt "
		   + " from memberinfo where userid = '"+id+"'";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
String message = "";
if ( cnt == 0 ) {
	message = "사용가능한 아이디 입니다.";
} else {
	message = "이미 사용중인 아이디 입니다.";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복체크</title>
</head>
<body>

<div style="width: 98%;
			height:98%;
			background:yellow;
			text-align:center;">
<%=message %><br>
ID : <%=id%>
<button type = "button" onclick="self.close()">닫기</button>

</div>
</body>
</html>