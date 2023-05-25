<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSTL - import</title></head>
<!-- include는 내부 파일을 불러올수 있지만 import는 외부 사이트 또한 불러와 보여줄 수 있음 -->
<body>
    <c:set var="requestVar" value="MustHave" scope="request" />
    <!-- contents라는 변수명으로 url에 저장 -->
    <c:import url="/11JSTL/inc/OtherPage.jsp" var="contents">
        <c:param name="user_param1" value="JSP" />
        <c:param name="user_param2" value="기본서" />
    </c:import>       
    
    <h4>다른 문서 삽입하기</h4>
    ${contents }
    
    <h4>외부 자원 삽입하기</h4>    
    <!-- 공간을 frame으로 분리하여 다른 브라우져를 불러와서 사용 가능 -->
    <iframe src="../inc/GoldPage.jsp" style="width:100%;height:600px;"></iframe>
</body>
</html>