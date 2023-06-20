<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/oracleCon.jsp" %>

<%
Statement stmt = con.createStatement();

String unq = request.getParameter("unq");

String sql = "select title,name,content from reboard where unq ="+unq;
ResultSet rs = stmt.executeQuery(sql);
rs.next();

String title = rs.getString("title");
String name = rs.getString("name");
String content = rs.getString("content");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형게시판수정</title>
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
function fn_submit() {
	var f = document.frm;
	if( f.title.value == "" ){
		alert("제목을 입력해주세요.");
		f.title.focus();    //커서를 위치하게 함
		return false;   //종료
	}
	if( f.pass.value == "" ){
		alert("암호를 입력해주세요.");
		f.pass.focus();    //커서를 위치하게 함
		return false;   //종료
	}
	f.submit();
}
</Script>
<body>
<form name="frm" method="post" action="reBoardModifySave.jsp">
<input type="hidden" name="unq" value="<%=unq %>">
<table>
	<caption style="font-size:20px;
					font-weith:bold;">수정화면</caption>
	<colgroup>
		<col width="20%"/>
		<col width="*"/>
	</colgroup>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" style="width:99%" value="<%=title %>"></td>
	</tr>
	<tr>
		<th>암호</th>
		<td><input type="password" name="pass" style="width:99%"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" style="width:99%" value="<%=name%>" readonly></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" style="width:99%; height:100px";><%=content %></textarea></td>
	</tr>
</table>
	<div style="width:600px;
			 	margin-top:10px;
			 	text-align:center;">
		<button type = "submit" onclick="fn_submit();return false;">저장</button>
		<!--  submit은  엔터키로 넘기는 기능이 포함.  button 으로 하면 없음.   -->
		<button type = "reset">취소</button>
	</div>
</form>
</body>
</html>