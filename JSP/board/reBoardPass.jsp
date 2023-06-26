<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String unq = request.getParameter("unq");
%>

<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>layout2</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>
<Script>
function fn_submit() {
	var f = document.frm;
	if( f.pass.value == "" ){
		alert("암호를 입력해주세요.");
		f.pass.focus();    //커서를 위치하게 함
		return false;   //종료
	}
	f.submit();
}
</Script>
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
				<form name="frm" method="post" action="reBoardDelete.jsp">
					<input type="hidden" name="unq" value="<%=unq%>">
					<table>
						<caption style="font-size: 20px; font-weith: bold;">삭제화면</caption>
						<colgroup>
							<col width="20%" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>비밀번호 입력</th>
							<td><input type="password" name="pass"></input></td>
						</tr>
					</table>
					<div style="width: 600px; margin-top: 10px; text-align: center;">
						<button type="submit" onclick="fn_submit();return false;">삭제</button>
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