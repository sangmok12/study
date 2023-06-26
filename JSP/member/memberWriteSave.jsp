<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/oracleCon.jsp" %>    
<%request.setCharacterEncoding("UTF-8");%>

<%
String userid   = request.getParameter("userid");
String userpw   = request.getParameter("userpw");
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
out.print(userpw+"<br>");
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

if ( userid == null || userpw == null || name == null) {
%>
	<script>
	alert("잘못된 경로의 접근입니다 ! ");
	self.close();   // 브라우저를 닫는 함수
	</script>
<%	
	return;   //jsp  종료 
}
userid = userid.trim();   // 앞뒤 공백 제거
userpw = userpw.trim();
name = name.trim();
%>
<!--  아이디 유효성(6~12) 체크 및 중복 체크  -->
<% 
String ptn1 = "^[0-9a-zA-Z]{1}[0-9a-zA-Z_-]{5,11}";
boolean chk1 = userid.matches(ptn1);
if( chk1 == false ) {
%>
	<script>
	alert("영문 또는 숫자로 이루어진 6자~12자 아이디");
	history.go(-1);     // history.back()  과 같은 표현
	</script>
<%	
	return;
}
%>

<%
String sql = " select count(*) as cnt "
		   + " from memberinfo "
		   + " where userid ='"+userid+"'";

Statement stmt = con.createStatement(); 
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
if (cnt != 0) {
%>
	<script>
	alert("이미 존재하는 아이디입니다.");
	history.go(-1);
	</script>
<%	
	return;
}
%>
<!--  데이터 저장 후 메시지 출력  -->
<%
//hits 조회수는  default '0' 해놨기에  입력 안해도 됨. 생략함.
String sql1 = " insert into memberinfo(unq,userid,userpw,name,gender,birthday,phone,zipcode,addr,hobby,email,homepage,rdate) "
		   + " values(memberinfo_seq.nextval,'"
		   + userid +"','"
		   + userpw +"','"
		   + name +"','"
		   + gender +"','"
		   + birthday+"','"
		   + phone + "','"
		   + zipcode +"','"
		   + addr +"','"
		   + hobby1 +"','"
		   + email +"','"
		   + homepage + "',sysdate)";
		   %>
<!-- 메세지 출력 -->
<%
Statement stmt1 = con.createStatement(); 
int result = stmt.executeUpdate(sql1);
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



