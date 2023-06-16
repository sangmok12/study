<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>

<%
String unq = request.getParameter("unq");
Statement stmt = con.createStatement();


String sql = "select unq,title,text,date1,ccnt from notice01 where unq ="+unq;
ResultSet rs = stmt.executeQuery(sql);
rs.next();

String ccnt= rs.getString("ccnt");
String date1 = rs.getString("date1");
String title = rs.getString("title");
String text = rs.getString("text");

String sql1 = "update notice01 set ccnt=ccnt+1 where unq ="+unq;
ResultSet rs1 = stmt.executeQuery(sql1);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록</title>
</head>
<script>
function fn_delete(unq) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location="notice_delete.jsp?unq="+unq;
	}
}
</script>
<body>
<table border="1" width="800">
	<tr>
		<th>번호</th>
		<th><%=unq %></th>
		<td align = "center">제목</td>
		<td align = "center"><%=title%></td>
		<td align = "center">등록일</td>
		<td align = "center"><%=date1.substring(0,10)%></td>
		<td align = "center">조회수</td>
		<td align = "center"><%=ccnt%></td>
	</tr>
	<tr height="400">
		<th >내용</th>
		<td colspan = "7"><%=text %></td>
	</tr>
	<tr>
		<th colspan = "8" >
			
			<a href="notice_modify.jsp?unq=<%=unq%>"><button type = "button">수정</button></a>
			<button type="button"
			onclick="fn_delete('<%=unq %>')">삭제</button>
		    <button type="button" onclick="location='notice_list.jsp'">목록</button>
		</th>
	</tr>

</table>

</body>
</html>