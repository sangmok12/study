<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>

<%
Statement stmt = con.createStatement();

String unq = request.getParameter("unq");

String sql = "select title,text from notice01 where unq ="+unq;
ResultSet rs = stmt.executeQuery(sql);
rs.next();

String title = rs.getString("title");
String text = rs.getString("text");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록</title>
</head>
<body>
<form name="frm" method="post" action="notice_modify_save.jsp">
<input type="hidden" name="unq" value="<%=unq %>">
<table border="1" width="800">
	<tr>
		<th width="10%">제목</th>
		<td><input type="text" name="title" value = "<%=title%>"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="text" rows="40" cols="70"><%=text %></textarea></td>
	</tr>
	<tr>
		<th colspan = "2" >
			<button type="submit">저장</button>
		    <button type="reset">취소</button>
		    <button type="button" onclick="location='notice_list.jsp'">목록</button>
		</th>
	</tr>

</table>
</form>
</body>
</html>