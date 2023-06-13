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

/* 외부에서 들여오는 정보는 무조건 String 타입임. */
/* 주소표기 뒤에 파라미터 값을 받음 getTest2.jsp 로 부터 링크로 전송받음. */
String eng = request.getParameter("eng");
String kor = request.getParameter("kor");
out.print(eng + "<br>");
out.print(kor);

%>
</body>
</html>