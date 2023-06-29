<%@page import="conn.Cookies"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/oracleCon.jsp" %>
<% 
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");
String chk    = request.getParameter("chk");

if( chk == null ) {
	out.print("null");
} else {
	out.print("ok");
}

String sql = " select count(*) cnt from memberinfo "
 		   + " where userid = '"+userid+"'"
 		   + " and   userpw = '"+userpw+"' ";	
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
rs.next();
int cnt = rs.getInt("cnt");
if ( cnt == 0 ) {
%>
	<script>
	alert("인증에 실패했습니다. \n아이디와 암호를 다시 확인해주세요.");
	history.back();
	</script>
<%	
	return;
}
// SessionUserId
// 예) String SessionUserID = "test123";
// 세션변수 생성
session.setAttribute("SessionUserId",userid);
session.setMaxInactiveInterval(60*60);  // 한시간 유지 (초단위)

//쿠키설정 (아이디 기억하기)   
//createCookie(변수명,변수값,적용범위(/은 모든범위 거의 이렇게 함),적용시간(-1은 무한대,60*60,3600식으로 표현하면됨));
if(chk == null) {
	response.addCookie(Cookies.createCookie("CookieUserId","","/",-1) );
} else {  // chk 체크가 됐을 시에만 쿠키발생
	response.addCookie(Cookies.createCookie("CookieUserId",userid,"/",-1) );
}


%>
<script>
	alert("<%=userid%>님 환영합니다.");
	location = "../main/main.jsp";
</script>