<%@ page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 속성 저장
pageContext.setAttribute("pageInteger", 1000); //pageInteger이라는 이름으로 100이라는 값을 pageContext에 저장.
pageContext.setAttribute("pageString", "페이지 영역의 문자열");//pageString이라는 이름으로 "페이지 ~~ 문자열"이라는 문자열을 pageContext에 저장.
pageContext.setAttribute("pagePerson", new Person("한석봉", 99)); //pagePerson이라는 이름으로 new Person이라는 객체를 pageContext에 저장. : 키, 값(객체 형태는 무조건 object) 세투세투
%>
<!DOCTYPE html>
<html>
<head><title>page 영역</title></head>
<body>
    <h2>page 영역의 속성값 읽기</h2>
    <%
    // 속성 읽기
    int pInteger = (Integer)(pageContext.getAttribute("pageInteger"));//pageContext에 저장되어있는 pageInteger이라는 것을 가져와라.
    String pString = pageContext.getAttribute("pageString").toString();
    Person pPerson = (Person)(pageContext.getAttribute("pagePerson"));
    %>
    <ul>
        <li>Integer 객체 : <%= pInteger %></li>
        <li>String 객체 : <%= pString %></li>
        <li>Person 객체 : <%= pPerson.getName() %>, <%= pPerson.getAge() %></li>
    </ul>

    <h2>include된 파일에서 page 영역 읽어오기</h2>
    <%@ include file="PageInclude.jsp" %>
    <!-- pageInclude가 위의 곳으로 전체 삽입이 되어 작동함.자바로 컨버전 되는 시점에서 삽입이 된다. -->
       
    <h2>페이지 이동 후 page 영역 읽어오기</h2>
    <a href="PageLocation.jsp">PageLocation.jsp 바로가기</a>
</body>
</html>