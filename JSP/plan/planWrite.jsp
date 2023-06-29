<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>    
    
<%
String sche_date = request.getParameter("date"); 



String[] s_date = sche_date.split("-");

if (s_date[1].length() < 2) {
	s_date[1] = "0"+s_date[1];	
}	
if (s_date[2].length() < 2) {
	s_date[2] = "0"+s_date[2];	
}	
sche_date = s_date[0]+"-"+s_date[1]+"-"+s_date[2];
String userid = request.getParameter("userid"); 


String sql = " select title,content,hide from sche_mgr "
	     + " where sche_date = '"+sche_date+"'"
	     + " and userid = '"+userid+"'";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

String title = "";
String content = "";
String hide = "";
String gubun = "I";
String title_massage = "일정등록";

if ( rs.next() ) {
title = rs.getString("title");
content = rs.getString("content");
hide = rs.getString("hide");
gubun = "U";
title_massage = "일정변경";
}
%>    
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>일정등록</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>
<style>

td { text-align:left;     }
.input1 {	width : 80%;  }
.input2 {	width : 70px; }


</style>
<script>


function fn_submit() {
	var f = document.frm;
	
	if( f.title.value == "" )  {
		alert("제목을 작성해주세요.");
		f.title.focus();
		return false;
	}
	if( f.content.value == "" )  {
		alert("내용 입력해주세요.");
		f.content.focus();
		return false;
	}
	f.submit();
}

function fn_delete() {
	if( confirm("일정을 삭제하시겠습니까?")) {
	document.frm.action = "planDelete.jsp";
	document.frm.submit();
	}
}

</script>

<body>
<div class="wrap">
    <header>
      <div class="top_header">

      </div>
    </header>
    <nav>
      <div class="nav_left_space">&nbsp;</div>
      <div class="nav_center_space"> 
	      <!--  nav menu S  -->
	 	     <%@include file="../include/navmenu.jsp" %>
	      <!--  nav menu E  -->
      </div>
      <div class="nav_right_space">&nbsp;</div>
    </nav>
   <aside>
	    <!--  aside  menu S  -->
	      <%@include file="../include/aside.jsp" %>
	    <!--  aside  menu E  -->
   </aside>
    <section>
       <article>
	<!--  본문 S -->
<form name="frm" method="post" action="planWriteSave.jsp">
<input type="hidden" name="gubun" value="<%=gubun %>">
<input type="hidden" name="userid" value="<%=userid %>">
	<table>
	<caption style="font-size: 20px; font-weith: bold;"><%=title_massage %></caption>
		<tr>
			<th>날짜</th>
			<td>
			<input type="date" 
				   name="sche_date" 
				   class="input1"
				   value="<%=sche_date %>">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class="input1" value="<%=title%>"></td>
		</tr>
		<tr>
			<th>공개여부</th>
			<td>
				<input type="radio" name="hide" value="N" checked>보이기
				<input type="radio" name="hide" value="Y" <%= hide.equals("Y") ? "checked" : "" %>>숨기기
			</td>
		</tr>
		<tr>
				<th>내용</th>
				<td><textarea name="content"
						style="width: 99%; height: 100px";><%=content %></textarea></td>
		</tr>
	</table>
	<div style="width:600px; 
				text-align:center;
				margin-top:10px;">
		<button type="submit" onclick="fn_submit();return false;">저장</button>
		<button type="reset"  onclick="history.back()">취소</button>
		
		<%
		if ( gubun == "U") {
		%>
		<button type="button" onclick="fn_delete()">일정삭제</button>
		<%
		}
		%>
	</div>
</form>
	
	<!--  본문 E -->
	
       </article>
    </section>
    <footer>
	    <!--  footer  menu S  -->
	      <%@include file="../include/footer.jsp" %>
	    <!--  footer  menu E  -->
    </footer>
</div>
</body>
</html>