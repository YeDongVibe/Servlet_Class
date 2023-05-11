<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! 
    public int add(int num1, int num2) {

    	return num1 + num2;
    }

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));
int result = add(10,20);
int res = num1 + num2;


%>
덧셈 결과 1 : <%= result  %> <br />
덧셈 결과 2 : <%= add(30,40) %> <br />
덧셈 결과 3 : <%= res %>
</body>
</html>