<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판등록</title>
</head>
<body>
<form name="frm" method="post" action="notice_write_save.jsp">
<table border="1" width="800">
	<tr>
		<th width="10%">제목</th>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="text" rows="40" cols="70"></textarea></td>
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