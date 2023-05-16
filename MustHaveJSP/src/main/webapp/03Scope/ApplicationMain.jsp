<%@ page import="java.util.HashMap"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import="common.Person"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>application 영역</title></head>
<body>
    <h2>application 영역의 공유</h2>
    <%
   // Map<String, Person> maps = new HashMap<>();
    Map<String, Object> maps = new HashMap<>();
    maps.put("actor1", new Person("이예둥", 26));
    maps.put("actor2", new Person("수현경듀님", 28));
    maps.put("actor3", new Person("원준좌보자관", 27));
    
    Map<String, Object> maps1 = new HashMap<>();

   
    
    //page
    maps1.put("pageInteger", 1000);
    maps1.put("pageString", "페이지 영역의 문자열");
    maps1.put("pagePerson", new Person("한석봉", 99));
    
    //Request
    maps1.put("requestString", "request 영역의 문자열");
    maps1.put("requestPerson", new Person("안중근", 31));
    
    //Session
	ArrayList<String> lists = new ArrayList<String>();
	lists.add("리스트");
 	lists.add("컬렉션");
    maps1.put("lists", lists);
    
    application.setAttribute("maps", maps);
    application.setAttribute("maps1", maps1);

    %>
    application 영역에 속성이 저장되었습니다.
</body>
</html>