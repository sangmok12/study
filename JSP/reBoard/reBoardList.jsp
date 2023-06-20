<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>    

<%
String viewPage = request.getParameter("viewPage");
if ( viewPage == null ) {
	viewPage = "1";
}
int first_rn = Integer.parseInt(viewPage)*10 - 9;
int last_rn = Integer.parseInt(viewPage)*10;

%>


<%
String sql0 = " select count(*) total from reboard";
Statement stmt0 = con.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int total = rs0.getInt("total");

// 12.0/10  ->  ceil(1.2)   ->   2
int lastpage = (int)Math.ceil((double)total/10);
out.print("lastpage : " + lastpage);
int number = total - (Integer.parseInt(viewPage)-1)*10;

String sql1 = " select b.* from( "
   			+ " select rownum rn,a.* from ( "
       	    + " select unq ,title ,name ,hits ,to_char(rdate,'yyyy-mm-dd') rdate,gid " 
            + " from reboard order by unq desc ) a ) b "
            + " where rn >=" +first_rn+ " and rn <= " + last_rn ;
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판 목록</title>
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

<body>
<table>
	<caption  style="font-size:20px;
					 font-weith:bold;">답변형 게시판 목록</caption>
	<colgroup>
		<col width="10%"/>
		<col width="*"/>
		<col width="15%"/>
		<col width="10%"/>
		<col width="20%"/>
	</colgroup>
	<tr>
		<th>번호</th><th>제목</th><th>글쓴이</th><th>조회수</th><th>등록일</th>
	</tr>
	<%
	while( rs1.next() ) {
		String unq = rs1.getString("unq");
		String title = rs1.getString("title");
		String name = rs1.getString("name");
		String hits = rs1.getString("hits");
		String rdate = rs1.getString("rdate");
		String gid = rs1.getString("gid");
		
	%>
		<tr>
			<td><%=number %></td>
			<td><a href="reBoardDetail.jsp?unq=<%=unq%>&viewPage=<%=viewPage%>&gid=<%=gid%>"><%=title %></a></td>
			<td><%=name %></td>
			<td><%=hits %></td>
			<td><%=rdate %></td>
		</tr>
	<%
		number --;
	}
	%>

</table>

<div style="width:600px;margin-top:10px;text-align:center;">
	<!--  페이징처리  -->
	<%
	for(int i=1; i<=lastpage; i++) {
	%>
		<a href="reBoardList.jsp?viewPage=<%=i%>"><%=i %></a>
	<%	
	}
	%>
</div>

<div style="width:600px;margin-top:10px;text-align:right;">
	<button type="button" onclick="location='reBoardWrite.jsp'">글쓰기</button>
</div>
</body>
</html>