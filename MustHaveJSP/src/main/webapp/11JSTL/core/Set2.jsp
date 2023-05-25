<%@ page import="common.Person"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Vector"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>JSTL - set 2</title></head>
<body>
    <h4>List 컬렉션 이용하기</h4>
    <%
    //List 컬렉션 생성
    ArrayList<Person> pList = new ArrayList<Person>();
    //Person객체 추가
    pList.add(new Person("성삼문", 55));
    pList.add(new Person("박팽년", 60));
    %>  
    <!-- request 영역에 personList라는 변수명으로 저장 -->
    <c:set var="personList" value="<%= pList %>" scope="request" />
    <ul>
        <li>이름 : ${ requestScope.personList[0].name }</li>
        <li>나이 : ${ personList[0].age }</li>
    </ul>

    <h4>Map 컬렉션 이용하기</h4>
    <%
    //hasmap:key랑 value가 세투세투
    Map<String, Person> pMap = new HashMap<String, Person>();
    pMap.put("personArgs1", new Person("하위지", 65));
    pMap.put("personArgs2", new Person("이개", 67));
    %>
    <c:set var="personMap" value="<%= pMap %>" scope="request" />
    <ul>
        <li>아이디 : ${ requestScope.personMap.personArgs2.name }</li>
        <li>비번 : ${ personMap.personArgs2.age }</li>
    </ul>
</body>
</html>