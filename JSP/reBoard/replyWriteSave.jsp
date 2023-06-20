<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- DB연결 -->
<%@ include file="../include/oracleCon.jsp" %>    

<!-- 파라미터 값 설정 -->
<%request.setCharacterEncoding("UTF-8");%>

<%
String unq = request.getParameter("unq");
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
String sql1 = " select thread,gid from reboard where unq = '"+unq+"'";
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
rs1.next();

String dbThread = rs1.getString("thread");
String dbGid = rs1.getString("gid");

String sql2 = " select nvl(max(thread),'1') maxThread from reboard "
			+ " where gid ='" + dbGid +"' "
			+ " and thread like '"+dbThread+"_'";
Statement stmt2 = con.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);
rs2.next();

String maxThread = rs2.getString("maxThread");    // 1 or ac(제일 높은 thread값)
String myThread = "";
if ( maxThread.equals("1")) {
	myThread = dbThread+"a";
} else {  
	//ac --> ad
	//'a','c' ;;  'c'++   ->  'd'  ;;   'a'+'d'
	char lastWord = maxThread.charAt(maxThread.length()-1);
	lastWord++;
	myThread = dbThread + lastWord;
}


String sql3 = " insert into reboard(unq,title,pass,name,content,rdate,gid,thread) "
	    + " values(reboard_seq.nextval,'"
	    + title +"','"
	    + pass +"','"
	    + name +"','"
	    + content +"',sysdate,'"
	    + dbGid +"','"
	    + myThread +"')";
%>
<!-- 메세지 출력 -->
<%
Statement stmt3 = con.createStatement();
int result = stmt3.executeUpdate(sql3);
if (result == 1) {
%>

<script>
	alert("답글저장완료");
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
