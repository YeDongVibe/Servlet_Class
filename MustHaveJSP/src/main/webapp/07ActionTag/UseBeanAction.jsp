<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 테그 - useBean</title>
</head>
<body>
<h3>액션 태그로 폼값 한 번에 받기</h3>
<!-- common.person에 자동적으로 person이라는 이름(아이디)를 가진 참조변수를 생성하여 person이라는 이름을 가진 모든 변수를 가져옴 -->
<jsp:useBean id="person" class="common.Person"></jsp:useBean>
<jsp:setProperty property="*" name="person"/>

<ul>
<li>이름 : <jsp:getProperty name = "person" property = "name" /></li>

<li>나이 :  <jsp:getProperty name = "person" property = "age" /></li>

<li>학교 : <%= request.getParameter("school") %></li>
</ul>


</body>
</html>