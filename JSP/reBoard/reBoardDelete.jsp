<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8");%>
    
<%@ include file="../include/oracleCon.jsp" %>      
<%
Statement stmt = con.createStatement();
%>

<%
String unq = request.getParameter("unq");
String pass = request.getParameter("pass");
%>
<!-- 고유번호, 암호의 null 체크 -->

<!-- 하위 댓글 존재여부의 SQL 작성  -->
<%
String sql1 = " select gid,thread from reboard "
			+ " where unq = '"+unq+"' and pass = '"+pass+"' ";
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);

if( !rs1.next() ) {   // next해서 결과가 없다는건 pass가 맞지 않아서 출력이 안된것임.
%>
	<script>
	alert("암호를 잘못 입력했습니다.");
	history.back();
	</script>
<%
	return;
}

String dbGid = rs1.getString("gid");
String dbThread = rs1.getString("thread");

String sql2 = " select count(*) cnt from reboard "
			+ " where gid = '"+dbGid+"' and thread like '" +dbThread+"_'  ";
Statement stmt2 = con.createStatement();
ResultSet rs2 = stmt2.executeQuery(sql2);
rs2.next();
int cnt = rs2.getInt("cnt");

String sql3 = "";
if(cnt > 0) {   //  하위댓글이 있는경우
	sql3 = " update reboard set title='글쓴이에 의한 삭제',content=' ' "
		 + " where unq = '" +unq+ "' ";	

} else {    // 하위댓글이 없는 경우
	sql3 = " delete from reboard where unq ='"+unq+"'";

}
int result = stmt2.executeUpdate(sql3);
if (result == 1 ) {
%>
	<script>
	alert("삭제처리 완료!");
	location="reBoardList.jsp";
	</script>
<%	
} else {
%>
	<script>
	alert("삭제처리 실패!");
	location="reBoardList.jsp";
	</script>
<%	
}
%>
