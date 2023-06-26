<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/oracleCon.jsp" %>

<%
Statement stmt = con.createStatement();

String unq = request.getParameter("unq");

String sql = "select title,name,content from reboard where unq ="+unq;
ResultSet rs = stmt.executeQuery(sql);
rs.next();

String title = rs.getString("title");
String name = rs.getString("name");
String content = rs.getString("content");
%>    
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>답변형 게시판 수정</title>
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
				<form name="frm" method="post" action="reBoardModifySave.jsp">
					<input type="hidden" name="unq" value="<%=unq%>">
					<table>
						<caption style="font-size: 20px; font-weith: bold;">수정화면</caption>
						<colgroup>
							<col width="20%" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" style="width: 99%"
								value="<%=title%>"></td>
						</tr>
						<tr>
							<th>암호</th>
							<td><input type="password" name="pass" style="width: 99%"></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" style="width: 99%"
								value="<%=name%>" readonly></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content"
									style="width: 99%; height: 100px";><%=content%></textarea></td>
						</tr>
					</table>
					<div style="width: 600px; margin-top: 10px; text-align: center;">
						<button type="submit" onclick="fn_submit();return false;">저장</button>
						<!--  submit은  엔터키로 넘기는 기능이 포함.  button 으로 하면 없음.   -->
						<button type="reset">취소</button>
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