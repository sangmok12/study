<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/oracleCon.jsp" %>    

<%request.setCharacterEncoding("UTF-8");%>    

<%
String title = request.getParameter("title");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String content = request.getParameter("content");
%>

<!-- 널값 체크 (제목,암호) -->
<%

if ( title == null || pass == null ) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	location="reBoardList.jsp";   
	</script>
<%	
	return;   //jsp  종료 
}
title = title.trim();   // 앞뒤 공백 제거
pass = pass.trim();
%>
<%
if ( title.equals("") || pass.equals("")) {
%>
	<script>
	alert("제목 또는 암호를 입력하세요 ! ");
	location="reBoardList.jsp";   
	</script>
<%	
	return;
}
%>

<%
//   초기에 max(gid)를 가져와도  디벨로퍼에선 null 이지만 자바에서 0 으로 가져긴함.
String sql = "select nvl(max(gid),0)+1 mygid from reboard";
Statement stmt = con.createStatement(); 
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int mygid = rs.getInt("mygid");


//hits 조회수는  default '0' 해놨기에  입력 안해도 됨. 생략함.
String sql1 = " insert into reboard(unq,title,pass,name,content,rdate,gid,thread) "
		    + " values(reboard_seq.nextval,'"
		    + title +"','"
		    + pass +"','"
		    + name +"','"
		    + content +"',sysdate,'"
		    + mygid +"','a')";
%>
<!-- 메세지 출력 -->
<%
Statement stmt1 = con.createStatement(); 
int result = stmt1.executeUpdate(sql1);
if(result == 1) {
%>

	<script>
	alert("저장완료");
	location = "reBoardList.jsp";
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
