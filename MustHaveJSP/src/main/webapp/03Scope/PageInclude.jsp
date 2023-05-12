<%@ page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<!-- ==<!DOCTYPE html>이랑 같은 것. 둘중에 아무거나 써도 상관없대~~~ -->
<h4>Include 페이지</h4>
<%
//아래의 객체들이 pageContextMain의 객체들과 이름이 같으면 컨버전 하는 과정에서 포함되기에 동일 이름의 객체가 선언되어 중복이 생겨 버린다. 그래서 에러가 생기는 것임.
//그걸 방지하고자 각 객체에 대해 2를 붙여 서로다른 객체임을 명시했음.
int pInteger2 = (Integer)(pageContext.getAttribute("pageInteger"));
String pString2 = pageContext.getAttribute("pageString").toString();
Person pPerson2 = (Person)(pageContext.getAttribute("pagePerson"));
%>
<ul>
	<li>Integer 객체 : <%= pInteger2 %></li>
	<li>String 객체 : <%= pageContext.getAttribute("pageString") %></li>
	<li>Person 객체 : <%= pPerson2.getName() %>, <%= pPerson2.getAge() %></li>
</ul>
