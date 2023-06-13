<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>

	<%
	String username = request.getParameter("username");
	String birthday = request.getParameter("birthday");
	String phone = request.getParameter("phone");
	String addr = request.getParameter("addr");
	String gender = request.getParameter("gender");
	String[] hobby = request.getParameterValues("hobby");
	%>
	전송이름    :	<%=username%>	<br> 
	전송생년월일  :	<%=birthday%>	<br> 
	전송연락처   :	<%=phone%>	<br> 
	전송거주지    :	<%=addr%>	<br>
	성별       :	<%=gender%>	<br>
	
<!-- 	String[] hobby = {"바둑","체스"};
	    String[] hobby = {"바둑","장기"};
	    String[] hobby = {"바둑","장기",체스"};
      	String[] hobby = {}; -->

취미 :
<%
if (hobby == null) {
	out.print("취미:선택없음");
} else {
	for (int i=0; i<hobby.length; i++) {
		out.print(hobby[i]+ " ");
	}
}



%> <br>
<input type="button" value="뒤로" onclick="history.back()">
<!-- history.back() 이전페이지로 이동  -->
