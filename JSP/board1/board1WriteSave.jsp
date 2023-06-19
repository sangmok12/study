<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- DB연결 -->
<%@ include file="../include/oracleCon.jsp" %>    

<!-- 파라미터 값 설정 -->
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
	location="board1List.jsp";   
	</script>
<%	
	return;   //jsp  종료 
}
title = title.trim();   // 앞뒤 공백 제거
pass = pass.trim();

%>
<!-- 저장 -->
<%
//hits 조회수는  default '0' 해놨기에  입력 안해도 됨. 생략함.
String sql = " insert into board1(unq,title,pass,name,content,rdate,udate) "
		   + " values(board1_seq.nextval,'"
		   + title +"','"
		   + pass +"','"
		   + name +"','"
		   + content +"',sysdate,sysdate)";
%>
<!-- 메세지 출력 -->
<%
Statement stmt = con.createStatement(); 
int result = stmt.executeUpdate(sql);
if(result == 1) {
%>

	<script>
	alert("저장완료");
	location = "board1List.jsp";
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


