<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/oracleCon.jsp" %>    
<%request.setCharacterEncoding("UTF-8");%>

<%
String userid   = (String) session.getAttribute("SessionUserId");

String name     = request.getParameter("name");
String gender   = request.getParameter("gender");
String year     = request.getParameter("year");
String month    = request.getParameter("month");
String day      = request.getParameter("day");
String p1       = request.getParameter("p1");
String p2       = request.getParameter("p2");
String p3       = request.getParameter("p3");
String zipcode  = request.getParameter("zipcode");
String addr     = request.getParameter("addr");
String[] hobby    = request.getParameterValues("hobby");
String email    = request.getParameter("email");
String homepage = request.getParameter("homepage");

String birthday = year +"-"+month+"-"+day;
String phone = p1+"-"+p2+"-"+p3;
String hobby1 = ""; // 바둑,장기,체스
for(int i=0; i<hobby.length; i++) {
	hobby1 += hobby[i]+",";
}
hobby1 = hobby1.substring(0,hobby1.length()-1);


out.print(userid+"<br>");
out.print(name+"<br>");
out.print(gender+"<br>");
out.print(birthday+"<br>");
out.print(phone+"<br>");
out.print(zipcode+"<br>");
out.print(addr+"<br>");
out.print(hobby+"<br>");
out.print(email+"<br>");
out.print(homepage+"<br>");
%>



<!-- 널값 체크 -->
<%

if ( userid == null || name == null) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	self.close();   // 브라우저를 닫는 함수
	</script>
<%	
	return;   //jsp  종료 
}
userid = userid.trim();   // 앞뒤 공백 제거
name = name.trim();
%>

<!--  데이터 저장 후 메시지 출력  -->
<%
//hits 조회수는  default '0' 해놨기에  입력 안해도 됨. 생략함.
String sql1 = " update memberinfo set "
		   + "name = '"+name+"'"
		   + ",gender = '"+gender+"' " 
		   + ",birthday=  '"+birthday+"' " 
		   + ",phone =   '"+phone+"' " 
		   + ",zipcode =  '"+zipcode+"' " 
		   + ",addr =  '"+addr+"' " 
		   + ",hobby =  '"+hobby1+"' " 
		   + ",email =  '"+email+"' " 
		   + ",homepage =   '"+homepage+"'"
		   + " where userid = '"+userid+"'";
		   %>
<!-- 메세지 출력 -->
<%
Statement stmt1 = con.createStatement(); 
int result = stmt1.executeUpdate(sql1);
if(result == 1) {
%>
	<script>
	alert("저장완료");
	location = "../main/main.jsp";
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



