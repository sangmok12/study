<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/oracleCon.jsp" %>
<!-- 세션아이디 가져오기 -->    
<%
String memberId = (String)session.getAttribute("SessionUserId");

String sql = " select userid "
   	   	   + "       ,userpw "
   	   	   + "       ,name "
   	   	   + "       ,gender "
   	   	   + "       ,to_char(birthday,'yyyy-mm-dd') as birthday "
   	   	   + "       ,phone "
   	   	   + "       ,zipcode "
   	   	   + "       ,addr "
   	   	   + "       ,hobby "
   	   	   + "       ,email "
   	   	   + "       ,homepage "
   	   	   + " from memberinfo "
		   + " where userid = '"+memberId+"'";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);
if ( rs.next() == false ) {
	session.removeAttribute("SessionUserId");
%>	
	<script>
	alert("다시 로그인을 해주세요.");
	location="../member/loginWrite.jsp";
	</script>
	
<%	
}


String userid      = rs.getString("userid");
String userpw      = rs.getString("userpw");
String name        = rs.getString("name");
String gender      = rs.getString("gender");
String birthday    = rs.getString("birthday");
String phone       = rs.getString("phone");
String zipcode     = rs.getString("zipcode");
String addr        = rs.getString("addr");
String hobby       = rs.getString("hobby");
String email       = rs.getString("email");
String homepage    = rs.getString("homepage");


String[] pp = phone.split("-");
String[] b  = birthday.split("-");
int b1 = Integer.parseInt(b[0]);
int b2 = Integer.parseInt(b[1]);
int b3 = Integer.parseInt(b[2]);


String h1 = (hobby.indexOf("바둑")>-1? "checked" : "");
String h2 = (hobby.indexOf("장기")>-1? "checked" : "");
String h3 = (hobby.indexOf("체스")>-1? "checked" : "");

%>


    
    
    
    
    
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>회원정보 수정</title>
 <link rel="stylesheet" href="../css/layout.css">
</head>
<style>

td { text-align:left;     }
.input1 {	width : 80%;  }
.input2 {	width : 70px; }


</style>
<script>

function fn_passChange() {
	var url = "passChange.jsp";
	window.open(url,"passChange","width=600,height=300");
}

function fn_popup() {
	var url = "post1.jsp";
	// (url,별칭,옵션)
	window.open(url,"post","width=500,height=200");
}



function fn_submit() {
	var f = document.frm;
	if( f.userid.value.length < 6 || 
		f.userid.value.legnth > 12 ) {
		alert("아이디는 6 ~ 12자리 사이로 만들어주세요.");
		f.userid.focus();
		return false;
	}
	if( f.userpw.value.length < 6 || 
		f.userpw.value.legnth > 20 ) {
		alert("암호는 6 ~ 20자리 사이로 만들어주세요.");
		f.userpw.focus();
		return false;
	}
	if( f.name.value == "" )  {
		alert("이름을 작성해주세요.");
		f.name.focus();
		return false;
	}
	if( f.p2.value == "" ||
		f.p3.value == ""  )  {
		alert("핸드폰 번호를 입력해주세요.");
		f.p2.focus();
		return false;
	}
	
	var hobby = document.getElementsByName("hobby");
	var len = hobby.length;
	var cnt = 0;
	for( var i=0; i<len; i++ ) {
		if ( hobby[i].checked == true) {
			cnt++;
		}
	}
	if (cnt == 0) {
		alert("취미를 선택해주세요.");
		return false;
	}
	f.submit();
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
<form name="frm" method="post" action="memberModifySave.jsp">
	<table>
		<tr>
			<th>*아이디</th>
			<td>
				<%=memberId %>
			</td>
		</tr>
		<tr>
			<th>*암호</th>
			<td><button type = "button" onclick="fn_passChange()">암호변경</button></td>
		</tr>
		<tr>
			<th>*이름</th>
			<td><input type="text" name="name" class="input1" value=<%=name %>></td>
		</tr>
		<tr>
			<th>*성별</th>
			<td>
				<select name="gender"  selected=<%=gender %>>
					<option value="M" <%= gender.equals("M") ? "selected" : "" %>>남성</option>
					<option value="F" <%= gender.equals("F") ? "selected" : "" %>>여성</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>*생일</th>
			<td> 
				<select name="year">
				<%
				for( int yy=1940; yy <=2022; yy++) {
				%>
					<option value="<%=yy%>" <%if(yy==b1){ %>selected<%}%>><%=yy%></option>
				<%
				}
				%>	
				</select>년
				<select name="month">
				<%
				for( int mm=1; mm <=12; mm++) {
				%>
					<option value="<%=mm%>" <%if(mm==b2){ %>selected<%}%>><%=mm%></option>
				<%
				}
				%>	
				</select>월
				<select name="day">
				<%
				for( int dd=1; dd <=31; dd++) {
				%>
					<option value="<%=dd%>" <%if(dd==b3){ %>selected<%}%>><%=dd%></option>
				<%
				}
				%>	
				</select>일
			</td>
		</tr>
		<tr>
			<th>*핸드폰</th>
			<td>
				<select name="p1">
					<option value="010" <%= pp[0].equals("010") ? "selected" : "" %>>010</option>
					<option value="011" <%= pp[0].equals("011") ? "selected" : "" %>>011</option>
					<option value="016" <%= pp[0].equals("016") ? "selected" : "" %>>016</option>
				</select>
				<input type="number" name="p2" class="input2" value="<%=pp[1]%>">
				<input type="number" name="p3" class="input2" value="<%=pp[2]%>">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
			<div style="line-height:2.0;">
				<input type="number" name="zipcode" value=<%=zipcode %>>
				<button type="button" onclick="fn_popup()">우편번호찾기</button>
				<br>
				<input type="text" name="addr" class="input1" value=<%=addr %>>
			</div>
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<input type="checkbox" name="hobby" value="바둑" <%=h1 %>>바둑, 
				<input type="checkbox" name="hobby" value="장기" <%=h2 %>>장기, 
				<input type="checkbox" name="hobby" value="체스" <%=h3 %>>체스
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" class="input1" value=<%=email %>></td>
		</tr>
		<tr>
			<th>홈페이지</th>
			<td><input type="url" name="homepage" class="input1" value=<%=homepage %>></td>
		</tr>
	</table>
	<div style="width:600px; 
				text-align:center;
				margin-top:10px;">
		<button type="submit" onclick="fn_submit();return false;">저장</button>
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