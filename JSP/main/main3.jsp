<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>    

<%
String viewPage1 = request.getParameter("viewPage1");
if ( viewPage1 == null ) {
	viewPage1 = "1";
}
int first_rn1 = Integer.parseInt(viewPage1)*5 - 4;
int last_rn1 = Integer.parseInt(viewPage1)*5;


String sql0 = " select count(*) total1 from board1";
Statement stmt0 = con.createStatement();
ResultSet rs0 = stmt0.executeQuery(sql0);
rs0.next();
int total1 = rs0.getInt("total1");

// 12.0/10  ->  ceil(1.2)   ->   2
int lastpage1 = (int)Math.ceil((double)total1/5);
int number1 = total1 - (Integer.parseInt(viewPage1)-1)*5;

String sql1 = " select b.* from( "
   			+ " select rownum rn,a.* from ( "
       	    + " select unq ,title ,name ,hits ,to_char(rdate,'yyyy-mm-dd') rdate " 
            + " from board1 order by unq desc ) a ) b "
            + " where rn >=" +first_rn1+ " and rn <= " + last_rn1 ;
Statement stmt1 = con.createStatement();
ResultSet rs1 = stmt1.executeQuery(sql1);
%>
<!--  답변형 게시판   -->

<%
String viewPage2 = request.getParameter("viewPage2");
if ( viewPage2 == null ) {
	viewPage2 = "1";
}
int first_rn2 = Integer.parseInt(viewPage2)*5 - 4;
int last_rn2 = Integer.parseInt(viewPage2)*5;


String sql3 = " select count(*) total2 from reboard where thread = 'a'";
Statement stmt3 = con.createStatement();
ResultSet rs3 = stmt0.executeQuery(sql3);
rs3.next();
int total2 = rs3.getInt("total2");

// 12.0/10  ->  ceil(1.2)   ->   2
int lastpage2 = (int)Math.ceil((double)total2/5);
int number2 = total2 - (Integer.parseInt(viewPage2)-1)*5 ;


String sql4 = " select b.* from( "
   			+ " select rownum rn,a.* from ( "
       	    + " select unq ,thread,title ,name ,hits ,to_char(rdate,'yyyy-mm-dd') rdate,gid " 
            + " from reboard where thread = 'a' order by gid desc, thread asc ) a ) b "
            + " where rn >=" +first_rn2+ " and rn <= " + last_rn2 ;
Statement stmt4 = con.createStatement();
ResultSet rs4 = stmt4.executeQuery(sql4);
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
	<!--  일반게시판 -->
	<table>
					<caption style="font-size: 20px; font-weith: bold;">게시판
						목록</caption>
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="15%" />
						<col width="10%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>등록일</th>
					</tr>
					<%
					
					while (rs1.next()) {
						String unq = rs1.getString("unq");
						String title = rs1.getString("title");
						String name = rs1.getString("name");
						String hits = rs1.getString("hits");
						String rdate = rs1.getString("rdate");
					%>
					<tr>
						<td><%=number1%></td>
						<td><a
							href="../board/board1Detail.jsp?unq=<%=unq%>&viewPage=<%=viewPage1%>"><%=title%></a></td>
						<td><%=name%></td>
						<td><%=hits%></td>
						<td><%=rdate%></td>
					</tr>
					<%
					number1--;
					}
					%>

				</table>

				<div style="width: 600px; margin-top: 10px; text-align: center;">
					<!--  페이징처리  -->
					<%
					for (int i = 1; i <= lastpage1; i++) {
					%>
					<a href="main3.jsp?viewPage1=<%=i%>&viewPage2=<%=viewPage2%>"><%=i%></a>
					<%
					}
					%>
				</div>

				<div style="width: 600px; margin-top: 5px; text-align: right;">
					<button type="button" onclick="location='../board/board1Write.jsp'">글쓰기</button>
				</div>
				
			
					<!--------- 답변형 게시판---------->

				<table>
					<caption style="font-size: 20px; font-weith: bold;">답변형
						게시판 목록</caption>
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="15%" />
						<col width="10%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>등록일</th>
					</tr>
					<%
					while (rs4.next()) {
						String unq = rs4.getString("unq");
						String title = rs4.getString("title");
						String name = rs4.getString("name");
						String hits = rs4.getString("hits");
						String rdate = rs4.getString("rdate");
						String gid = rs4.getString("gid");
						String thread = rs4.getString("thread");
					%>
					<tr>

						<td><%=number2%></td>
						<td><a	href="../board/reBoardDetail.jsp?unq=<%=unq%>&gid=<%=gid%>"><%=title%></a>
						</td>
						<td><%=name%></td>
						<td><%=hits%></td>
						<td><%=rdate%></td>
					</tr>
					<%
					number2--;
					}
					%>
				</table>
				<div style="width: 600px; margin-top: 10px; text-align: center;">
					<!--  페이징처리  -->
					<%
					for (int i = 1; i <= lastpage2; i++) {
					%>
					<a href="main3.jsp?viewPage2=<%=i%>&viewPage1=<%=viewPage1%>"><%=i%></a>
					<%
					}
					%>
				</div>

				<div style="width: 600px; margin-top: 10px; text-align: right;">
					<button type="button" onclick="location='../board/reBoardWrite.jsp'">글쓰기</button>
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