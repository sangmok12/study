<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
String unq = request.getParameter("unq");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변게시판 삭제화면</title>
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
	if( f.pass.value == "" ){
		alert("암호를 입력해주세요.");
		f.pass.focus();    //커서를 위치하게 함
		return false;   //종료
	}
	f.submit();
}
</Script>
<body>
<form name="frm" method="post" action="reBoardDelete.jsp">
<input type="hidden" name="unq" value="<%=unq %>">
<table>
	<caption style="font-size:20px;
					font-weith:bold;">삭제화면</caption>
	<colgroup>
		<col width="20%"/>
		<col width="*"/>
	</colgroup>				
	<tr>
		<th>비밀번호 입력</th>
		<td><input type ="password" name="pass"></input></td>
	</tr>
</table>
	<div style="width:600px;
			 	margin-top:10px;
			 	text-align:center;">
		<button type = "submit" onclick="fn_submit();return false;">삭제</button>
	</div>
</form>
</body>
</html>