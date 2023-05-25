<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - forEach2</title>
</head>
<body>
	<h4>향상된 for문 형태의 forEach 태그</h4>
	<%
	//String 배열로 선언됨.
	String [] rgba = {"Red", "Green", "Blue", "Black"};
	%>
	<c:forEach items = "<%= rgba %>" var="c" >
	<span style = "color:${c};">${c }</span>
	</c:forEach>
	
	<h4>varStatus속성 살펴보기</h4>
	<table border="1">
	<c:forEach items="<%=rgba %>" var ="c" varStatus="loop">
	<tr>
		<!-- count : 1부터 5까지 증가 -->
	    <td>count : ${ loop.count }</td>
	    <!-- index : 1부터 5까지의 index값 -->
	    <td>index : ${ loop.index }</td>
	    <!-- current : items에서 rgba에 값으로 들어온 것을 표시 -->
	    <td>current : ${ loop.current }</td>
	    <td>first : ${ loop.first }</td>
	    <td>last : ${ loop.last }</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>