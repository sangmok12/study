<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %> 
    
<%
String unq = request.getParameter("unq");
String viewPage = request.getParameter("viewPage");

%>   
<!--   unq의  널값 체크 -->
<%

if ( unq == null || unq.equals("") ) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	location="board1List.jsp";   
	</script>
<%	
	return;   //jsp  종료 
}
%>

<!--   SQL 작성-->
<%
String sql = "select title,name,content,to_char(rdate,'yyyy-mm-dd') rdate from board1 where unq = "+ unq ;
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

	 if( !rs.next() ) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	location="board1List.jsp";   
	</script>
<%
	return;
}

String title = rs.getString("title");
String name= rs.getString("name");
String content = rs.getString("content");
String rdate = rs.getString("rdate");

content = content.replace("\n","<br>");
stmt.executeUpdate("update board1 set hits=hits+1 where unq ='"+unq+"'");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록</title>
</head>
<style>
body {
	font-size : 12px;
	font-family : 맑은고딕;
}
table {
	width : 600px;
	border : 1px solid #555;
	border-collapse : collapse;
}
th,td {
	border : 1px solid #555;
	padding : 5px;
}
</style>
<Script>

</Script>
<body>
<form name="frm" method="post" action="board1WriteSave.jsp">
<table>
	<caption style="font-size:20px;
					font-weith:bold;">상세화면</caption>
	<colgroup>
		<col width="20%"/>
		<col width="*"/>
	</colgroup>
	<tr>
		<th>제목</th>
		<td><%=title%></td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td><%=name%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
		<div style="width:98%; height:150px;">
		<%=content%>
		</div>
		</td>
	</tr>
	<tr>
		<th>등록일시</th>
		<td><%=rdate%></td>
	</tr>
</table>
	<div style="width:600px;
			 	margin-top:10px;
			 	text-align:center;">
		<button type = "button" onclick="location='board1List.jsp?viewPage=<%=viewPage%>'">이전</button>
		<button type = "button" onclick="location='board1Modify.jsp?unq=<%=unq %>'">수정</button>
		<button type = "button" onclick="location='board1Pass.jsp?unq=<%=unq %>'">삭제</button>
	</div>
</form>
</body>
</html>