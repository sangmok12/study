<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String address = "123456 서울시 강남구 논현동77";


out.print("길이 : " + address.length()+ "<br>");

String[] add = address.split(" ");
out.print("우편번호 : "+add[0]+ "<br>");
out.print("주소 : "+add[1]+" "+add[2]+" "+add[3]+ "<br>");

if (address.indexOf("논현")>-1) {
	out.print("검색단어 \"논현\" : 존재함");
} else {
	out.print("검색단어 \"논현\" : 존재하지 않음");
}




%>
</body>
</html>