<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/oracleCon.jsp" %>
<%

String memberId = (String)session.getAttribute("SessionUserId");

String pass1 = request.getParameter("pass1");
String pass2 = request.getParameter("pass2");
String pass3 = request.getParameter("pass3");


if ( pass1 == null || pass2 == null || pass3 == null) {
%>
	<script>
	alert("암호를 입력해주세요");
	self.close();   // 브라우저를 닫는 함수
	</script>
<%	
	return;   
}
String sql = " select count(*) cnt from memberinfo "
 		   + " where userid = '"+memberId+"'"
 		   + " and   userpw = '"+pass1+"' ";	
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
if ( cnt == 0 ) {
%>
	<script>
	alert("인증에 실패했습니다. \n기존의 암호를 다시 확인해주세요.");
	history.back();
	</script>
<%	
	return;
}


String sql1 = " update memberinfo set "
		    + " userpw = '"+pass3+"'"
		    + " where userid = '"+memberId+"'";
%>
<%
Statement stmt1 = con.createStatement(); 
int result = stmt1.executeUpdate(sql1);
if(result == 1) {
%>
	<script>
	alert("변경완료");
	opener.location="../main/main.jsp";
	self.close();
	</script>
<%		
} else {
%>
	<script>
	alert("변경실패(세션기간이 만료되었을 수 있습니다.)");
	self.close();
	</script>
<%
}
%>