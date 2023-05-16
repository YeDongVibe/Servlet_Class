<%@ page import="java.util.Set"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import="common.Person"%>
<%@ page import="java.util.Map"%>
<%@ page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head><title>application 영역</title></head>
<body>
    <h2>application 영역의 속성 읽기</h2>
    <%
    Map<String, Person> maps = (Map<String, Person>)application.getAttribute("maps");
    Set<String> keys = maps.keySet(); 
    for (String key : keys) {
    	//object 타입으로 데이터를 가져옴.
        Person person = maps.get(key);
        out.print(String.format("key : %s, 이름 : %s, 나이 : %d<br/>", key, 
                person.getName(), person.getAge()));
    }  
    
    Map<String, Object> maps1 = (Map<String, Object>)application.getAttribute("maps1");
    Set<String> keys1 = maps1.keySet(); 
    for (String key : keys1) {
    	Object object = maps1.get(key);
    	if (object instanceof Person) {
    		Person person = (Person)object;
    		out.print(String.format("key : %s, 이름 : %s, 나이 : %d<br /> ",key, person.getName(), person.getAge()));
    	}
    	else if (object instanceof ArrayList) {
    		//object타입의 arraylist를 lists타입의 arraylist로 바꿈.
    		ArrayList<String> lists = (ArrayList<String>)object;
			for (String s : lists) {
					if (s instanceof String)
 				out.print(String.format("key : %s, 이름 : %s, 순서 : %d<br/>" , key, s, lists.indexOf(s)));
			}
    	}
    	else {
    		out.print(String.format("key : %s, Value : %s<br />", key, object));
    	}
    }
  
    %>
</body>
</html>