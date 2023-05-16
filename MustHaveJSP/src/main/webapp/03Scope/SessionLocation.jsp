<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 영역</title>
</head>
<body>
<h2>페이지 이동 후 session 영역의 속성 읽기</h2>
<%
ArrayList<?> lists = (ArrayList<?>)session.getAttribute("lists");
for(Object str : lists)
	if(str instanceof String)
	out.print(str + "<br/>");

ArrayList<String> lists1 = (ArrayList<String>)session.getAttribute("lists");
for(String str : lists1)
	out.print(str + "<br/>");
%>

</body>
</html>