<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
String SessionmemberId = (String)session.getAttribute("SessionUserId");    
    
    
if( SessionmemberId == null || SessionmemberId.trim().equals("")) {
%>
	<script>
	alert("로그인을 해주세요.");
	location = "../member/loginWrite.jsp"
	</script>
<%
	return;
}
%>