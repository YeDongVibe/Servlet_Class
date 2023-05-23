<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    pageContext.setAttribute("pAttr", "김유신");
    request.setAttribute("rAttr", "계백");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 테그 - forward</title>
</head>
<body>
<h2>액션 테그를 이용한 포워딩</h2>
<!-- forward사용시 이렇게 사용. -->
<jsp:forward page="/07ActionTag/ForwardSub.jsp" />
<!-- request방식으로 사용시 이렇게 사용 -->
<!-- request.getRequestDispatcher("/07ActionTag/ForwardSub.jsp").forward(request,response) -->

</body>
</html>