<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!-- DB 연결 -->    
<%@ include file="../include/oracleCon.jsp" %> 
<!-- SQL 작성 20개 출력 -->
<%
String viewPage = request.getParameter("viewPage");
String s_select = request.getParameter("s_select");
String s_word = request.getParameter("s_word");

if ( viewPage == null ) {
	viewPage = "1";
}

String search = "";
if (  s_select != null 
  &&  s_word   != null
  && !s_select.equals("")
  && !s_word.equals("")  ) 
{
	if ( s_select.equals("1") ) {
		search = " a1 = '"+s_word+"' ";
	} else {
		search = " a3 like '%"+s_word+"%' "
			   + " or a4 like '%"+ s_word +"%' "
			   + " or a5 like '%"+ s_word +"%' ";
	}
} else{
	s_select = "";
	s_word = "";
	search = "1=1";
}

int s_pageno = 0;
int e_pageno  = 0;
//  viewPage  ->  1 ~ 10
//  s_pageno =1 ,  e_pageno = 10;
int vpage = Integer.parseInt(viewPage);

int s_index  = (vpage-1)* 10 + 1;
int e_index  = s_index + (10 - 1);


String sql0 = "select count(*) total from post1 where " + search;
Statement stmt0 = con.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int total = rs0.getInt("total");
int lastpageno = (int)Math.ceil((double)total/10);
s_pageno = (vpage-1)/10*10 + 1;
e_pageno = s_pageno + 10-1;
if ( lastpageno < e_pageno ) {
	e_pageno=lastpageno;
}

int nextpageno = e_pageno + 1;
if ( e_pageno >= lastpageno) nextpageno = -1;

int befpageno = s_pageno -1;

String sql1 = " select p2.* from ( "
			+ " 	select rownum rn, p1.* from ( "
			+ " 		select a1 as post "
			+ " 			  ,a2||' '||a3||' '||a4||' '||a5||' '||a6||' '||a7 as address "	
			+ " from post1 where "+ search +" order by a1 ) p1 ) p2 "
			+ " where rn >= '"+s_index+"' and rn <= '"+e_index+"'" ;
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
%>
    

    
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>layout2</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>
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
	<div style="width: 700px; margin-bottom: 10px; text-align: left;">
				<form name="frm" method="post" action="<%=request.getRequestURI() %>">
					<select name="s_select">
						<option value="">- 선택 -</option>
						<option value="1">- 우편번호 -</option>
						<option value="2">- 주소 -</option>
					</select>
					<input type="text" name="s_word">
					<button type="submit">검색</button>
				</form>
				</div>
	<table style="width:700px;">
		<tr>
			<th width="50">번호</th>
			<th width="70">우편번호</th>
			<th width="*">주소</th>
		</tr>
		
		<%
		int number = total - (Integer.parseInt(viewPage)-1)*10;
			while (rs1.next()) {
				String rn = rs1.getString("rn");
				String post    = rs1.getString("post");
				String address = rs1.getString("address");
			%>
			<tr>
				<td><%=number %></td>
				<td><%=post%></td>
				<td align="left"><%=address%></td>
			</tr>
			<%
			number--;
			}
			%>
	</table>
	
	                          <!--  페이징 파트  -->
	                          
	<div style="width:700px;text-align:center;margin-top:10px;">
		<a href="postList.jsp?viewPage=1&s_select=<%=s_select%>&s_word=<%=s_word%>">[firstpage]</a>
		<%
		if (befpageno <=0 ) {out.print("[before]"); }
		else {
		%>
		<a href="postList.jsp?viewPage=<%=befpageno%>&s_select=<%=s_select%>&s_word=<%=s_word%>">[before]</a>
		&nbsp;&nbsp;
		<%
		}
		%>
		&nbsp;&nbsp;
		<%
		String font = "";
		for(int i=s_pageno; i<=e_pageno; i++) {
			if ( i == vpage ) { font = "font-size:16px; color: red; font-weight: bold;";}
			else { font = ""; }
		%>
			<a href="<%=request.getRequestURI()%>?viewPage=<%=i%>&s_select=<%=s_select%>&s_word=<%=s_word%>"
					 style="<%=font%>">
			<%=i %>
			</a>
		<%	
		}
		%>
		&nbsp;&nbsp;
		
		<%
		if ( nextpageno == -1) {	out.print("[next]");  }
		else {
		%>
		<a href="postList.jsp?viewPage=<%=nextpageno%>&s_select=<%=s_select%>&s_word=<%=s_word%>">[next]</a>
		<%
		}
		%>
		<a href="postList.jsp?viewPage=<%=lastpageno%>&s_select=<%=s_select%>&s_word=<%=s_word%>">[lastpage]</a>
	</div>
	
	
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