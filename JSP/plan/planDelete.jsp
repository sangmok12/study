<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>   
<%@ include file="../include/certify.jsp" %>   
<%request.setCharacterEncoding("UTF-8");%>

<%
String sche_date     = request.getParameter("sche_date");
String userid        = request.getParameter("userid");

String sql1 = " delete sche_mgr "
	     	+ " where sche_date = '"+sche_date+"'"
	     	+ " and userid = '"+SessionmemberId+"'";

Statement stmt1 = con.createStatement(); 
int result = stmt1.executeUpdate(sql1);
if(result == 1) {
%>
	<script>
	alert("삭제완료");
	location = "../plan/planMain.jsp";
	</script>
<%		
} else {
%>
	<script>
	alert("삭제실패!");
	history.back;
	</script>
<%
}
%>
