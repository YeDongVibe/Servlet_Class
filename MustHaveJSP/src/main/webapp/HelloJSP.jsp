<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<%!
	//선언부(변수,함수 등등)
	String str1 = "JSP";
	String str2 = "안뇽하세욤";
	%>
	
	<h2>
		처음 만들어 보는
		<%=str1%></h2>
	<p>
		<%
		out.print(str2 + str1 + "입니당! 열공하자고라고라뿌뿌^^");
		%>
	</p>
</body>
</html>