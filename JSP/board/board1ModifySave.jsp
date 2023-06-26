<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- DB연결 -->
<%@ include file="../include/oracleCon.jsp" %>    

<!-- 파라미터 값 설정 -->
<%request.setCharacterEncoding("UTF-8");%>

<%
String title = request.getParameter("title");
String name = request.getParameter("name");
String content = request.getParameter("content");
String unq = request.getParameter("unq");
String pass = request.getParameter("pass");
%>

<!-- 널값 체크 (제목,암호) -->
<%
if ( title == null || name == null || content == null ) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	location="board1List.jsp";   
	</script>
<%	
}
title = title.trim();   // 앞뒤 공백 제거
name = name.trim();

String sql0 = " select count(*) cnt from board1 "
			+ " where unq = '"+unq+"'"
			+ " and  pass = '"+pass+"'";
Statement stmt0 = con.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int cnt = rs0.getInt("cnt");

if ( cnt == 0) {
%>
	<script>
	alert("비밀번호가 맞지 않습니다 ! ");
	history.back();   
	</script>
<%	
	return;
}
%>
<!-- 저장 -->
<%
//hits 조회수는  default '0' 해놨기에  입력 안해도 됨. 생략함.
String sql = " update board1 set "
		   + " title    = '" + title + "',"
		   + " name     = '" + name + "',"
		   + " content  = '" + content + "',"
		   + " udate    = sysdate "
		   + " where unq ='" +unq+ "'";

%>
<!-- 메세지 출력 -->
<%
Statement stmt = con.createStatement(); 
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>

	<script>
	alert("저장완료");
	location = "shopList.jsp";
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


