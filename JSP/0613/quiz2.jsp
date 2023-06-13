<%@page import="java.util.Calendar"%>
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
Calendar cal = Calendar.getInstance();
String birthday = "20100115 20011225 19981102";

out.print("-------------------------<br>");

out.print("전송 데이터 : "+birthday);

out.print("<br>-------------------------<br>");

String[] br= birthday.split(" ");
int year = Integer.parseInt(br[0].substring(0,4));
out.print("데이터 1 : 나이(만 ");
out.print((cal.get(Calendar.YEAR)-year)+"세), 생일(");
out.print(br[0].substring(4,6)+"월 ");
out.print(br[0].substring(6,8)+"일)");

out.print("<br>-------------------------<br>");

int year1 = Integer.parseInt(br[1].substring(0,4));
out.print("데이터 1 : 나이(만 ");
out.print((cal.get(Calendar.YEAR)-year)+"세), 생일(");
out.print(br[1].substring(4,6)+"월 ");
out.print(br[1].substring(6,8)+"일)");

out.print("<br>-------------------------<br>");

int year2 = Integer.parseInt(br[2].substring(0,4));
out.print("데이터 1 : 나이(만 ");
out.print((cal.get(Calendar.YEAR)-year)+"세), 생일(");
out.print(br[2].substring(4,6)+"월 ");
out.print(br[2].substring(6,8)+"일)");

out.print("<br>-------------------------<br>");




%>
</body>
</html>