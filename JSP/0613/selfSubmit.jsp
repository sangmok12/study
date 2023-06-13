<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selfSubmit</title>
</head>
<body>

<%
	String name = request.getParameter("name");
	String tell = request.getParameter("tell");
	%>
<%
if ( name != null && 
	 tell != null && 
	 !name.equals("") && 
	 !tell.equals("")){
	out.print(name+"의 전화번호는 "+tell+"입니다.");
} else {
	out.print("이름과 전화번호 둘 다 입력해주세요.");
}
%>	<br>

 
<form name="frm" method="post" action="selfSubmit.jsp">
이름 : <input type="text" name="name">
전번 : <input type="text" name="tell">
<input type="submit" value="전송">

</form>
</body>
</html>