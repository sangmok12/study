<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PostTest</title>
</head>
<body>

	<!-- 	input 타입으로 자료를 받아서 getTest3_sub.jsp 로 전달해줌   -->
	<form name="frm" method="post" action="getTest3_sub.jsp">

	아이디 <input type="text" name="userid"> <br> 
	암호 <input type="text" name="pass"> <br> 
	이름 <input type="text"	name="name"> <br> 
	성별  남<input type="radio" name="gender"	value="M"> 
		 여<input type="radio" name="gender" value="F">  <br> 
		 <input type="submit" value="전송">

	</form>

</body>
</html>