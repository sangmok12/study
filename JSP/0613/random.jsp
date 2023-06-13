<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- 주석처리 "Ctrl+Shift+/" -->
<%
Random random = new Random();

%>
<%=random.nextInt() %> <br>
<%=random.nextBoolean() %>
<%=random.nextLong() %>

<%=Math.random() %>

</body>
</html>