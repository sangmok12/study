<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/oracleCon.jsp" %>    
<%request.setCharacterEncoding("UTF-8");%>

<%
String sche_date     = request.getParameter("sche_date");
String title         = request.getParameter("title");
String hide          = request.getParameter("hide");
String content       = request.getParameter("content");
String userid        = request.getParameter("userid");
String gubun		 = request.getParameter("gubun");



out.print(sche_date+"<br>");
out.print(title+"<br>");
out.print(hide+"<br>");
out.print(content+"<br>");



/* merge
   into sche_mgr
   using dual
   on (userid='userid' and sche_date = 'sche_date')
when matched then
   update set
       title='title', 
       hide='N',
       content='content' 
when not matched then
     insert (unq,userid,sche_date,title,hide,content) 
    values(sche_mgr_seq.nextval,
		   'userid',
		   'sche_date',
		   'title',
		   'N',
		   'content') ; */




String sql1 = "";
if (gubun.equals("I")) {
sql1 = " insert into sche_mgr(unq,userid,sche_date,title,hide,content) "
		   + " values(sche_mgr_seq.nextval,'"
		   + userid +"','"
		   + sche_date +"','"
		   + title +"','"
		   + hide +"','"
		   + content+"')";
} else if ( gubun.equals("U"))	{
   sql1 = " update sche_mgr set "
		+ " title = '"+title+ "',"	
		+ " hide = '"+hide+ "',"	
		+ " content = '"+content+ "'"
		+ " where userid = '"+userid+"'"
		+ " and sche_date = '"+sche_date+"'";
}

Statement stmt1 = con.createStatement(); 
int result = stmt1.executeUpdate(sql1);
if(result == 1) {
%>
	<script>
	alert("저장완료");
	location = "../plan/planMain.jsp";
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



