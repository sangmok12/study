<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="../include/oracleCon.jsp" %>


<%
Statement stmt = con.createStatement();

String sql = "select unq,title,text,ccnt,to_char(date1,'yyyy/mm/dd') date1 from notice01 order by unq";
ResultSet rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>
function fn_delete(unq) {
	if (confirm("정말 삭제하시겠습니까?")) {
		location="notice_delete.jsp?unq="+unq;
	}
}
</script>
<body>

<div style="padding-bottom:10px;">
<button type="button" onclick="location='notice_write.jsp'">글쓰기</button>
</div>
<table border="1" width="600">
	<colgroup>
		<col width="10%"/>
		<col width="15%"/>
		<col width="25%"/>
		<col width="10%"/>
		<col width="20%"/>
		<col width="10%"/>
		<col width="10%"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>조회수</th>
		<th>등록일</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<%
	int cnt = 0;
	while(rs.next()) {
		String unq = rs.getString("unq");
		String title = rs.getString("title");
		String text = rs.getString("text");
		String ccnt = rs.getString("ccnt");
		String date1 = rs.getString("date1");
		cnt++;
	%>
	<tr>
		<td align="center"><%=unq %></td>
		<td align="center"><%=title %></td>
		<td align="center"><a href="notice_detail.jsp?unq=<%=unq %>"><%=text %></a></td>
		<td align="center"><%=ccnt %></td>
		<td align="center"><%=date1 %></td>
		<td align="center">
		<a href="notice_modify.jsp?unq=<%=unq%>"><button type = "button">수정</button></a>
		</td>
		<td align="center"><button type="button"
			onclick="fn_delete('<%=unq %>')">삭제</button></td>
	</tr>
	
	<%
	}
	%>

</table><br>
</body>
</html>